package LeetCode;

import java.util.*;

public class LC0496_NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] mono = new int[n];
        Arrays.fill(mono, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

//        for (int i = n - 1; i >= 0; i--) {
//            while (!deque.isEmpty() && nums2[deque.peekLast()] < nums2[i]) {
//                deque.removeLast();
//            }
//            mono[i] = deque.isEmpty() ? -1 : nums2[deque.peekLast()];
//            deque.addLast(i);
//            map.put(nums2[i], mono[i]);
//        }

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums2[deque.peekLast()] < nums2[i]) {
                int idx = deque.peekLast();
                mono[idx] = nums2[i];
                map.put(nums2[deque.peekLast()], mono[idx]);
                deque.removeLast();
            }
            deque.addLast(i);
            map.put(nums2[i], mono[i]);
        }

        System.out.println(Arrays.toString(mono));

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
    }

}
