package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by boileryao on 10/27/2018.
 * Licensed under WTFPL©2018.
 */
public class MissingRanges {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 3, 50, 75};
        List<String> missingRanges = missingRanges(arr, -10, 89);
        missingRanges.forEach(System.out::println);
    }

    @LeetCode(id = 163, problemName = "MissingRanges", accepted = true)
    public static List<String> missingRanges(int[] arr, int lower, int upper) {
        List<String> missingRanges = new LinkedList<>();
        if (arr.length == 0) {
            missingRanges.add(String.format("%d->%d", lower, upper));
            return missingRanges;
        }

        int lowIter = lower;
        if (arr[0] > lower) {
            missingRanges.add(formatMissing(lower, arr[0] - 1));
            lowIter = arr[0];
        }

        for (int num : arr) {
            if (num == lowIter) {
                lowIter++; continue;
            }

            if (num >= upper) {
                missingRanges.add(formatMissing(lowIter, upper));
                break;
            }

            missingRanges.add(formatMissing(lowIter, num - 1));
            lowIter = num + 1;
        }

        if (arr[arr.length - 1] < upper) {
            missingRanges.add(formatMissing(arr[arr.length - 1] + 1, upper));
        }

        return missingRanges;
    }

    /**
     * @param lower included
     * @param upper included
     * @return formatted missing array of [lower, upper)
     */
    private static String formatMissing(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(upper);
        }
        return String.format("%d->%d", lower, upper);
    }
}
