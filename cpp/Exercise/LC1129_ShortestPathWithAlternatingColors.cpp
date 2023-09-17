#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class LC1129_ShortestPathWithAlternatingColors {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>> &redEdges, vector<vector<int>> &blueEdges) {

        vector<vector<pair<int, int>>> graph(n); // 三元组
        vector<vector<int>> visited(n, vector<int>(2, 0)); // 二元组

        for (auto &edge: redEdges) {
            int from = edge[0];
            int to = edge[1];
            // 一个 from 可能对应多个 to 节点，每个 to 节点都有一个颜色属性
            graph[from].push_back({to, 0});
        }

        for (auto &edge: blueEdges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].push_back({to, 1});
        }

        queue<vector<int>> q;
        vector<int> dis(n, INT_MAX);

        dis[0] = 0;
        q.push({0, 0, 1}); // 节点 距离 颜色
        q.push({0, 0, 0});

        while (!q.empty()) {
            // 当前节点
            auto it = q.front();
            int from = it[0];       // 当前节点的值
            int distance = it[1];   // 当前节点与 0 的距离
            int curColor = it[2];   // 当前节点的颜色

            q.pop();
            for (auto &[to, nextColor]: graph[from]) {
                if (nextColor == !curColor && !visited[to][nextColor]) {
                    dis[to] = min(dis[to], distance + 1);
                    q.push({to, distance + 1, nextColor});
                    visited[to][nextColor] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dis[i] == INT_MAX) {
                dis[i] = -1;
            }
        }

        return dis;
    }
};
