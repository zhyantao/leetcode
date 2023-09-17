package Templates.Sort;

import Generator.RandomArrayGenerator;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = RandomArrayGenerator.generateRamdomArray(20, 100);
        RandomArrayGenerator.printArray(arr);
        quicksort(arr, 0, arr.length - 1);
        RandomArrayGenerator.printArray(arr);
    }

    // 快排的递归实现
    public static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quicksort(arr, left, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, right);
        }
    }

    // 返回一趟排序后，目标元素对应位置的下标
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // 基准点
        int le = left, ge = right; // 不要修改原来的
        while (le < ge) {
            while (le < ge && arr[ge] > pivot) {
                ge--;
            }
            if (le < ge) {
                arr[le] = arr[ge];
                le++;
            }

            while (le < ge && arr[le] < pivot) {
                le++;
            }
            if (le < ge) {
                arr[ge] = arr[le];
                ge--;
            }
        }
        arr[le] = pivot;
        return ge;
    }
}
