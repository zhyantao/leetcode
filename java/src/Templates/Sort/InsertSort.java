package Templates.Sort;

import Generator.RandomArrayGenerator;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = RandomArrayGenerator.generateRamdomArray(20, 100);
        RandomArrayGenerator.printArray(arr);
        insertsort(arr);
        RandomArrayGenerator.printArray(arr);
    }

    public static void insertsort(int[] arr) {
        int j; // 用于扫描 i 之前的元素
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > tmp; j--)
                arr[j] = arr[j - 1]; // 向后移动元素
            arr[j] = tmp;
        }
    }
}
