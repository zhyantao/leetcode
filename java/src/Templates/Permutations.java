package Templates;

import java.util.*;

import Generator.RandomArrayGenerator;

// 参考力扣 47 题，全排列 II
public class Permutations {

    // 如果 nums[i] 的长度 > 12，很容易发生栈溢出
    public static List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        if (len == 0) {
            return ans;
        }

        Arrays.sort(nums); // 对于含有重复元素的列表进行去重，排序很关键
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, ans);

        return ans;
    }

    // 分析递归最好的方法就是画递归树
    // https://leetcode.cn/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
    public static void dfs(int[] nums, int len, int depth, boolean[] used,
                           Deque<Integer> path, List<List<Integer>> ans) {

        if (depth == len) {
            ans.add(new ArrayList<>(path)); // 深拷贝
            return;
        }

        for (int i = 0; i < len; i++) {
            // 如果当前值被使用了，跳过
            if (used[i]) {
                continue;
            }

            // 剪枝操作：
            // 1）如果 nums[i-1] 的状态是被选择的，说明当前的 nums[i] 是 nums[i-1] 的下一层路径
            // 2）如果 nums[i-1] 的状态是没被选择的，那么说明当前的 nums[i] 是 nums[i-1] 同层路径
            // 解释：因为 used[i] = true 在这个 if 判断的后面才会被执行
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            // 递归调用条件
            dfs(nums, len, depth + 1, used, path, ans);

            used[i] = false; // 撤销原操作，和 label 之前的代码是对称的
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = RandomArrayGenerator.generateRamdomArray(10, 20);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }

}
