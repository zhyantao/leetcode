package LeetCode;

import Templates.CenterSpread;

// 最长回文子串
public class LC0005_LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 0;
        int[] res = new int[2]; // 数组第一位记录起始位置，第二位记录长度
        for (int i = 0; i < s.length() - 1; i++) {
            int[] odd = CenterSpread.centerSpread(s, i, i); // 将奇数和偶数分开讨论
            int[] even = CenterSpread.centerSpread(s, i, i + 1); // 偶数的情况下，将中心点看做是两个
            int[] max = odd[1] > even[1] ? odd : even;
            if (max[1] > maxLen) {
                res = max;
                maxLen = max[1];
            }
        }
        return s.substring(res[0], res[0] + res[1]);
    }

}
