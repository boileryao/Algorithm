package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/3/27.
 * Licensed under WTFPL©2020.
 */
public class SlidingWindowMaximumTest {
    private final int k = 3;
    private int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    private int[] expect = {3, 3, 5, 5, 6, 7};
    private SlidingWindowMaximum solution = new SlidingWindowMaximum();

    @Test
    public void testBenchMark() {
        Assert.assertEquals(solution.benchMark_ON(nums, k), expect);
    }

    @Test
    public void testMaxSlidingWindow() {
        Assert.assertEquals(solution.maxSlidingWindow(nums, k), expect);
    }

    @Test
    public void testMaxSlidingWindow_ONLGN_TreeMap() {
        Assert.assertEquals(solution.maxSlidingWindow_ONLGN_TreeMap(nums, k), expect);
    }
}
