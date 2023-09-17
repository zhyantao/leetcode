package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LC0435_NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int count = 0;
        int[] pre = new int[]{intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            // 只保留第一个不重叠的最小区间
            if (intervals[i][0] == pre[0] && pre[1] <= intervals[i][1]) {
                count++;
            } else {
                pre[0] = intervals[i][0];
                pre[1] = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int ans = eraseOverlapIntervals(new int[][]{
                {1, 2}, {1, 2}, {1, 2}
        });
        System.out.println(ans);
    }
}
