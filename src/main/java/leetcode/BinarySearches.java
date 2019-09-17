package leetcode;

import java.util.Arrays;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 8/28/2019.
 * Licensed under WTFPL©2019.
 */
public class BinarySearches {
    @LeetCode(id = 34, problemName = "find-first-and-last-position-of-element-in-sorted-array", level = MEDIUM)
    public int[] searchRange(int[] nums, int target) {
        int someIdx = Arrays.binarySearch(nums, target);
        if (someIdx < 0) return new int[]{-1, -1};

        int low = someIdx, high = nums.length - 1;
        int lastIdx = someIdx;
        do {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                lastIdx = Math.max(lastIdx, mid);
                low = mid + 1;
            } else {  // great than
                high = mid - 1;
            }
        } while (low <= high);

        low = 0;
        high = someIdx;
        int firstIdx = someIdx;
        do {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                firstIdx = Math.min(firstIdx, mid);
                high = mid - 1;
            } else {  // less than
                low = mid + 1;
            }
        } while (low <= high);

        return new int[]{firstIdx, lastIdx};
    }
}
