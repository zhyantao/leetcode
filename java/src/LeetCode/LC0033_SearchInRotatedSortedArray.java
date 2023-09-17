package LeetCode;

public class LC0033_SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        if (nums.length < 1) {
            return -1;
        }

        int i = 0;
        int j = nums.length - 1;

        if (nums[i] > target && nums[j] < target) {
            return -1;
        }

        if (nums[i] == target) {
            return i;
        } else if (nums[j] == target) {
            return j;
        }

        while (i < j && nums[i] < target) {
            i++;
            if (nums[i] == target) {
                return i;
            }
        }

        while (i < j && nums[j] > target) {
            j--;
            if (nums[j] == target) {
                return j;
            }
        }

        return -1;

    }

}
