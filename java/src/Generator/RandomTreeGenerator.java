package Generator;

import MyStruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class RandomTreeGenerator {

    private static int nodeCount_g = Integer.MIN_VALUE;

    public static TreeNode generateConcreteTree() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

    public static TreeNode generateRandomTree(int nodeCount, int maxValue) {
        nodeCount_g = nodeCount;
        return generateRandomTreeCore(maxValue, null);
    }

    public static TreeNode generateRandomTreeCore(int maxValue, TreeNode root) {

        if (nodeCount_g < 1) {
            return null;
        }

        // 如果没有根节点，应该新建一个根节点
        if (root == null) {
            int value = (int) ((maxValue + 1) * Math.random());
            root = new TreeNode(value);
            nodeCount_g--;
        }

        int r = 0; // 一个随机数字
        // 00 左右子树都没有，不合理，舍弃
        // 01 有右子树，没有左子树
        // 10 有左子树，没有右子树
        // 11 既有左子树，又有右子树
        if (nodeCount_g >= 2) {
            r = (int) (3 * Math.random() + 1); // r 属于 [1,3]
        } else if (nodeCount_g == 1) {
            r = (int) (2 * Math.random() + 1); // r 属于 [1,2]
        }

        if (r == 1 && nodeCount_g >= 1) {
            root.right = new TreeNode((int) ((maxValue + 1) * Math.random()));
            nodeCount_g--;
        } else if (r == 2 && nodeCount_g >= 1) {
            root.left = new TreeNode((int) ((maxValue + 1) * Math.random()));
            nodeCount_g--;
        } else if (r == 3 && nodeCount_g >= 2) {
            root.left = new TreeNode((int) ((maxValue + 1) * Math.random()));
            root.right = new TreeNode((int) ((maxValue + 1) * Math.random()));
            nodeCount_g -= 2;
        }

        if (root.left != null && nodeCount_g > 0) {
            generateRandomTreeCore(maxValue, root.left);
        }

        if (root.right != null && nodeCount_g > 0) {
            generateRandomTreeCore(maxValue, root.right);
        }

        return root;
    }

    public static void printTree(TreeNode root) {

        // 使用层序遍历打印树结构
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 打印根节点
        System.out.print("[");
        System.out.print(root.val + ",");

        // 弹出根节点
        TreeNode p = queue.poll();

        while (p != null) {
            if (p.left != null) {
                queue.offer(p.left);
                System.out.print(p.left.val + ",");
            } else {
                System.out.print("null,");
            }

            if (p.right != null) {
                queue.offer(p.right);
                System.out.print(p.right.val + ",");
            } else if (!queue.isEmpty()) {
                System.out.print("null,");
            } else {
                System.out.print("null");
            }

            p = queue.poll();

        }

        System.out.println("]");
    }
}
