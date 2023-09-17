package LeetCode;

public class LC1124_LongestWellPerformingInterval {

    public int longestWPI(int[] hours) {
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
        }
        int[] preSum = getPreSum(hours);
        int ans = 0;
        for (int i = 0; i < preSum.length; i++) {
            for (int j = i + 1; j < preSum.length; j++) {
                if (preSum[j] - preSum[i] > 0) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    // 前缀和
    public int[] getPreSum(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        return preSum;
    }

}
