package LeetCode;

public class LC0027_RemoveElement {

    public static int removeElement(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        int i = 0;
        while (i < len) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                nums[len - 1] = 0;
                len--;
            } else {
                i++;
            }
        }

        return len;
    }

}
