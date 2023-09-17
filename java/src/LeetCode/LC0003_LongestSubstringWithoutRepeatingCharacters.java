package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC0003_LongestSubstringWithoutRepeatingCharacters {

    // 含有不重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            char r = s.charAt(j);
            map.put(r, map.getOrDefault(r, 0) + 1); // 统计出现的次数

            // 当该字符出现的次数超过了 1
            // 指针 i 应该右移，直到该次数降为 1
            while (map.get(r) > 1) {
                char l = s.charAt(i);
                map.put(l, map.get(l) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }

}
