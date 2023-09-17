package TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input1.txt"));
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        process(str1, str2);
    }

    public static void process(String str1, String str2) {
        System.out.println(str1);
        System.out.println(str2);
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char ch1 = str1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
