package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 9/3/2019.
 * Licensed under WTFPL©2019.
 */
public class BitsOperationsTest {
    BitsOperations solution = new BitsOperations();

    @Test
    public void testSingleNumber_Case1() {
        Assert.assertEquals(solution.singleNumber(new int[]{2, 2, 1}), 1);
    }

    @Test
    public void testSingleNumber_Case2() {
        Assert.assertEquals(solution.singleNumber(new int[]{4, 1, 2, 1, 2}), 4);
    }
}
