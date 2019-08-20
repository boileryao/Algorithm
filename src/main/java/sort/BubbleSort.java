package sort;

import java.util.Arrays;

/**
 * Created by boiler-yao on 2016/10/19.
 * Bubble sort
 */
public class BubbleSort {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int[] data = Data.longArr;
        sort(data);
        System.out.println(Arrays.toString(data));
        System.out.println(System.currentTimeMillis() - time + " ms used");
    }

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }

        }
    }
}
