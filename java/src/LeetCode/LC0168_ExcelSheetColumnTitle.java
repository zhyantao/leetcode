package LeetCode;

public class LC0168_ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        // 注意从 1 开始
        while (columnNumber > 0) {
            char ch = (char) ((columnNumber - 1) % 26 + 'A');
            sb.insert(0, ch);
            columnNumber = (columnNumber - ch) / 26;
        }

        return new String(sb);
    }

    public static void main(String[] args) {
        String ans = convertToTitle(1);
        System.out.println(ans);
    }

}
