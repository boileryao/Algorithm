package sort;

import java.util.Arrays;

/**
 * Created by boiler-yao on 2016/10/29.
 * Heap sort
 */
public class HeapSort {
    static int[] arr = new int[]{3, 1, 5, 9, 4, 2, 10, 9, 16, 22};
    static double ln2 = Math.log(2);
    static int length = arr.length;

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            heapSort.buildMaxHeap(arr);
            int tmp = arr[length - 1];
            arr[length - 1] = arr[0];
            arr[0] = tmp;
            length--;
        }
        System.out.println(Arrays.toString(arr));
    }

    void buildMaxHeap(int[] arr) {
        for (int i = length - 1; i >= 0; i--) {
            heapMaximize(arr, i);
        }
    }

    /**
     * This method requires elements under arr[i] is MAX-HEAP
     * Call this method repeat to build a MAX-HEAP
     */
    void heapMaximize(int[] arr, int i) {
        int l = left(i);
        int r = right(i);
        int largest = l < length && arr[l] > arr[i] ? l : i;
        largest = r < length && arr[r] > arr[largest] ? r : largest;
        if (largest != i) {
            int tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            heapMaximize(arr, largest);
        }
    }

    int parent(int index) {
        return index == 0 ? -1 : (index - 1) / 2;
    }

    int left(int index) {
        return index * 2 + 1;
    }

    int right(int index) {
        return index * 2 + 2;
    }

    void tree() {
        int depth = (int) (Math.log(2 * arr.length) / ln2);
        int cnt = 2;
        for (int i = 0; i < arr.length; i++) {
            if (i == cnt - 1) {
                System.out.println();
                cnt = cnt * 2;
            }
            System.out.printf("%3d", arr[i]);
        }
    }
}
