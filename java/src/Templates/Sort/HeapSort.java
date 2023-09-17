package Templates.Sort;

import Generator.RandomArrayGenerator;

public class HeapSort {

    public static void main(String[] args) {

        for (int j = 0; j < 1000; j++) {
            int[] nums = RandomArrayGenerator.generateRamdomArray(20, 30);
            RandomArrayGenerator.printArray(nums);

            heapSort(nums);

            RandomArrayGenerator.printArray(nums);
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 构建大根堆（方法一）
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        // 构建大根堆（方法二）
//        for (int i = arr.length - 1; i >= 0; i--) {
//            heapify(arr, i, arr.length);
//        }

        // 每次选择并移除堆顶元素，放到末尾
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapify(int[] arr, int i, int heapSize) {
        while (i < heapSize) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int max = i;

            if (l < heapSize && arr[l] > arr[max])
                max = l;
            if (r < heapSize && arr[r] > arr[max])
                max = r;
            if (max == i)
                break;
            swap(arr, i, max);
            i = max;
        }
    }

    public static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
