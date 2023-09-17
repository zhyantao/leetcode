package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0763_PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        List<Integer> ans = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return ans;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i); // 记录字母最后出现的位置
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 找到这个 endTime 范围内出现的
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }

        return ans;

    }

}
