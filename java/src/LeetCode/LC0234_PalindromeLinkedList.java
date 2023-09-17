package LeetCode;

import MyStruct.ListNode;

import java.util.Stack;

import Generator.RandomLinkedListGenerator;

public class LC0234_PalindromeLinkedList {

    // 利用栈结构来解决对称链表问题
    public static boolean isPalindrome2(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        ListNode pFast = head;
        ListNode pSlow = head;

        // 不要判断 pFast != null
        // 而是要判断 pFast.next != null 以及 pFast.next.next != null
        // 因为 pFast.next 不等于空，则 pFast 一定不等于空
        while (pFast.next != null && pFast.next.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }

        while (pSlow != null) {
            stack.add(pSlow);
            pSlow = pSlow.next;
        }

        pFast = head;
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop(); // stack.pop() 的返回值是对象
            if (tmp.val != pFast.val) {
                break;
            }
            pFast = pFast.next;
//        	stack.pop();
        }

        return stack.isEmpty() ? true : false;

    }

    // 也可以不使用栈结构来解决问题
    public static boolean isPalindrome(ListNode head) {

        // 第一步：找到链表的中点，使用快慢指针
        ListNode pFast = head;
        ListNode pSlow = head;

        while (pFast.next != null && pFast.next.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }

        // 翻转后半部分链表
        ListNode pAfter = reverseList(pSlow.next); // 链表头部
        pSlow.next = null;
        ListNode pFront = head;

        // 判断从链表的两头开始，判断是否相同
        while (pFront != null && pAfter != null) {
            if (pFront.val != pAfter.val) {
                return false;
            }
            pFront = pFront.next;
            pAfter = pAfter.next;
        }

        // 还原链表
        ListNode pOrigin = reverseList(pAfter);
        ListNode pHead = head;
        while (pHead.next != null) {
            pHead = pHead.next;
        }
        pHead.next = pOrigin;

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = RandomLinkedListGenerator.generateRandomLinkedList(10, 20);
        RandomLinkedListGenerator.printLinkedList(head);
//		head = L206_ReverseLinkedList.reverseList(head); // 更新 head
        RandomLinkedListGenerator.printLinkedList(head);
        System.out.println(isPalindrome(head));
    }

}
