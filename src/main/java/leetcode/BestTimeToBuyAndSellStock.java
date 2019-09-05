package leetcode;

import static leetcode.LeetCode.Level.EASY;

/**
 * Created by boileryao on 9/5/2019.
 * Licensed under WTFPL©2019.
 */
public class BestTimeToBuyAndSellStock {
    @LeetCode(id = 121, problemName = "best-time-to-buy-and-sell-stock", level = EASY)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
