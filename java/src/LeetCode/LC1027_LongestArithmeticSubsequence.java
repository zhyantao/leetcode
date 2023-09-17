package LeetCode;

public class LC1027_LongestArithmeticSubsequence {

    public static int longestArithSeqLength(int[] nums) {

        int[][] dp = new int[nums.length][1001];

        int maxLen = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // d 是公差，+500 是因为把公差都拉为正数
                // i 和 j 分别指向 nums[i] 和 nums[j]
                // 双层暴力递归
                int d = nums[i] - nums[j] + 500;
                dp[i][d] = dp[j][d] + 1;
                maxLen = Math.max(maxLen, dp[i][d]);
            }
        }

        return maxLen + 1;

    }

}
