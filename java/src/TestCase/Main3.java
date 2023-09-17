package TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        process(arr, k);
    }

    public static void process(int[] arr, int k) {
        int[] preSum = new int[arr.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        System.out.println(Arrays.toString(preSum));
        int count = 0;
        for (int i = 1; i < preSum.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (preSum[i] - preSum[j] == k) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
