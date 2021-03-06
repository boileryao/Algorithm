package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 8/31/2019.
 * Licensed under WTFPL©2019.
 */
public class ArrayOperationsTest {
    ArrayOperations solution = new ArrayOperations();

    @Test
    public void testRemoveDuplicates_Case1() {
        int[] nums = new int[]{1, 1, 2};
        int actual = solution.removeDuplicates(nums);
        Assert.assertEquals(actual, 2);
        Assert.assertEquals(nums[1], 2);
    }

    @Test
    public void testRemoveDuplicates_Case2() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int actual = solution.removeDuplicates(nums);
        Assert.assertEquals(actual, 5);
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(nums[i], i);
        }
    }

    @Test
    public void testRemoveElement() {
        int[] nums = {3, 2, 2, 3};
        int newLength = solution.removeElement(nums, 3);
        Assert.assertEquals(newLength, 2);
        Assert.assertEquals(nums[0], 2);
        Assert.assertEquals(nums[1], 2);
    }

    @Test
    public void testMaxSubArray() {
        int[] nums = {-2, 11, -4, 13, -5, -2};
        int actual = solution.maxSubArray(nums);
        Assert.assertEquals(actual, 20);
    }
}
