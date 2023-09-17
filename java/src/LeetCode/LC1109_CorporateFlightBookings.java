package LeetCode;

public class LC1109_CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 区间修改使用差分方法
        int[] diff = new int[n + 1];
        for (int[] booking : bookings) {
            int left = booking[0] - 1;
            int right = booking[1] - 1;
            int value = booking[2];
            diff[left] += value;
            diff[right + 1] -= value;
        }

        // 还原原数组
        int[] ans = new int[n];
        ans[0] = diff[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}
