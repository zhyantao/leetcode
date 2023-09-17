package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC0560_SubarraySumEqualsK {

    // 和为 k 的连续子数组的个数
    public int subarraySum(int[] nums, int k) {

        int[] preSum = getPreSum(nums);
        System.out.println(Arrays.toString(preSum));

        Map<Integer, Integer> map = new HashMap<>(); // key 前缀和，value 该前缀和的个数

        // for (int i = 0; i < preSum.length; i++) {
        //     map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        // }

        int count = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (map.containsKey(preSum[i] - k)) {
                count += map.get(preSum[i] - k);
            }
            // 【重要】先检查，再放元素，否则会发生错误，如注释所示
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }

        return count;
    }

    // 生成前缀数组
    public static int[] getPreSum(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        preSum[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        return preSum;
    }

}
