package LeetCode;

public class LC0045_JumpGameII {

    public int jump(int[] nums) {

        int len = nums.length;

        int end = 0;
        int maxPosition = 0;
        int step = 0;

        for (int i = 0; i < len - 1; i++) {
            // 每次选择能跳的最远位置
            maxPosition = Math.max(maxPosition, i + nums[i]);

            // 用 if 条件忽略右边界
            if (i == end) {
                end = maxPosition; // 用 endTime 更新，表示 i 已经来到了 endTime
                step++;
            }
        }

        return step;
    }

}
