package leetcode;

/**
 * Created by boileryao on 2018/4/5.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 5};
        assert coinChange(coins, 0) == 0;
        assert coinChange(coins, 1) == 1;
        assert coinChange(coins, 2) == 2;
        assert coinChange(coins, 3) == 1;
        assert coinChange(coins, 4) == 2;
        assert coinChange(coins, 5) == 1;
        assert coinChange(coins, 6) == 2;
        assert coinChange(coins, 7) == 3;
        assert coinChange(coins, 10) == 2;

        assert coinChange(new int[]{2}, 3) == -1;
    }

    @LeetCode(id = 322, problemName = "coin-change", level = LeetCode.Level.MEDIUM)
    public static int coinChange(int[] coins, int amount) {
        int[] mins = new int[amount + 1];  // all cells are 0
        for (int amt = 1; amt <= amount; amt++) {
            mins[amt] = -1;
            for (int val : coins) {
                if (amt >= val && mins[amt - val] != -1) {
                    if (mins[amt] == -1) mins[amt] = Integer.MAX_VALUE;
                    mins[amt] = Math.min(mins[amt], mins[amt - val] + 1);
                }
            }
        }
        return mins[amount];
    }
}
