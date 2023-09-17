package Templates.OptTips;

import java.util.Arrays;

// 差分技巧适用场景：数组区间修改 + 单点查询
// https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247490329&idx=1&sn=6d448a53cd722bbd990fda82bd262857
public class DiffArray {

    // 求差分数组
    public static int[] getDiffArray(int[] arr) {
        assert arr.length > 0;
        int[] diff = new int[arr.length];
        diff[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
        return diff;
    }

    // 通过差分数组求原数组
    public static int[] getOriginArray(int[] diff) {
        int[] origin = new int[diff.length];
        origin[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            origin[i] = origin[i - 1] + diff[i];
        }
        return origin;
    }

    // 给闭区间 [i, j] 增加 val（可以是负数）
    public static int[] increment(int[] diff, int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
        return diff;
    }

    // 差分数组
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 2, 4, 3, 5, 6, -1, 20};

        // 求差分数组
        int[] diff = getDiffArray(arr);
        System.out.println(Arrays.toString(diff));

        // 通过差分数组还原原来的数组
        int[] origin = getOriginArray(diff);
        System.out.println(Arrays.toString(origin));

        // 让 [0, 3] 的四个数字都加 3
        int[] newDiff = increment(diff, 0, 3, 3);
        System.out.println(Arrays.toString(getOriginArray(newDiff)));
    }

}
