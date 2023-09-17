#include "bits/stdc++.h"

using namespace std;

class UnionFind {
public:
    int find(int x) {
        int root = x;

        // 找到 x 的最父节点
        while (father[root] != -1) {
            root = father[root];
        }

        // 路径压缩：从 x 到 root 路径上的所有点都指向 root
        while (x != root) {
            int originalFather = father[x];
            father[x] = root; // x -> root
            x = originalFather; // x 向上移动
        }

        return root;
    }

    bool isConnected(int x, int y) {
        return find(x) == find(y);
    }

    void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            father[rootX] = rootY;
        }
    }

    void add(int x) {
        if (!father.count(x)) {
            father[x] = -1;
        }
    }

private:
    unordered_map<int, int> father;
};