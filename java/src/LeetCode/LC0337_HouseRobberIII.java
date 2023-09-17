package LeetCode;

import MyStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC0337_HouseRobberIII {

    public static Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>(); // 选中 o 节点
    public static Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>(); // 不选 o 节点

    public static int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);

        // 更新 dp 数组（这里不过是把 dp 数组抽象成了哈希表）
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));

        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
                + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

}
