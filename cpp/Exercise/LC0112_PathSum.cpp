#include "bits/stdc++.h"
#include "../MyStruct/TreeNode.h"

class Solution
{
public:
    bool hasPathSum(TreeNode *root, int targetSum)
    {

        if (root == nullptr)
            return false;

        dfs(root, targetSum);
        return ans;
    }

    void dfs(TreeNode *root, int targetSum)
    {
        if (root->left == nullptr && root->right == nullptr)
        {
            sum += root->val;
            if (sum == targetSum)
            {
                ans = true;
            }
            sum -= root->val;
            return;
        }

        sum += root->val;

        if (root->left != nullptr)
        {
            dfs(root->left, targetSum);
        }
        if (root->right != nullptr)
        {
            dfs(root->right, targetSum);
        }

        sum -= root->val;
    }

private:
    bool ans;
    int sum;
};