package LeetCode;

// 打家劫舍 II
public class LC0213_HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            arr1[i] = nums[i];
            arr2[i] = nums[i + 1];
        }

        return Math.max(rob_198(arr1), rob_198(arr2));
    }

    public int rob_198(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // 将第 i - 1 间房分两种情况讨论：偷和不偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
