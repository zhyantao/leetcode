package LeetCode;

public class LC0741_CherryPickup {

    static int N = 55;
    static int INF = Integer.MIN_VALUE;
    static int[][][] dp = new int[2 * N][N][N];

    public int cherryPickup(int[][] g) {
        int n = g.length;

        // 因为设置了 N = 55 有一些格子是不能触碰的
        // 需要将其设置为负数
        for (int k = 0; k <= 2 * n; k++) {
            for (int i1 = 0; i1 <= n; i1++) {
                for (int i2 = 0; i2 <= n; i2++) {
                    dp[k][i1][i2] = INF;
                }
            }
        }

        dp[2][1][1] = g[0][0]; // 为了方便，dp 矩阵的横纵坐标从 1,1 开始

        for (int k = 3; k <= 2 * n; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {

                    int j1 = k - i1; // 第一个点的纵坐标
                    int j2 = k - i2; // 第二个点的纵坐标

                    if (j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) {
                        continue;
                    }

                    int A = g[i1 - 1][j1 - 1]; // 第一个点
                    int B = g[i2 - 1][j2 - 1]; // 第二个点

                    // 碰到障碍物应该寻找下一个点
                    if (A == -1 || B == -1) {
                        continue;
                    }

                    // 四个状态
                    int a = dp[k - 1][i1 - 1][i2];
                    int b = dp[k - 1][i1 - 1][i2 - 1];
                    int c = dp[k - 1][i1][i2 - 1];
                    int d = dp[k - 1][i1][i2];

                    // 当前状态等于前一个状态的最大值加上当前奖励
                    int t = Math.max(Math.max(a, b), Math.max(c, d)) + A;
                    if (i1 != i2) { // 因为 A 摘过樱桃后，B 就不能摘了
                        t += B;
                    }

                    dp[k][i1][i2] = t;
                }
            }
        }
        return Math.max(dp[2 * n][n][n], 0);
    }
}
