#include "bits/stdc++.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> combine(int n, int k) {

        vector<int> path;
        dfs(n, k, 1, path);

        return ans;
    }

    void dfs(int n, int k, int begin, vector<int> &path) {
        if (path.size() == k) {
            ans.push_back(path);
            return;
        }

        for (int i = begin; i <= n; i++) {
            // 注释掉的下面这一行是剪枝操作，没有也能成功
//        for (int i = begin; i <= (n - (k - path.size()) + 1); i++) {

            // 1、将当前数字压栈
            path.push_back(i);

            // 2、我们【打算】添加下一个数字，但是在添加之前需要先去 if 中检查
            // 如果当前 path 已经满足终止条件了，就不应该进入到 for 循环添加下一个数字
            // 而是应该先弹出一个元素，再继续往 path 中添加
            dfs(n, k, i + 1, path);

            // 3、弹出栈顶元素
            path.pop_back();
        }
    }

private:
    vector<vector<int>> ans;
};