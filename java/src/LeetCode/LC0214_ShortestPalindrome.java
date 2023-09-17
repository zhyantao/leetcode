package LeetCode;

public class LC0214_ShortestPalindrome {

    public static void main(String[] args) {
        String s = "abcabdabcd";
        String pattern = "bda";
        int ans = strStr(s, pattern);
        System.out.println(ans);
    }

    public static int strStr(String str, String pattern) {
        if (pattern.length() == 0) {
            return 0;
        }
        int[] next = new int[pattern.length()];
        getNext(next, pattern);
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }

    public static void getNext(int[] next, String s) {
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            char chi = s.charAt(i);
            char chj = s.charAt(j);
            while (j > 0 && chi != chj) {
                j = next[j - 1];
            }
            if (chi == chj) {
                j++;
            }
            next[i] = j;
        }
    }

}
