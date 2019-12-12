package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by boileryao on 12/11/2019.
 * Licensed under WTFPL©2019.
 */
public class MedianSortedArraysTest {
    MedianSortedArrays solution = new MedianSortedArrays();

    @Test
    public void fuckingTest() {
        Random random = new Random();
        int dimension = 9;
        for (int iter = 1; iter <= 20; iter++) {
            for (int i = 0; i < dimension; i++) {
                int[] nums1 = new int[i];
                int[] nums2 = new int[dimension - i];
                int i1 = 0, i2 = 0;
                for (int j = 0; j < dimension; j++) {
                    if (random.nextBoolean() && i1 < nums1.length) {
                        nums1[i1] = i1 + i2;
                        i1++;
                    } else if (i2 < nums2.length) {
                        nums2[i2] = i1 + i2;
                        i2++;
                    } else {
                        nums1[i1] = i1 + i2;
                        i1++;
                    }
                }
                System.out.printf("Round:%d, %s, %s.\n", iter, Arrays.toString(nums1), Arrays.toString(nums2));
                testMedianTwoSortedArray(nums1, nums2, (dimension - 1) / 2.0);
            }
        }
    }

    @Test
    public void testMedianTwoSortedArray_EmptyOdd() {
        double expected = 1;
        int[] nums1 = {1};
        int[] nums2 = {};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    @Test
    public void testMedianTwoSortedArray_EmptyEven() {
        double expected = 2.5;
        int[] nums1 = {1, 4};
        int[] nums2 = {};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    @Test
    public void testMedianTwoSortedArray_Odd2() {
        double expected = 3.5;
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    @Test
    public void testMedianTwoSortedArray_Even2() {
        double expected = 3.5;
        int[] nums1 = {1, 3, 4, 5};
        int[] nums2 = {2, 3, 4, 6};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    @Test
    public void testMedianTwoSortedArray_OddEven() {
        double expected = 3;
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    @Test
    public void testMedianTwoSortedArray_Fail1() {
        double expected = 2;
        int[] nums1 = {1};
        int[] nums2 = {2, 3};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    @Test
    public void testMedianTwoSortedArray_Fail2() {
        double expected = 1;
        int[] nums1 = {1};
        int[] nums2 = {1};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    @Test
    public void testMedianTwoSortedArray_Fail3() {
        double expected = 3.5;
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    @Test
    public void testMedianTwoSortedArray_Fail4() {
        double expected = 4;
        int[] nums1 = {1, 5, 7, 8};
        int[] nums2 = {0, 2, 3, 4, 6};
        testMedianTwoSortedArray(nums1, nums2, expected);
    }

    private void testMedianTwoSortedArray(int[] nums1, int[] nums2, double expected) {
        Assert.assertEquals(solution.findMedianSortedArrays(nums1, nums2), expected);
        Assert.assertEquals(solution.findMedianSortedArrays(nums2, nums1), expected);
    }
}
