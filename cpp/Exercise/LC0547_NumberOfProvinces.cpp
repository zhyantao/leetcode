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

        // 路径压缩
        while (x != root) {
            int original_father = father[x];
            father[x] = root; // x -> root
            x = original_father;
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
            numOfSets--;
        }
    }

    void add(int x) {
        if (!father.count(x)) {
            father[x] = -1;
            numOfSets++;
        }
    }

    int getNumOfSets() {
        return numOfSets;
    }

private:
    unordered_map<int, int> father; // key 本节点 value 父节点
    int numOfSets = 0;
};

class Solution {
public:
    int findCircleNum(vector<vector<int>> &isConnected) {
        UnionFind uf;
        for (int i = 0; i < isConnected.size(); i++) {
            uf.add(i);
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j]) {
                    uf.merge(i, j);
                }
            }
        }
        return uf.getNumOfSets();
    }
};

int main() {
    ifstream fin; // 读文件，相对路径是相对于可执行文件
    fin.open("../input.txt", ios::in);

    int n;
    fin >> n;
    vector<vector<int>> nums(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            fin >> nums[i][j];
        }
    }

    auto *solution = new Solution();
    int ans = solution->findCircleNum(nums);
    cout << ans << endl;
}