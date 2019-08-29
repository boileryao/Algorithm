package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 8/29/2019.
 * Licensed under WTFPL©2019.
 */
public class PowerOfNTest {
    PowerOfN solution = new PowerOfN();

    @Test
    public void testIsPowerOfTwo_1() {
        Assert.assertTrue(solution.isPowerOfTwo(1));
    }

    @Test
    public void testIsPowerOfTwo_2() {
        Assert.assertTrue(solution.isPowerOfTwo(2));
    }

    @Test
    public void testIsPowerOfTwo_1024() {
        Assert.assertTrue(solution.isPowerOfTwo(1024));
    }

    @Test
    public void testIsPowerOfFour_1() {
        Assert.assertTrue(solution.isPowerOfFour(1));
    }

    @Test
    public void testIsPowerOfFour_1024() {
        Assert.assertTrue(solution.isPowerOfFour(1024));
    }

    @Test
    public void testIsPowerOfFour_2048() {
        Assert.assertFalse(solution.isPowerOfFour(2048));
    }

    @Test
    public void testIsPowerOfFour_fail1() {
        Assert.assertFalse(solution.isPowerOfFour(6));
    }
}
