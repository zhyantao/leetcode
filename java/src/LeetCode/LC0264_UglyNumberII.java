package LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC0264_UglyNumberII {
    static int[] nums = new int[]{2, 3, 5};

    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        for (int i = 1; i <= n; i++) {
            long x = pq.poll();
            if (i == n) return (int) x;
            for (int num : nums) {
                long tmp = num * x;
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    pq.add(tmp);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = nthUglyNumber(10);
        System.out.println(ans);
    }
}
