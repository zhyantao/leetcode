package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC0046_Permutations {

    public static List<List<Integer>> ans = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0) {
            return ans;
        }

        boolean[] used = new boolean[nums.length];
        dfs(nums, used, 0);

        return ans;

    }

    public static void dfs(int[] arr, boolean[] used, int i) {
        if (i == arr.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < arr.length; j++) {
            if (!used[j]) {
                path.add(arr[j]);
                used[j] = true;
                dfs(arr, used, i + 1);
                used[j] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}
