package LeetCode;

import MyStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC0437_PathSumII {

    Map<Long, Integer> map = new HashMap<>(); // key 前缀和 value 前缀和出现的次数
    int ans;

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        map.put((long) 0, 1);
        dfs(root, root.val, targetSum);

        return ans;
    }

    // 递归问题：父子节点之间的信息传递依靠的是【形参】
    public void dfs(TreeNode root, long preSum, int targetSum) {
        if (map.containsKey(preSum - targetSum)) {
            ans += map.get(preSum - targetSum);
        }

        map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        if (root.left != null) {
            dfs(root.left, preSum + root.left.val, targetSum);
        }
        if (root.right != null) {
            dfs(root.right, preSum + root.right.val, targetSum);
        }

        // 撤销原操作
        map.put(preSum, map.getOrDefault(preSum, 0) - 1);
    }

}
