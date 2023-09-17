package LeetCode;

import MyStruct.ListNode;

public class LC0141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        // 为了能顺利进入 while 循环，先迈出一步
        ListNode pSlow = head.next;
        ListNode pFast = head.next.next;

        while (pFast != null) {
            if (pFast == pSlow) {
                return true;
            } else {
                if (pFast.next != null) {
                    pFast = pFast.next.next;
                    pSlow = pSlow.next;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

}
