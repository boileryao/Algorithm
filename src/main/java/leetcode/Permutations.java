package leetcode;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 9/3/2019.
 * Licensed under WTFPL©2019.
 */
public class Permutations {
    /**
     * https://zh.wikipedia.org/wiki/全排列生成算法
     *
     * @param nums, generate nums next permutation
     */
    @LeetCode(id = 31, problemName = "next-permutation", level = MEDIUM, accepted = true)
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int hipIndex = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                hipIndex = i;
                break;
            }
        }

        int minGreaterIndex = hipIndex;
        if (hipIndex > 0) {
            int minGreater = nums[minGreaterIndex];
            for (int i = hipIndex - 1; i < nums.length; i++) {
                if (nums[i] > nums[hipIndex - 1] && nums[i] <= minGreater) {
                    minGreater = nums[i];
                    minGreaterIndex = i;
                }
            }
            swap(nums, minGreaterIndex, hipIndex - 1);
        }
        reverse(nums, hipIndex);
    }

    // Very clean implementation, from https://leetcode-cn.com/problems/next-permutation/solution
    @SuppressWarnings("unused")
    public void _nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
