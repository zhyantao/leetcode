package LeetCode;

public class LC1031_MaximumSumOfTwoNonOverlappingSubarrays {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        // 用 4 个 dp 数组解决问题

        int[] A = nums;
        int L = firstLen;
        int M = secondLen;

        int[][] dp = new int[A.length + 1][4];
        int presum = 0;
        int maxsum;
        for (int i = 0; i < L; ++i) {
            presum += A[i];
        }
        maxsum = presum;
        dp[L - 1][0] = maxsum;
        for (int i = L; i < A.length; ++i) {
            presum -= A[i - L];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][0] = maxsum;
        }

        presum = 0;
        for (int i = 0; i < M; ++i) {
            presum += A[i];
        }
        maxsum = presum;
        dp[M - 1][1] = maxsum;
        for (int i = M; i < A.length; ++i) {
            presum -= A[i - M];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][1] = maxsum;
        }

        presum = 0;
        for (int i = A.length - 1; i >= A.length - L; --i) {
            presum += A[i];
        }
        maxsum = presum;
        dp[A.length - L][2] = maxsum;
        for (int i = A.length - L - 1; i >= 0; --i) {
            presum -= A[i + L];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][2] = maxsum;
        }

        presum = 0;
        for (int i = A.length - 1; i >= A.length - M; --i) {
            presum += A[i];
        }
        maxsum = presum;
        dp[A.length - M][3] = maxsum;
        for (int i = A.length - M - 1; i >= 0; --i) {
            presum -= A[i + M];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][3] = maxsum;
        }

        // 计算答案
        int res = 0;
        // L 在 M 左边
        for (int i = L; i <= A.length - M; ++i)
            res = Math.max(res, dp[i - 1][0] + dp[i][3]);
        // M 在 L 左边
        for (int i = M; i <= A.length - L; ++i)
            res = Math.max(res, dp[i - 1][1] + dp[i][2]);

        return res;
    }

}
