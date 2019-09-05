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
}
