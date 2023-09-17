#include "bits/stdc++.h"

using namespace std;

class UnionFind {
public:
    int find(int x) {
        int root = x;
        while (father[root] != -1) {
            root = father[root];
        }
        while (x != root) {
            int originalFather = father[x];
            father[x] = root;
            x = originalFather;
        }
        return root;
    }

    void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            father[rootX] = rootY;
            numOfAreas--;
        }
    }

    void add(int x) {
        if (!father.count(x)) {
            father[x] = -1;
            numOfAreas++;
        }
    }

    int getNumOfAreas() {
        return numOfAreas;
    }

private:
    unordered_map<int, int> father;
    int numOfAreas = 0;
};

class Solution {
public:
    int numIslands(vector<vector<char>> &grid) {

        UnionFind uf;

        int n = grid.size();
        int m = grid[0].size();

        // 打印岛屿形状
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                cout << grid[i][j] << " ";
                int cur = i * n + j;
                if (grid[i][j] == '1') {
                    uf.add(cur);
                }
            }
//            cout << endl;
        }

//        cout << uf.getNumOfAreas() << endl;

        // 对于不规则图形，应该把它拉成一条，用下面的公式
        // curPos = i * n + j
        // leftPos = i * n + j - 1
        // rightPos = i * n + j + 1
        // upPos = (i - 1) * n + j
        // downPos = (i + 1) * n + j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = i * n + j;
                int left = i * n + j - 1;
                int right = i * n + j + 1;
                int up = (i - 1) * n + j;
                int down = (i + 1) * n + j;
                if (j - 1 > 0 && grid[i][j] == '1' && grid[i][j - 1] == '1') {
                    uf.merge(cur, left);
                }
                if (j + 1 < m && grid[i][j] == '1' && grid[i][j + 1] == '1') {
                    uf.merge(cur, right);
                }
                if (i - 1 > 0 && grid[i][j] == '1' && grid[i - 1][j] == '1') {
                    uf.merge(cur, up);
                }
                if (i + 1 < n && grid[i][j] == '1' && grid[i + 1][j] == '1') {
                    uf.merge(cur, down);
                }
            }
        }

        return uf.getNumOfAreas();
    }
};

int main() {

    ifstream fin; // 读文件，相对路径是相对于可执行文件
    fin.open("../input.txt", ios::in);

    int m = 5;
    int n = 4;
    vector<vector<char>> nums(n, vector<char>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            fin >> nums[i][j];
        }
    }

    auto *solution = new Solution();
    int ans = solution->numIslands(nums);
    cout << ans << endl;

    return 0;
}