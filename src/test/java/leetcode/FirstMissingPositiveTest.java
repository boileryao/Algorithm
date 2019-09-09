package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 9/9/2019.
 * Licensed under WTFPL©2019.
 */
public class FirstMissingPositiveTest {
    FirstMissingPositive solution = new FirstMissingPositive();

    @Test
    public void testFirstMissingPositive_Case1() {
        int actual = solution.firstMissingPositive(new int[]{1, 2, 0});
        Assert.assertEquals(actual, 3);
    }

    @Test
    public void testFirstMissingPositive_Case2() {
        int actual = solution.firstMissingPositive(new int[]{3, 4, -1, 1});
        Assert.assertEquals(actual, 2);
    }

    @Test
    public void testFirstMissingPositive_Case3() {
        int actual = solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12});
        Assert.assertEquals(actual, 1);
    }

    @Test
    public void testFirstMissingPositive_AllSet() {
        int actual = solution.firstMissingPositive(new int[]{2, 3, 1});
        Assert.assertEquals(actual, 4);
    }
}
