package Templates;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    public static void main(String[] args) {
        int V = 5; // 背包总容积
        int N = 4; // 物品种类数量
        int[] w = new int[N];
        int[] v = new int[N];
        v[0] = 1;
        w[0] = 2;
        v[1] = 2;
        w[1] = 4;
        v[2] = 3;
        w[2] = 4;
        v[3] = 4;
        w[3] = 5;

        // https://oi-wiki.org/dp/knapsack/
        // f(i,W) = max( f(i-1,W) , f(i,W-w[i])+v[i] )
        // 上式是 0-1 背包和完全背包的精髓公式，每个物品有两种状态，选和不选。
        int ans = zeroOnePack(w, v, V);
        System.out.println(ans);
        ans = fullPack(w, v, V);
        System.out.println(ans);
    }

    // 每个游戏只玩一次：0-1 背包问题
    // w[i]     物品 i 的价值
    // v[i]     物品 i 的体积
    // V        背包总容积
    public static int zeroOnePack(int[] w, int[] v, int V) {
        int N = w.length; // 物品种类数量
        int[] dp = new int[V + 1];
        dp[0] = 0; // 背包总容量为 0 时，最大收益为 0

        // 首先，遍历每个物品
        for (int i = 0; i < N; i++) {
            // 然后，检查当背包容量为 v[i] ~ V 时，把物品 i 放入背包是否能增大收益
            // 注意这里是 ~~ 反向 ~~ 更新
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }

        return dp[V];
    }

    // 完全背包问题，无限制多次取物品
    // w[i]     物品 i 的价值
    // v[i]     物品 i 的体积
    // V        背包总容积
    public static int fullPack(int[] w, int[] v, int V) {
        int N = w.length; // 物品种类数量
        int[] dp = new int[V + 1];
        dp[0] = 0; // 背包总容量为 0 时，最大收益为 0

        // 首先，遍历每个物品
        for (int i = 0; i < N; i++) {
            // 然后，检查当背包容量为 v[i] ~ V 时，把物品 i 放入背包是否能增大收益
            // 注意这里是 ~~ 正向 ~~ 更新
            for (int j = v[i]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        return dp[V]; // 返回最大价值
    }

    // 多重背包：01 背包的变种，有 k 个相同的物品，每个物品选一次
    // w[i]     物品 i 的价值
    // v[i]     物品 i 的体积
    // s[i]     物品 i 的个数
    // V        背包总容积
    // 暴力解法
    public static int multiPack1(int[] v, int[] w, int[] s, int V) {
        int N = v.length;
        int[] dp = new int[V + 1];
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[V];
    }

    // 多重背包：01 背包的变种，有 k 个相同的物品，每个物品选一次
    // w[i]     物品 i 的价值
    // v[i]     物品 i 的体积
    // s[i]     物品 i 的个数
    // V        背包总容积
    // 二进制优化
    public static int multiPack2(int[] v, int[] w, int[] s, int V) {
        int N = v.length;
        int[] dp = new int[V + 1];
        dp[0] = 0;

        List<Goods> goods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int k = 1; k < s[i]; k *= 2) {
                s[i] -= k;
                goods.add(new Goods(v[i] * k, w[i] * k));
            }
            if (s[i] > 0) {
                goods.add(new Goods(v[i] * s[i], w[i] * s[i]));
            }
        }

        for (Goods good : goods) {
            for (int j = V; j >= good.v; j--) {
                dp[j] = Math.max(dp[j], dp[j - good.v] + good.w);
            }
        }

        return dp[V];
    }

    // 多重背包：01 背包的变种，有 k 个相同的物品，每个物品选一次
    // https://www.acwing.com/problem/content/solution/6/1/
    // w[i]     物品 i 的价值
    // v[i]     物品 i 的体积
    // s[i]     物品 i 的个数
    // V        背包总容积
    // 单调队列优化
    public static int multiPack3(int[] v, int[] w, int[] s, int V) {
        int N = v.length;

        int[] dp = new int[V + 1];
        int[] tmp = new int[V + 1];
        int[] deque = new int[V + 1];

        for (int i = 0; i < N; i++) {
            System.arraycopy(dp, 0, tmp, 0, dp.length);
            for (int j = 0; j < v[i]; j++) {
                int left = 0, right = -1; // left 表示队头，right 表示队尾
                for (int k = j; k <= V; k += v[i]) {
                    dp[k] = tmp[k];
                    if (left <= right && k - s[i] * v[i] > deque[left]) {
                        left++;
                    }
                    if (left <= right) {
                        dp[k] = Math.max(dp[k], tmp[deque[left]] + (k - deque[left]) / v[i] * w[i]);
                    }
                    while (left <= right && tmp[deque[right]] - (deque[right] - j) / v[i] * w[i] <= tmp[k] - (k - j) / v[i] * w[i]) {
                        right--;
                    }
                    deque[++right] = k;
                }
            }
        }

        return dp[V];
    }
}

class Goods {
    int v;
    int w;

    Goods(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
