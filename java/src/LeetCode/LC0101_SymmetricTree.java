package LeetCode;

import MyStruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0101_SymmetricTree {

    /**
     * 使用 "双指针" 同时向下遍历，保证树的内侧相同、外侧相同 使用 "层序遍历" 的思想，准备一个队列。
     * 一个指针遍历左子树（先左后右），一个指针遍历右子树（先右后左）
     */
    public static boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // 左子树和右子树的根节点同时入队
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {

            // 每一次都从队列中弹出两个元素
            TreeNode leftTree = queue.poll();
            TreeNode rightTree = queue.poll();

            if (leftTree == null && rightTree == null) {
                continue; // 思考：这里为什么用 continue
            }
            // 因为空指针也会入队

            if (leftTree == null || rightTree == null) {
                return false;
            }

            if (leftTree.val != rightTree.val) {
                return false;
            }

            // 两两一对，入队
            queue.offer(leftTree.left);
            queue.offer(rightTree.right);

            queue.offer(leftTree.right);
            queue.offer(rightTree.left);
        }

        return true;

    }

    /**
     * 用中序遍历对称二叉树，得到的数组是对称的 【局限性】要求二叉树中的所有的值都不相同、故不能通过所有用例
     */
    static List<Integer> list = new ArrayList<Integer>();

    public static boolean isSymmetricWrongAnswer(TreeNode root) {

        if (root == null) {
            return true;
        }

        inorder(root);

        int sz = list.size();

        for (int i = 0; i < sz / 2; i++) {
            if (list.get(i) != list.get(sz - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

}
