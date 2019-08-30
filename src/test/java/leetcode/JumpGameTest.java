package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 8/30/2019.
 * Licensed under WTFPL©2019.
 */
public class JumpGameTest {
    JumpGame solution = new JumpGame();

    @Test
    public void testCanJump_Case1_Can() {
        Assert.assertTrue(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void testCanJump_Case2_Ng() {
        Assert.assertFalse(solution.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void testCanJump_Fail1_Ng() {
        Assert.assertFalse(solution.canJump(new int[]{0, 2, 3}));
    }
}
