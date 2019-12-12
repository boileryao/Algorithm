package leetcode;

import static leetcode.LeetCode.Level.HARD;

/**
 * Created by boileryao on 2019/12/11.
 * Licensed under WTFPL©2019.
 */
public class MedianSortedArrays {
    @LeetCode(id = 4, problemName = "median-of-two-sorted-arrays", level = HARD)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {  // to ensure m<=n
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length, n = nums2.length;
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft;
                if (i == 0) { maxLeft = nums2[j - 1]; } else if (j == 0) { maxLeft = nums1[i - 1]; } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) { return maxLeft; }

                int minRight;
                if (i == m) { minRight = nums2[j]; } else if (j == n) { minRight = nums1[i]; } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    @LeetCode(id = 4, problemName = "median-of-two-sorted-arrays", level = HARD, accepted = false)
    public double myFindMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {  // to ensure m<=n
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length, n = nums2.length;
        int c1a = 0;
        int c1b = m;

        int k = (m + n) / 2;
        int c1 = (c1a + c1b) / 2; // 0..m
        int c2 = k - c1;

        while (!(
                (!(c2 >= 0 && c2 < n) || !(c1 >= 1 && c1 < m) || nums1[c1 - 1] <= nums2[c2]) &&
                        (!(c1 >= 0 && c1 < m) || !(c2 >= 1 && c2 < n) || nums2[c2 - 1] <= nums1[c1])
        )) {
//            if ((!(c1 >= 0 && c1 < m) || !(c2 >= 1 && c2 < n) || nums2[c2 - 1] <= nums1[c1])) {
            if (!(c2 >= 1) || nums2[c2 - 1] <= nums1[c1]) {
                c1 = (c1a + c1 - 1) / 2;
                c1b = c1;
                c2 = k - c1;
                continue;
            }

//            if ((!(c2 >= 0 && c2 < n) || !(c1 >= 1 && c1 < m) || nums1[c1 - 1] <= nums2[c2])) {
            if (!(c1 >= 1) || nums1[c1 - 1] <= nums2[c2]) {
                c1 = (c1b + c1 + 1) / 2;
                c1a = c1;
                c2 = k - c1;
                continue;
            }
            break;
        }

        int rightMin = Math.min(getOrDefault(nums1, c1, Integer.MAX_VALUE), getOrDefault(nums2, c2, Integer.MAX_VALUE));
        int leftMax = Math.max(
                getOrDefault(nums1, c1 - 1, Integer.MIN_VALUE), getOrDefault(nums2, c2 - 1, Integer.MIN_VALUE));
        if ((m + n) % 2 == 0) {
            return (rightMin + leftMax) / 2.0;
        } else {
            return rightMin;
        }
    }

    private int getOrDefault(int[] arr, int idx, int dft) {
        if (idx >= 0 && idx < arr.length) {
            return arr[idx];
        }
        return dft;
    }
}
