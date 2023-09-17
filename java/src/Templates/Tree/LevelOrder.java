package Templates.Tree;

import MyStruct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Generator.RandomTreeGenerator;

public class LevelOrder {

    // 层序遍历需要，记录某一层的个数以及某一次的结尾
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        ans.add(new ArrayList<>(Arrays.asList(root.val))); // 添加根节点的值

        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        TreeNode p;
        while (!list.isEmpty()) {

            List<Integer> path = new ArrayList<>();

            int sz = list.size(); // 当前层元素的个数
            for (int i = 0; i < sz; i++) { // 向 list 中添加下一层的所有元素
                p = list.get(0); // 队首元素
                if (p.left != null) {
                    list.add(p.left);
                    path.add(p.left.val);
                }
                if (p.right != null) {
                    list.add(p.right);
                    path.add(p.right.val);
                }
                list.remove(0); // 逐渐地移除当前层元素
            }

            if (path.size() > 0)
                ans.add(path);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = RandomTreeGenerator.generateRandomTree(8, 9);
        RandomTreeGenerator.printTree(root);
        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans);
    }

}
