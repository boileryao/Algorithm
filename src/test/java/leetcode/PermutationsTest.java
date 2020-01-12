package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by boileryao on 9/2/2019.
 * Licensed under WTFPL©2019.
 */
public class PermutationsTest {
    Permutations solution = new Permutations();

    @Test
    public void testPermutation() {
        solution.permute(new int[]{1, 2, 3})
                .forEach(set -> System.out.println(Arrays.toString(set.toArray())));
    }

    @Test
    public void testPermutation_Fail1() {
        solution.permute(new int[]{5, 4, 6, 2})
                .forEach(set -> System.out.println(Arrays.toString(set.toArray())));
    }

    @Test
    public void testNextPermutation_01() {
        int[] nums = new int[]{1, 2, 3};
        solution.nextPermutation(nums);
        Assert.assertEquals(nums, new int[]{1, 3, 2});
    }

    @Test
    public void testNextPermutation_02() {
        int[] nums = new int[]{3, 2, 1};
        solution.nextPermutation(nums);
        Assert.assertEquals(nums, new int[]{1, 2, 3});
    }

    @Test
    public void testNextPermutation_03() {
        int[] nums = new int[]{1, 1, 5};
        solution.nextPermutation(nums);
        Assert.assertEquals(nums, new int[]{1, 5, 1});
    }

    @Test
    public void testNextPermutation_04() {
        int[] nums = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        solution.nextPermutation(nums);
        Assert.assertEquals(nums, new int[]{1, 5, 8, 5, 1, 3, 4, 6, 7});
    }


    @Test
    public void testNextPermutation_Fail1() {
        int[] nums = new int[]{1, 3, 2};
        solution.nextPermutation(nums);
        Assert.assertEquals(nums, new int[]{2, 1, 3});
    }

    @Test
    public void testNextPermutation_Fail2() {
        int[] nums = new int[]{2, 3, 1, 3, 3};
        solution.nextPermutation(nums);
        Assert.assertEquals(nums, new int[]{2, 3, 3, 1, 3});
    }
}
