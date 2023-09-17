package LeetCode;

import Generator.RandomTreeGenerator;
import MyStruct.TreeNode;

public class LC0111_MininumDepthOfBinaryTree {

    // 求二叉树的最小深度
    public static int minDepth(TreeNode root) {

        // base case
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // 后序遍历
        if (root.left == null && root.right != null) {
            return 1 + right;
        }

        if (root.left != null && root.right == null) {
            return 1 + left;
        }

        return left < right ? left + 1 : right + 1;

    }

    public static void main(String[] args) {
        TreeNode root = RandomTreeGenerator.generateRandomTree(10, 20);
        RandomTreeGenerator.printTree(root);
        int ans = minDepth(root);
        System.out.println(ans);
    }

}
