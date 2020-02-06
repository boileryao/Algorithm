package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 9/5/2019.
 * Licensed under WTFPL©2019.
 */
public class BestTimeToBuyAndSellStockTest {
    BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

    @Test
    public void testMaxProfit_Case1() {
        Assert.assertEquals(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
    }

    @Test
    public void testMaxProfit_Case2() {
        Assert.assertEquals(solution.maxProfit(new int[]{0}), 0);
    }

    @Test
    public void testMaxProfit2_Case1() {
        Assert.assertEquals(solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}), 7);
    }

    @Test
    public void testMaxProfit2_Case2() {
        Assert.assertEquals(solution.maxProfit2(new int[]{1, 2, 3, 4, 5}), 4);
    }

    @Test
    public void testMaxProfit2_Case3() {
        Assert.assertEquals(solution.maxProfit2(new int[]{7, 6, 4, 3, 1}), 0);
    }
}
