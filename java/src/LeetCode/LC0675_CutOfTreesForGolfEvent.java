package LeetCode;

import java.util.*;

// 为高尔夫比赛砍树
public class LC0675_CutOfTreesForGolfEvent {

    int N = 50;
    int[][] g = new int[N][N]; // 从 List 转为二维数组，存储到这里
    int n, m;

    public int cutOffTree(List<List<Integer>> forest) {
        n = forest.size();
        m = forest.get(0).size();
        List<int[]> list = new ArrayList<>();

        // 将 List 转为 int[][]，并把所有树添加到 list 中
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = forest.get(i).get(j);
                if (g[i][j] > 1)
                    list.add(new int[]{g[i][j], i, j}); // 三元组：树高、横坐标，纵坐标
            }
        }
        // 将所有的树从低到高排序
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // bfs 遍历
        int x = 0, y = 0, ans = 0; // 从 0,0 开始找到下一步应该砍的位置
        for (int[] ne : list) {
            int nx = ne[1], ny = ne[2]; // 当前位置
            int d = bfs(x, y, nx, ny);
            if (d == -1)
                return -1;
            ans += d;
            x = nx; // x = next x
            y = ny; // y = next y
        }
        return ans;
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int bfs(int X, int Y, int P, int Q) {
        // 如果当前位置就是最低的树，不需要走动，就可以直接砍树
        if (X == P && Y == Q)
            return 0;

        boolean[][] vis = new boolean[n][m]; // 记录走过的位置
        Deque<int[]> d = new ArrayDeque<>(); // 用位置坐标 x,y 进行 bfs

        d.addLast(new int[]{X, Y});
        vis[X][Y] = true;

        int ans = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                int[] info = d.pollFirst();
                int x = info[0], y = info[1];
                for (int[] di : dirs) { // 遍历上下左右四个方向
                    int nx = x + di[0], ny = y + di[1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (g[nx][ny] == 0 || vis[nx][ny])
                        continue;

                    if (nx == P && ny == Q) // 如果走到了目标点
                        return ans + 1;

                    d.addLast(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            ans++;
        }
        return -1;
    }

}
