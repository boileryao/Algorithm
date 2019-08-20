package fuckoffer;

import java.util.Arrays;

/**
 * Created by boileryao on 2018/3/2.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class _03_DuplicationInArray {
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 0) return false;
        System.out.println();
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i && numbers[i] != numbers[numbers[i]]) {
                swap(numbers, i, numbers[i]);
                System.out.println("Swapping: " + Arrays.toString(numbers));
            }
            if (numbers[i] != i && numbers[i] == numbers[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            System.out.println("Round end: " + Arrays.toString(numbers));
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
