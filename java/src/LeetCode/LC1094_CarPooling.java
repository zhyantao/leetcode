package LeetCode;

public class LC1094_CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {
        boolean ans = true;
        int[] nums = new int[capacity];
        int[] diff = getDiffArray(nums);

        for (int[] trip : trips) {
            int val = trip[0];
            int i = trip[1] - 1;
            int j = trip[2] - 1;
            increment(diff, i, j, val);
            increment(diff, i, j, val);
        }

        int[] origin = getOriginArray(diff);
        for (int j : origin) {
            if (j > capacity) {
                return false;
            }
        }
        return ans;
    }

    public static int[] getDiffArray(int[] arr) {
        assert arr.length > 0;
        int[] diff = new int[arr.length];
        diff[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff[i] = arr[i] = arr[i - 1];
        }
        return diff;
    }

    public static int[] increment(int[] diff, int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
        return diff;
    }

    public static int[] getOriginArray(int[] diff) {
        int[] origin = new int[diff.length];
        origin[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            origin[i] = origin[i - 1] + diff[i];
        }
        return origin;
    }

//    public static int[] getPreSum(int[] arr) {
//        int[] preSum = new int[arr.length + 1];
//        preSum[0] = 0;
//        for (int i = 1; i <= arr.length; i++) {
//            preSum[i] = preSum[i - 1] + arr[i - 1];
//        }
//        return preSum;
//    }
//
//    public static int getSumRange(int[] preSum, int i, int j) {
//        return preSum[j] - preSum[i];
//    }

}
