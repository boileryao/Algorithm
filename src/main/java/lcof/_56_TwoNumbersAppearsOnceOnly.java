package lcof;

import org.testng.internal.collections.Pair;

/**
 * Created by boileryao on 2018/9/4.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class _56_TwoNumbersAppearsOnceOnly {
    /**
     * There are two and only two numbers that appear only once in an array,
     * other numbers appears twice exactly. Find the two numbers.
     * Limitation: Time O(n), Space O(1)
     * Sample: input{@code [2, 4, 3, 6, 3, 2, 5, 5]}, and we get 4 and 6
     */
    public static Pair<Integer, Integer> findTheTwoSingleNumbers(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        int conv = 0;  // 0 ^ X = X
        for (int num : arr) conv ^= num;

        int firstDiffBit = Integer.lowestOneBit(conv);

        int convA = 0;
        int convB = 0;
        for (int num : arr) {
            boolean isNthBitOne = isNthBitOne(num, firstDiffBit);
            if (isNthBitOne) {
                convA ^= num;
            } else {
                convB ^= num;
            }
        }

        return new Pair<>(convA, convB);
    }

    public static boolean isNthBitOne(int num, int n) {
        if (n <= 0) return false;
        return ((num >> n - 1) & 0x1) == 0x1;
    }
}
