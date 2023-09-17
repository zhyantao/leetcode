package LeetCode;

import MyStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC0103_BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (true) {
            List<Integer> path1 = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode tmp = stack1.pop();
                if (tmp != null) {
                    path1.add(tmp.val);
                    stack2.push(tmp.left);
                    stack2.push(tmp.right);
                }
            }
            // System.out.println(Arrays.toString(path1.toArray()));
            if (path1.size() != 0) {
                ans.add(path1);
            }

            List<Integer> path2 = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode tmp = stack2.pop();
                if (tmp != null) {
                    path2.add(tmp.val);
                    stack1.push(tmp.right);
                    stack1.push(tmp.left);
                }
            }
            // System.out.println(Arrays.toString(path2.toArray()));
            if (path2.size() != 0) {
                ans.add(path2);
            }

            if (stack1.isEmpty() && stack2.isEmpty()) {
                break;
            }
        }

        return ans;

    }

}
