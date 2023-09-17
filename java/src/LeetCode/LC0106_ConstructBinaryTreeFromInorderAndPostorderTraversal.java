package LeetCode;

import MyStruct.TreeNode;

public class LC0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0 && postorder.length == 0) {
            return null;
        }

        int rootVal = postorder[postorder.length - 1];

        // 评估左右子树的节点个数
        int leftLen = 0;
        while (leftLen < inorder.length) {
            if (inorder[leftLen] == rootVal) {
                // leftLen++;
                break;
            }
            leftLen++;
        }
        int rightLen = inorder.length - leftLen - 1;
        // System.out.println(leftLen + " : " + rightLen);

        int[] leftInorder = new int[leftLen];
        int[] rightInorder = new int[rightLen];
        int[] leftPostorder = new int[leftLen];
        int[] rightPostorder = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftInorder[i] = inorder[i];
            leftPostorder[i] = postorder[i];
        }

        for (int j = 0; j < rightLen; j++) {
            rightInorder[j] = inorder[j + leftLen + 1];
            rightPostorder[j] = postorder[j + leftLen];
        }

        // System.out.println(Arrays.toString(leftPostorder));
        // System.out.println(Arrays.toString(rightPostorder));

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(leftInorder, leftPostorder);;
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
}
