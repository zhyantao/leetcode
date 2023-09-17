package Templates.Tree;

import MyStruct.TreeNode;

import java.util.Stack;

import Generator.RandomTreeGenerator;

public class PreOrder {

    public static void preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            stack.pop();

            System.out.println(cur.val);

            if (cur.right != null) // 先右后左
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = RandomTreeGenerator.generateConcreteTree();
        RandomTreeGenerator.printTree(root);
        preorder(root);
    }
}
