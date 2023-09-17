package LeetCode;

public class LC0279_PerfectSquares {

    public static int numSquares(int n) {

        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // 外层循环更新 dp[i]
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 内层循环从 j 到 i 寻找最小的 dp[j]
            for (int j = 1; j <= Math.sqrt(i); j++) {
                min = Math.min(dp[i - j * j], min); // 记录最小值 dp[j]
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }

}
