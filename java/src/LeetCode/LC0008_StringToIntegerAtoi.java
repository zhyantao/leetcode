package LeetCode;

import java.util.HashMap;
import java.util.Map;

class Automation {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private final Map<String, String[]> table = new HashMap<String, String[]>() {
		private static final long serialVersionUID = 1L;

		{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

public class LC0008_StringToIntegerAtoi {
    public static int myAtoi(String s) {
        Automation automation = new Automation();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            automation.get(s.charAt(i));
        }
        return (int) (automation.sign * automation.ans);
    }

    public static void main(String[] args) {
        int ans = myAtoi("-91283472332");
        System.out.println(ans);
    }
}
