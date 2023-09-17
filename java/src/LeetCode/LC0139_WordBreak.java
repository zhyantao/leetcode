package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0139_WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        // 边界条件：空串是有效单词
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // dp[j] 表示 s[0:j-1] 是否为有效单词
                // 只有 s[0:j-1] 和 s[j,i] 同时为有效单词，dp[i] 才为 true
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }

}
