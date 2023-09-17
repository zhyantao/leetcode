package LeetCode;

import MyStruct.ListNode;

public class LC0206_ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {

            ListNode next = cur.next;

            cur.next = prev;

            // 更新节点
            prev = cur;
            cur = next;
        }

        // Java 是值传递，无法改变形参中的 head
        // 想要返回头结点的指针，需要带返回值
        return prev; // 返回的是 pre
    }

}
