package Templates;

import java.util.Arrays;
import java.util.Stack;

import Generator.RandomArrayGenerator;

public class MonotonousStack {

    // 获取数组 nums 中每个元素，后面比它【大或等于】的第一个元素的下标
    public static int[] getFirstBiggerIndex(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // 注意：从后往前遍历，ans[i] 更新在 while 循环外面
        // 从前往后遍历的话，ans[i] 的更新在 while 循环里面
        for (int i = nums.length - 1; i >= 0; i--) {
            // 【stack 中存储的是数组下标】 < 表示单调不减，<= 表示单调递增
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            // 如果后面没有比它大的元素，返回 -1
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    // 获取数组 nums 中每个元素，后面比它【小】的第一个元素的下标
    public static int[] getFirstSmallerIndex(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        // 注意：从后往前遍历，ans[i] 更新在 while 循环外面
        // 从前往后遍历的话，ans[i] 的更新在 while 循环里面
        for (int i = nums.length - 1; i >= 0; i--) {
            // 【stack 中存储的是数组下标】 >= 表示单调递减，> 表示单调不增
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            // 如果后面没有比它小的元素，返回 -1
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    // 单调栈
    public static void main(String[] args) {
        int[] nums = RandomArrayGenerator.generateRamdomArray(6, 9);

        System.out.println(Arrays.toString(nums));

        int[] ans = getFirstBiggerIndex(nums);
        System.out.println(Arrays.toString(ans));

        ans = getFirstSmallerIndex(nums);
        System.out.println(Arrays.toString(ans));
    }

}
