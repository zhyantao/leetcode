package LeetCode;

import MyStruct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0236_LowestCommonAncestorOfABinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		return method1(root, p, q);
        return method2(root, p, q);
    }

    // 使用递归方法实现，比较难理解
    public static TreeNode method1(TreeNode root, TreeNode p, TreeNode q) {
        // 遍历过程中碰到了 p 或 q 就返回 p 或 q
        // 如果没有碰到 p 或 q，就返回空
        if (root == p || root == q || root == null) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    // 使用哈希表实现
    private static Map<TreeNode, TreeNode> map = new HashMap<>();

    // 把根节点放到 map 中
    public static void init(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root, null);
        initBody(root);
    }

    // 把子树放到 map 中
    public static void initBody(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }

        initBody(root.left);
        initBody(root.right);
    }

    public static TreeNode method2(TreeNode root, TreeNode p, TreeNode q) {

        init(root);

        Set<TreeNode> set = new HashSet<>();

        // 找到 p 的所有的父节点，加入到 set 中
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        while (!set.contains(q)) {
            q = map.get(q);
        }

        return q;
    }
}
