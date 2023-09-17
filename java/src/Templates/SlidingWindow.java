package Templates;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import Generator.RandomArrayGenerator;

public class SlidingWindow {

    // 单调队列，要始终维持队列递增或递减的状态。
    // 递增（减）队列的队头是最小（大）值。
    public static int[] maxSlidingWindow(int[] nums, int windowSize) {

        int[] ans = new int[nums.length - windowSize + 1];

        Deque<Integer> deque = new LinkedList<>();

        // r 表示滑动窗口右边界
        for (int r = 0; r < nums.length; r++) {

            // 移除队尾比当前值小的元素的索引
            while (!deque.isEmpty() && nums[r] >= nums[deque.peekLast()])
                deque.removeLast();

            deque.addLast(r);           // 存储元素下标

            int l = r - windowSize + 1;         // 窗口左边界

            if (deque.peekFirst() < l)  //超出左边界
                deque.removeFirst();

            if (r + 1 >= windowSize)            // 若已经形成窗口
                ans[l] = nums[deque.peekFirst()];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = RandomArrayGenerator.generateRamdomArray(10, 20);
        System.out.println(Arrays.toString(nums));

        // 在窗口大小为 3 时，每次向右移动窗口，都要输出一个当前窗口的最大值
        int[] ans = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ans));
    }
}
