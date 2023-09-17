package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC0239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();

        int[] ans = new int[n - k + 1];

        for (int right = 0; right < n; right++) {
            // 单调队列，保持单调递减
            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(right);

            // 如果滑动窗口满了，应该弹出一些元素
            int left = right - k + 1;
            if (deque.peekFirst() < left) {
                deque.removeFirst();
            }
            if (right + 1 >= k) {
                ans[left] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }

}
