package LeetCode;

import java.util.Arrays;

public class LC0743_NetworkDelayTime {

    int N = 110, M = 6010;
    int[][] w = new int[N][N];      // 开辟一个比实际需求更大的矩阵可以避免越界问题？这么理解对吗？
    int[] dist = new int[N];        // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
    boolean[] vis = new boolean[N]; // 记录哪些点已经被更新过
    int INF = 0x3f3f3f3f;           // ACMer 喜欢将无穷大设置为该值，因为通常题目要求数据小于 10^9
    int n, k;

    public int networkDelayTime(int[][] times, int _n, int _k) {
        n = _n;
        k = _k;

        // 初始化邻接矩阵：先将对角线设置为 0 非对角线设置为无穷大
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }

        // 存图
        // 邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
        for (int[] t : times) {
            int u = t[0], v = t[1], c = t[2];
            w[u][v] = c;
        }

        // 最短路
        dijkstra();

        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        // 如果结果是一个很大的数字 比如 INF/2 也试做不可达
        return ans > INF / 2 ? -1 : ans;
    }

    // 更新 dist 数组
    void dijkstra() {
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[k] = 0;
        // 迭代 n 次
        for (int p = 1; p <= n; p++) {
            // 每次找到「最短距离最小」且「未被更新」的点 t
            int t = -1;
            for (int i = 1; i <= n; i++) {
                // t == -1 保证第一个点可以进入到该 if 条件中
                if (!vis[i] && (t == -1 || dist[i] < dist[t]))
                    t = i;
            }
            // 标记点 t 为已更新
            vis[t] = true;
            // 用点 t 的「最小距离」更新其他点
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], dist[t] + w[t][i]);
            }
        }
    }

    void floyd() {
        // floyd 基本流程为三层循环：
        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j] = Math.min(w[i][j], w[i][p] + w[p][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{{1, 2, 1}};
        int ans = new LC0743_NetworkDelayTime().networkDelayTime(times, 2, 2);
        System.out.println(ans);
    }

}
