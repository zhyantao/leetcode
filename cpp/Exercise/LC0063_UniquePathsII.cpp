#include "bits/stdc++.h"

using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        vector<vector<int>> dp(m + 1, vector<int>(n + 1));

        // 初始化边界条件：第一列
        int flag = false;
        for (int i = 1; i <= m; i++) {
            if (!flag && obstacleGrid[i - 1][0] == 0) {
                dp[i][1] = 1;
            } else {
                dp[i][1] = 0;
                flag = true;
            }
        }
        // 初始化边界条件：第一行
        flag = false;
        for (int i = 1; i <= n; i++) {
            if (!flag && obstacleGrid[0][i - 1] == 0) {
                dp[1][i] = 1;
            } else {
                dp[1][i] = 0;
                flag = true;
            }
        }

        // 计算转移方程
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m][n];
    }
};