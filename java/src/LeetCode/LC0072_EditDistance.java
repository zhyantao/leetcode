package LeetCode;

public class LC0072_EditDistance {

    public static int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // 结束条件，其中一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // 动态规划
        int[][] dp = new int[n + 1][m + 1];

        // 初始化 dp 数组边界条件
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // 计算所有 dp 值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i - 1][j] + 1;
                int top = dp[i][j - 1] + 1;
                int top_left = dp[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    top_left += 1;
                }

                dp[i][j] = Math.min(left, Math.min(top, top_left));
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {
        int ans = minDistance("ABC", "BDC");
        System.out.println(ans);
    }

}
