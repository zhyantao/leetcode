package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LC0406_QueueRecontructionByHeight {

    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                // 第一关键字按照 ↑ 排列
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else { // 第二关键字按照 ↓ 排列
                    return person2[1] - person1[1];
                }
            }
        });

        int n = people.length;
        int[][] ans = new int[n][]; // 第二维度可省略

        for (int[] person : people) {
            int spaces = person[1] + 1; // 用 spaces 去找空位置
            for (int i = 0; i < n; i++) {
                if (ans[i] == null) { // 找到空位置填下
                    spaces--;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = reconstructQueue(people);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

}
