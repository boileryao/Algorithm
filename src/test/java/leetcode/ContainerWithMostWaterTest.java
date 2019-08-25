package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 8/25/2019.
 * Licensed under WTFPL©2019.
 */
public class ContainerWithMostWaterTest {
    ContainerWithMostWater solution = new ContainerWithMostWater();

    @Test
    public void testMaxArea() {
        int actualMax = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assert.assertEquals(actualMax, 49);
    }

    @Test
    public void testMaxAreaBruteForce() {
        int actualMax = solution.maxAreaBruteForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assert.assertEquals(actualMax, 49);
    }
}
