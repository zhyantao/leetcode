package Templates.Tree;

import MyStruct.TreeNode;

import java.util.Stack;

import Generator.RandomTreeGenerator;

public class InOrder {

    // 需要借助栈和指针来实现
    public static void inorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) { // 遍历左子节点，入栈
                stack.push(cur);
                cur = cur.left;
            } else { // 遍历完左子节点，出栈，保存结果
                cur = stack.peek();
                stack.pop();

                System.out.println(cur.val);

                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = RandomTreeGenerator.generateConcreteTree();
        RandomTreeGenerator.printTree(root);
        inorder(root);
    }

}
