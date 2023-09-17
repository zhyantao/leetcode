package Templates.OptTips;

import java.util.Arrays;

// 前缀和技巧适用场景：数组不变 + 区间查询
public class PreSum {

    // 生成前缀数组
    public static int[] getPreSum(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        return preSum;
    }

    // 求区间下标为 [i, j) 元素的和
    public static int getSumRange(int[] preSum, int i, int j) {
        return preSum[j] - preSum[i];
    }

    // 前缀和
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 2, 4, 3, 5, 6, -1, 20};
        System.out.println(Arrays.toString(arr));

        // 生成前缀和数组
        int[] preSum = getPreSum(arr);
        System.out.println(Arrays.toString(preSum));

        // 求区间 [0, 2) 的元素的和
        System.out.println(getSumRange(preSum, 0, 2));
    }

}
