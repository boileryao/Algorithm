package sort;

import java.util.Arrays;

/**
 * Created by boiler-yao on 2016/10/29.
 * fast sort
 */
public class QuickSort {
    //    static int[] data = {1, 5, 2, 4, 6, 3};
    static int[] data = Data.longArr;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        System.out.println(System.currentTimeMillis() - time + " ms used");
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = partition(arr, start, end);
            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }


    /**
     * A partition implementation in "Introduction to Algorithms"
     *
     * @param arr   the array to be sort
     * @param start the start position of this arr
     * @param end   same as above
     *              note that index begins at '0'
     */
    public static int partition(int[] arr, int start, int end) {
        int head = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]) {
                head++;
                int tmp = arr[head];
                arr[head] = arr[i];
                arr[i] = tmp;
            }
        }
        int tmp = arr[head + 1];
        arr[head + 1] = arr[end];
        arr[end] = tmp;
        return head + 1;
    }
}
