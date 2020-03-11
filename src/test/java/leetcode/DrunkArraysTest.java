package leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by boileryao on 2020/3/11.
 * Licensed under WTFPL©2020.
 */
public class DrunkArraysTest {
    private DrunkArrays drunkArrays = new DrunkArrays();

    @Test
    public void testCanThreePartsEqualSum_True() {
        assertTrue(drunkArrays.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
    }

    @Test
    public void testCanThreePartsEqualSum_AnotherTrue() {
        assertTrue(drunkArrays.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }

    @Test
    public void testCanThreePartsEqualSum_False() {
        assertFalse(drunkArrays.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
    }

    @Test
    public void testCanThreePartsEqualSum_Fail1() {
        assertTrue(drunkArrays.canThreePartsEqualSum(new int[]{10, -10, 10, -10, 10, -10, 10, -10}));
    }
}
