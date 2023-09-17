package LeetCode;

public class LC0055_JumpGame {

    public boolean canJump(int[] nums) {

        int rightMost = 0; // 最远能够到达的距离

        for (int i = 0; i < nums.length; i++) {
            // 当前来到的位置 rightMost 来不到，不合题意
            if (i > rightMost) {
                return false;
            }
            // 更新能够到达的最远位置
            rightMost = Math.max(rightMost, i + nums[i]);
        }

        return true;

    }

}
