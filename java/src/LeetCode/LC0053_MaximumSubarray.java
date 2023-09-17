package LeetCode;

public class LC0053_MaximumSubarray {

    // 最大长度的子数组
    // 找到具有最大和的连续子数组
    public static int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ans = Math.max(dp[i], ans);
        }

        return ans;

    }

}
