package LeetCode;

import java.util.Arrays;

public class LC0455_AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {

        int m = g.length;
        int n = s.length;

        if (m == 0 || n == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        // 让小胃口的孩子优先满足
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (g[i] <= s[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i;
    }

}
