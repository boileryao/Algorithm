package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/3/9.
 * Licensed under WTFPL©2020.
 */
public class ThreeSumTest {
    private ThreeSum threeSum = new ThreeSum();

    @Test
    public void testThreeSumClosest() {
        int[] nums = {-1, 2, 1, -4};
        Assert.assertEquals(threeSum.threeSumClosest(nums, 1), 2);
    }

    @Test
    public void testThreeSumClosest_Fail1() {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        Assert.assertEquals(threeSum.threeSumClosest(nums, 82), 82);
    }
}
