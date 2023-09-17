package Templates;

import Generator.RandomArrayGenerator;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = RandomArrayGenerator.generateRamdomArray(100, 9);
        RandomArrayGenerator.printArray(arr);
        int idx = binarySearch(arr, 0, arr.length - 1, 6);
        System.out.println(idx);
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                return binarySearch(arr, left, mid - 1, target);
            }
            if (arr[mid] < target) {
                return binarySearch(arr, mid + 1, right, target);
            }
        }
        return -1; // 没找到
    }
}
