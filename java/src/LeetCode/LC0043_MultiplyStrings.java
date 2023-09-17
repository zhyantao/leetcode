package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC0043_MultiplyStrings {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        List<String> list = new ArrayList<>();

        // 乘法运算
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                sb.append((a * b + carry) % 10);
                carry = (a * b + carry) / 10;
                if (j == 0 && carry != 0) {
                    sb.append(carry);
                }
            }
            // System.out.println(sb.toString());
            list.add(sb.toString());
        }

        // 加法运算
        String subans = list.get(0);
        for (int k = 1; k < list.size(); k++) {
            StringBuilder ddd = new StringBuilder(list.get(k));
            for (int l = 0; l < k; l++) {
                ddd.insert(0, "0");
            }
            subans = plus(ddd.toString(), subans);
            System.out.println(subans + "\n");
        }

        // 逆置字符串
        for (int m = 0; m < subans.length(); m++) {
            ans.insert(0, subans.charAt(m));
        }

        return ans.toString();
    }

    public String plus(String s1, String s2) {
        System.out.println(s1);
        System.out.println(s2);
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(j) - '0';
            sb.append((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            i++;
            j++;
        }
        while (i < s1.length()) {
            int a = s1.charAt(i) - '0';
            sb.append((a + carry) % 10);
            carry = (a + carry) / 10;
            i++;
        }
        while (j < s2.length()) {
            int b = s2.charAt(j) - '0';
            sb.append((b + carry) % 10);
            carry = (b + carry) / 10;
            j++;
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.toString();
    }

}
