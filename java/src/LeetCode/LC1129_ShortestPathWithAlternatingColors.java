package LeetCode;

import java.util.*;

public class LC1129_ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 创建图结构
        // graph[i] 表示 from 是 i， to 是添加进来的元素
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : redEdges) {
            int from = edge[0];
            int to = edge[1];
            // 创建从 from 指向 to 的图结构
            graph.get(from).add(new int[]{to, 0}); // 0 表示红色
        }
        for (int[] edge : blueEdges) {
            int from = edge[0];
            int to = edge[1];
            // 创建从 from 指向 to 的图结构
            graph.get(from).add(new int[]{to, 1}); // 1 表示蓝色
        } // 图结构创建完成

        boolean[][] visited = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0}); // 三元组 {curNode, distance, color}
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        visited[0][1] = true;

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int curNode = arr[0];
            int distanceToStart = arr[1];
            int curNodeColor = arr[2];
            for (int[] it : graph.get(curNode)) {
                int nextNode = it[0];
                int nextNodeColor = it[1];
                if (curNodeColor != nextNodeColor && !visited[nextNode][nextNodeColor]) {
                    ans[nextNode] = Math.min(ans[nextNode], distanceToStart + 1);
                    queue.offer(new int[]{nextNode, distanceToStart + 1, nextNodeColor});
                    visited[nextNode][nextNodeColor] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE)
                ans[i] = -1;
        }

        return ans;
    }

}
