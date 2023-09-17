package Templates.Sort;

import Generator.RandomArrayGenerator;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = RandomArrayGenerator.generateRamdomArray(20, 100);
        RandomArrayGenerator.printArray(arr);
        shellSort(arr);
        RandomArrayGenerator.printArray(arr);
    }

    public static void shellSort(int[] arr) {
        int len = arr.length;
        for (int step = len / 2; step >= 1; step /= 2) {
            for (int r = step; r < len; r++) {
                int tmp = arr[r];
                int l = r - step;
                while (l >= 0 && arr[l] > tmp) {
                    arr[l + step] = arr[l];
                    l -= step;
                }
                arr[l + step] = tmp;
            }
        }
    }

}
