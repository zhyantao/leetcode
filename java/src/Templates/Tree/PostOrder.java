package Templates.Tree;

import MyStruct.ListNode;
import MyStruct.TreeNode;

import java.util.Stack;

import Generator.RandomTreeGenerator;

public class PostOrder {

    // 和前序遍历类似的代码，也需要借助栈来实现
    // 遍历顺序不一样，且多了一个 reverse 环节
    public static void postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return;

        stack.push(root);

        ListNode dummy = new ListNode(-1); // 哨兵节点，head = dummy.next
        ListNode p = dummy; // 用于遍历的指针
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            stack.pop();

            // 添加到链表
            p.next = new ListNode(cur.val);
            p = p.next;

            if (cur.left != null) // 先左后右
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
        }

        p = reverseList(dummy.next); // 翻转链表

        while (p != null) {
            System.out.println(p.val); // 业务逻辑代码
            p = p.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // 用三个指针翻转链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next; // 临时保存
            cur.next = pre;
            // 更新节点
            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    public static void main(String[] args) {
        TreeNode root = RandomTreeGenerator.generateConcreteTree();
        RandomTreeGenerator.printTree(root);
        postorder(root);
    }

}
