package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 9/7/2019.
 * Licensed under WTFPL©2019.
 */
public class PlusOneTest {
    PlusOne solution = new PlusOne();

    @Test
    public void testPlusOne_Normal1() {
        int[] actual = solution.plusOne(new int[]{1, 2, 3});
        int[] expect = new int[]{1, 2, 4};
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void testPlusOne_Normal2() {
        int[] actual = solution.plusOne(new int[]{4, 3, 2, 1});
        int[] expect = new int[]{4, 3, 2, 2};
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void testPlusOne_EndWithNice() {
        int[] actual = solution.plusOne(new int[]{6, 9});
        int[] expect = new int[]{7, 0};
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void testPlusOne_AllNine() {
        int[] actual = solution.plusOne(new int[]{9, 9});
        int[] expect = new int[]{1, 0, 0};
        Assert.assertEquals(actual, expect);
    }


}
