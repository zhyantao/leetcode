package Generator;

import MyStruct.ListNode;

public class RandomLinkedListGenerator {

    public static ListNode generateRandomLinkedList(int maxLen, int maxValue) {
        int[] arr = new int[(int) ((maxLen + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 生成 [-maxValue, maxValue] 的随机数
//            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            // 生成 [0, maxValue] 的随机数
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }

        ListNode dummy = new ListNode(0xffffffff);
        ListNode p = new ListNode();
        dummy.next = p;

        for (int i = 0; i < arr.length; i++) {
            p.val = arr[i];
            p.next = new ListNode();
            p = p.next;
        }

        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

}
