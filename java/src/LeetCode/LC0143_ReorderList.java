package LeetCode;

import MyStruct.ListNode;

public class LC0143_ReorderList {

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 将链表的后一半压栈
        ListNode pFast = head;
        ListNode pSlow = head;

        // 注意循环终止条件是关键
        while (pFast.next != null && pFast.next.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }
        ListNode mid = pSlow.next;
        pSlow.next = null;

        // 逆序后一半链表
        ListNode prev = null;
        ListNode cur = mid;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // 拼接两块链表
        ListNode p1 = head;
        ListNode p2 = prev;
        while (p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = tmp;
        }

    }

}
