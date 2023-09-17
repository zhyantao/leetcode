package LeetCode;

import MyStruct.ListNode;

public class LC0160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        int len1 = 0;
        int len2 = 0;

        while (pA.next != null) {
            len1++;
            pA = pA.next;
        }

        while (pB.next != null) {
            len2++;
            pB = pB.next;
        }

        if (pA != pB) {
            return null;
        }

        pA = headA;
        pB = headB;

        if (len1 < len2) {
            int d = len2 - len1;
            while (d > 0) {
                d--;
                pB = pB.next;
            }
            while (pA != pB) {
                pA = pA.next;
                pB = pB.next;
            }
        } else {
            int d = len1 - len2;
            while (d > 0) {
                d--;
                pA = pA.next;
            }
            while (pA != pB) {
                pA = pA.next;
                pB = pB.next;
            }
        }

        return pB;
    }

}
