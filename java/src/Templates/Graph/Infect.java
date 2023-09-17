package Templates.Graph;

public class Infect {

    // 求连通域的个数
    int count(int[][] nums) {
        if (nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        int N = nums.length;
        int M = nums[0].length;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (nums[i][j] == 1) {
                    ans++;
                    infect(nums, i, j, N, M);
                }
            }
        }

        return ans;
    }

    public void infect(int[][] nums, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || nums[i][j] != 1) {
            return;
        }

        nums[i][j] = 2;
        infect(nums, i + 1, j, N, M);
        infect(nums, i - 1, j, N, M);
        infect(nums, i, j + 1, N, M);
        infect(nums, i, j - 1, N, M);
    }

}
