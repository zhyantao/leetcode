package LeetCode;

public class LC0765_CouplesHoldingHands {

    int[] p = new int[70];

    int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

    void union(int x, int y) {
        p[find(x)] = p[find(y)];
    }

    public int minSwapsCouples(int[] row) {

        int n = row.length; // 这里的 n 一定是偶数
        int m = n / 2; // 这里的 m 代表一共有多少对情侣

        // 对每个连通分量进行初始化，即一对情侣代表一个连通分量
        for (int i = 0; i < m; i++) {
            p[i] = i;
        }

        // 这里对当前的连通分量进行合并
        // 如果所有情侣都坐对了，那么连通分量一共有 m 对
        // 如果两对情侣做错了，那么这两个连通分量就会合并为 1 个
        for (int i = 0; i < n; i += 2) {
            union(row[i] / 2, row[i + 1] / 2);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (p[i] == i)
                count++; // 统计还剩多少个连通分量
        }

        // 排列错误的情侣对数 = 连通分量个数 + 1
        return m - count; // 最少需要调整的次数 = 错误的情侣对数 - 1
    }
}
