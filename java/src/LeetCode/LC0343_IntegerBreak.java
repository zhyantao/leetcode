package LeetCode;

public class LC0343_IntegerBreak {

    public static int integerBreak(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 2; j <= i / 2; j++) {
                int tmp = dp[j] * dp[i - j];
                max = max < tmp ? tmp : max;
            }

            dp[i] = max;
        }

        return dp[n];
    }

}
