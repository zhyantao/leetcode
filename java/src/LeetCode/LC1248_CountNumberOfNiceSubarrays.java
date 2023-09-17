package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC1248_CountNumberOfNiceSubarrays {

    // 统计优美子数组的个数
    public int numberOfSubarrays(int[] nums, int k) {

        // 暴力超时
        // 使用哈希表 + 前缀和解决问题

        Map<Integer, Integer> map = new HashMap<>(); // key 前缀和 value 该前缀和的个数
        map.put(0, 1); // 前缀和是 0 的有 1 个

        // 例如      1 1 0 1 1 1 0 0 1
        // key    0 1 2 2 3 4 5 5 5 6
        // value  1 1 1 2 1 1 1 2 3 1
        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            preSum += nums[i] % 2; // 遍历原数组，每计算一个元素，统计当前的前缀和

            // 统计该前缀和的个数，比如前缀和为 4 的有 2 个
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

            if (preSum >= k) {
                // preSum - k 是对 preSum[j] - preSum[i] == k 的优化，参考【1.两数之和】
                // 想要统计 [0...preSum] 的奇数的个数，我们需要统计 符合条件的下标为 j 的个数
                // 其中 0 <= j <= i，且 [j...i] 这个子数组里的奇数个数恰好为 k
                ans += map.get(preSum - k);
            }
        }

        return ans;
    }

}
