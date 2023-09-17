package LeetCode;

import MyStruct.ListNode;

class ListNodeGroup {
    ListNode head;
    ListNode tail;
    ListNode next;

    public ListNodeGroup(ListNode head, ListNode tail, ListNode next) {
        this.head = head;
        this.tail = tail;
        this.next = next;
    }
}

// K 个一组翻转链表
public class LC0025_ReverseNodesInKgroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        while (true) {
            // 检查剩余 k 个节点，不足则返回
            ListNode last = prev;
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null) {
                    return dummy.next;
                }
            }

            // 翻转 k 个节点
            ListNode curr = prev.next;
            ListNode next;
            for (int i = 0; i < k - 1; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
        }
    }
}
