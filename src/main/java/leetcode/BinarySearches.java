package leetcode;

import java.util.Arrays;

import static leetcode.LeetCode.Level.EASY;
import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 8/28/2019.
 * Licensed under WTFPL©2019.
 */
public class BinarySearches {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     */
    @LeetCode(id = 35, problemName = "search-insert-position", level = EASY)
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        do {
            mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } while (left <= right);
        return nums[mid] > target ? mid : mid + 1;
    }

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

    @LeetCode(id = 33, problemName = "search-in-rotated-sorted-array", level = MEDIUM)
    public int binarySearchRotated(int[] nums, int target) {
        int offset = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                offset = mid + 1;
                break;
            }
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                right = mid - 1;
            }
        }

        left = offset;
        right = offset + nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid % nums.length] == target) {
                return mid % nums.length;
            }
            if (nums[mid % nums.length] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    @SuppressWarnings("unused")
    public int searchFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && a[low] == value) return low;
        else return -1;
    }

    @SuppressWarnings("unused")
    public int searchLast(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    @SuppressWarnings("unused")
    public int searchFirstGe(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    @SuppressWarnings("unused")
    public int searchLastLe(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
