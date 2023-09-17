package Templates;

// 中心扩展算法
public class CenterSpread {

    // 求对称区间
    public static int[] centerSpread(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        // 返回值第一位记录起始位置，第二位记录长度
        return new int[]{left + 1, right - left - 1};
    }

}
