package Templates.Sort;

import java.util.Arrays;

import Generator.RandomArrayGenerator;

public class RadixSort {

    // 只能对正数进行排序
    public static void main(String[] args) {
        boolean succeed = true;
        for (int i = 0; i < 50; i++) {
            int[] arr1 = RandomArrayGenerator.generateRamdomArray(20, 100);
            int[] arr2 = RandomArrayGenerator.copyArray(arr1);
            radixSort(arr1);
            System.out.println(Arrays.toString(arr1));
            Arrays.sort(arr2);
            System.out.println(Arrays.toString(arr2));
            if (!RandomArrayGenerator.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10; // 桶的个数
        int i = 0, j = 0; // 临时变量
        int[] bucket = new int[R - L + 1]; // 桶的大小
        for (int d = 1; d <= digit; d++) { // 出桶和入桶的次数
            int[] count = new int[radix];
            // 分桶，并计数
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d); // 获取第 d 位的数字
                count[j]++;
            }
            // 求累加和
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            // 将桶中的元素倒出来
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        int res = 0;
        while (d > 0) {
            res = x % 10;
            x = x / 10;
            d--;
        }
        return Math.abs(res);
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }
}
