package LeetCode;

import MyStruct.TreeNode;

public class LC0701_InsertIntoABinarySearchTree {

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        // 向二叉搜索树中插入节点，一定会插入到叶节点上
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;

    }

}
