package leetcode;

import sort.QuickSort;

/**
 * Created by boileryao on 2020/1/4.
 * Licensed under WTFPL©2020.
 */
public class SortRocks {
    @LeetCode(id = 215, problemName = "kth-largest-element-in-an-array", level = LeetCode.Level.MEDIUM)
    public int findKthLargest(int[] nums, int k) {
        int a = 0, b = nums.length - 1;
        int mid = QuickSort.partition(nums, a, b);
        while (mid != (nums.length - k)) {
            mid = mid < nums.length - k
                    ? QuickSort.partition(nums, mid + 1, b)
                    : QuickSort.partition(nums, a, mid - 1);
        }
        return nums[mid];
    }
}
