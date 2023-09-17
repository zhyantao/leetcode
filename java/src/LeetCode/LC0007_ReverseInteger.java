package LeetCode;

public class LC0007_ReverseInteger {

    public static int reverse(int x) {

        // 本题可以不用栈，也能实现反转

        // 难点在于，如何判断溢出？
        // 解题的突破在于，溢出之后到底是个什么值，是无法判断的
        // 我们需要提前判断

        int ans = 0;

        // 单纯用 x > 0 是无法判断负数的
        while (x != 0) {
            // 取余运算是可以出现负数的
            int digit = x % 10;

            /////////// 解题突破 - 提前判断（在 ans = ans * 10 + digit; 之前判断） /////////////
            // 判断是否大于最大的 32 位整数
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && digit > 7)) {
                return 0;
            }
            // 判断是否小于最小的 32 位整数
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            ans = ans * 10 + digit;

            x /= 10;
        }

        return ans;

    }

    public static void main(String[] args) {
        int ans = reverse(-8);
        System.out.println(ans);
    }

}
