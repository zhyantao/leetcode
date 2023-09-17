package Templates;

public class KMP {

    // next 数组记录最长相等的前后缀长度
    public static void getNext(int[] next, String pat) {
        next[0] = 0;
        int j = 0; // 失配后的回退点
        for (int i = 1; i < pat.length(); i++) { // 循环从 1 开始，不是 0
            char chi = pat.charAt(i);
            char chj = pat.charAt(j);
            while (j > 0 && chi != chj)
                j = next[j - 1]; // 回退
            if (chi == chj)
                j++;
            next[i] = j;
        }
    }

    public static int strStr(String txt, String pat) {
        if (pat.length() == 0)
            return 0;

        int[] next = new int[pat.length()];

        getNext(next, pat);

        int j = 0;
        for (int i = 0; i < txt.length(); i++) {
            char chi = txt.charAt(i);
            char chj = pat.charAt(j);
            while (j > 0 && chi != chj)
                j = next[j - 1];
            if (chi == chj)
                j++;
            if (j == pat.length())
                return i - pat.length() + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "hello world";
        String p = "ell";

        int startPos = strStr(s, p);
        System.out.println(startPos);
    }

}
