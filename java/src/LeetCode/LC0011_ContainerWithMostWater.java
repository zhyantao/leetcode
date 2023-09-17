package LeetCode;

public class LC0011_ContainerWithMostWater {

    public static int maxArea(int[] height) {

        if (height.length < 2) {
            return 0;
        }

        // 双指针，两个指针指向数组两端，向中间收缩，
        // 每次向内移动短板，容量有可能变大。但移动长板，容量一定减小。
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                ans = Math.max(ans, height[i] * (j - i));
                i++;
            } else {
                ans = Math.max(ans, height[j] * (j - i));
                j--;
            }
        }

        return ans;
    }

}
