package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC0006_ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int len = s.length();
        List<List<Character>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
        }
        int col = 0, row = 0;
        int k = 0;
        while (k < len) {
            // 第一个竖列
            while (k < len && row < numRows) {
                ans.get(row).add(s.charAt(k++));
                System.out.println(row + " " + col);
                row++;
            }
            row -= 2; // 退回到上一层
            col++; // 行号 +1

            // 斜上方向
            while (k < len && row > 0) {
                ans.get(row).add(s.charAt(k++));
                System.out.println(row + " " + col);
                col++;
                row--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> r : ans) {
            for (char c : r) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = convert("AB", 1);
        System.out.println(s);
    }
}
