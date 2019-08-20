package sort;

import java.util.Arrays;

/**
 * Created by boiler-yao on 2016/10/19.
 * Merge sort
 * Notice:
 * Integer.MAX_VALUE is used to be a watcher
 */
public class MergeSort {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int[] data = Data.longArr;
        sort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        System.out.println(System.currentTimeMillis() - time + " ms used");
    }

    private static void sort(int[] data, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(data, p, q);
            sort(data, q + 1, r);
            merge(data, p, q, r);
        }
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int[] tmp1 = new int[q - p + 2];
        int[] tmp2 = new int[r - q + 1];
        int index1 = 0, index2 = 0;
        tmp1[tmp1.length - 1] = Integer.MAX_VALUE;
        tmp2[tmp2.length - 1] = Integer.MAX_VALUE;

        System.arraycopy(arr, p, tmp1, 0, q - p + 1);
        System.arraycopy(arr, q + 1, tmp2, 0, r - q);
        for (int i = 0; i <= r - p; i++) {
            arr[p + i] = tmp1[index1] > tmp2[index2] ? tmp2[index2++] : tmp1[index1++];
        }
    }
}