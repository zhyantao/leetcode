package TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input1.txt"));
        int m = in.nextInt(); // 村民数量
        int[] as = new int[m]; // 1 ~ m 个村民的资产金额
        for (int i = 0; i < m; i++) {
            as[i] = in.nextInt();
        }
        int n = in.nextInt(); // 捐款数目
        process(as, n);
    }

    public static void process(int[] as, int n) {
        int m = as.length;
        // 1、对所有村民的存款进行排序
        Arrays.sort(as);
        // [1, 2, 3, 6, 9]

        // 2、计算两两村民之间的金额差，存到表中
        int[][] bs = new int[m][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                bs[i][j] = as[j - 1] - as[i];
            }
        }
        // [[0, 0, 1, 2, 5, 8], [0, 0, 0, 1, 4, 7], [0, 0, 0, 0, 3, 6], [0, 0, 0, 0, 0, 3], [0, 0, 0, 0, 0, 0]]

        // 3、以查表的方式统计能够分发的最大人数和已经分发的金额
        int maxCount = 0, maxAssigned = 0; // maxCount 拥有相同资产的人的数量，maxAssigned 能够捐出的最大捐款
        for (int j = 2; j <= m; j++) {
            int assigned = 0, count = 0; // assigned 已经分发的金额总量，count 资产相同的人的数量
            int i = j - 1; // 以第 i 个人为基准，将其他人的金额都调整到与第 i 人相同，观察这种分配方式下的分配结果是否满足题意
            while (i >= 0) {
                if (assigned + bs[i][j] < n) {
                    assigned += bs[i][j];
                    count++;
                }
                i--;
            }
            if (count > maxCount) {
                maxCount = count;
                maxAssigned = assigned;
            } else if (count == maxCount) {
                maxAssigned = Math.max(maxAssigned, assigned);
            }
        }
        System.out.printf("%d %d", maxCount, n - maxAssigned);
    }
}
