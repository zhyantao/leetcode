package Templates.Sort;

import Generator.RandomArrayGenerator;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = RandomArrayGenerator.generateRamdomArray(20, 100);
        RandomArrayGenerator.printArray(arr);
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        RandomArrayGenerator.printArray(arr);
    }

    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, mid, right);
        }
    }

    public static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        int pLeft = left, pRight = mid + 1;
        int pTmp = left;

        while (pLeft <= mid && pRight <= right) {
            if (arr[pLeft] <= arr[pRight]) {
                tmp[pTmp++] = arr[pLeft++];
            } else {
                tmp[pTmp++] = arr[pRight++];
            }
        }
        while (pLeft <= mid) {
            tmp[pTmp++] = arr[pLeft++];
        }
        while (pRight <= right) {
            tmp[pTmp++] = arr[pRight++];
        }
        if (right + 1 - left >= 0)
            System.arraycopy(tmp, left, arr, left, right + 1 - left);
    }
}
