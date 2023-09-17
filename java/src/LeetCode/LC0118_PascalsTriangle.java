package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0118_PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        if (numRows < 1) {
            return ans;
        }

        // 将头元素插入进去
        ans.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 2; i <= numRows; i++) {

            List<Integer> path = new ArrayList<>(); // 第 i 层
            path.add(1); // 开头的 1

            List<Integer> pre = ans.get(ans.size() - 1); // ans 中的最后一层
            for (int j = 1; j < pre.size(); j++) {
                path.add(pre.get(j - 1) + pre.get(j));
            }
            path.add(1); // 末尾的 1
            ans.add(path);
        }

        return ans;

    }

}
