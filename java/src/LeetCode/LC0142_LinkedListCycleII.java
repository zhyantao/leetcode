package LeetCode;

import MyStruct.ListNode;

public class LC0142_LinkedListCycleII {

    /**
     * 返回链表入环的第一个节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        // 为了顺利进入 while 循环，先迈出一步
        ListNode pSlow = head.next;
        ListNode pFast = head.next.next;

        while (pSlow != pFast) {
            pSlow = pSlow.next;
            if (pFast != null && pFast.next != null) {
                pFast = pFast.next.next;
            } else {
                return null;
            }
        }

        pFast = head;
        while (pSlow != pFast) {
            pSlow = pSlow.next;
            pFast = pFast.next;
        }

        return pFast;

    }

}
