package LeetCode;

import MyStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC0098_ValidateBinarySearchTree {

    /**
     * 使用左程云的模板代码解决问题
     * ReturnInfo = 需要从左子树拿到的信息 + 需要从右子树拿到的信息
     */
    public static class ReturnInfo {
        public boolean isBST; // 记录当前子树是否为搜索树
        public int max;
        public int min;

        public ReturnInfo(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        ReturnInfo ans = core(root);
        return ans.isBST;
    }

    public static ReturnInfo core(TreeNode root) {

        if (root == null) {
            return null;
        }

        // 把递归看成黑盒子，当做它能处理信息
        ReturnInfo left = core(root.left);
        ReturnInfo right = core(root.right);

        // 后序遍历：解析黑盒子
        int min = root.val;
        int max = root.val;
        if (left != null) {
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right != null) {
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }
        boolean isBST = true;
        if (left != null && (!left.isBST || left.max >= root.val)) {
            isBST = false;
        }
        if (right != null && (!right.isBST || right.min <= root.val)) {
            isBST = false;
        }

        return new ReturnInfo(isBST, max, min);
    }

    ///////////////////////////
    // 抖机灵解法，简单高效
    ///////////////////////////
    // public int pre = Integer.MIN_VALUE; // 这个精度会无法通过测试用例
    public static double pre = -Double.MAX_VALUE; // 这里用了负号
    public static boolean ans = true;

    public static boolean isValidBSTinorder(TreeNode root) {

        if (root == null) {
            return true;
        }

        isValidBSTinorder(root.left);

        // 中序遍历
        if (root.val <= pre) {
            ans = false;
        } else {
            pre = root.val;
        }

        isValidBSTinorder(root.right);

        return ans;

    }

    ////////////////////////
    // 下面是暴力解法
    ////////////////////////
    public static List<Integer> list = new ArrayList<>();

    public static boolean isValidBSTviolentSolution(TreeNode root) {

        inorder(root);
        // 简单粗暴，中序遍历使用 list
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
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
