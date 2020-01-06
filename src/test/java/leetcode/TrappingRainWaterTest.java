package leetcode;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by boileryao on 2020/1/6.
 * Licensed under WTFPL©2020.
 */
public class TrappingRainWaterTest {
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    Map<int[], Integer> testCases = new HashMap<>();

    @BeforeTest
    public void fillTestCases() {
        testCases.put(new int[]{5, 2, 1, 2, 1, 5}, 14);
        testCases.put(new int[]{5, 4, 1, 2}, 1);
        testCases.put(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6);
        testCases.put(new int[]{0, 1, 1, 2, 1}, 0);
        testCases.put(new int[]{0, 1, 1}, 0);
        testCases.put(new int[]{1, 0, 1}, 1);
        testCases.put(new int[]{1, 0, 1, 0, 1}, 2);
    }

    @Test
    public void testTrap() {
        testCases.forEach((height, expect) -> {
            int actual = trappingRainWater.trap(height);
            Assert.assertEquals(actual, expect.intValue(), Arrays.toString(height));
        });
    }

    @Test
    public void testTrapNaive() {
        testCases.forEach((height, expect) -> {
            int actual = trappingRainWater.trapSquare(height);
            Assert.assertEquals(actual, expect.intValue(), Arrays.toString(height));
        });
    }
}
