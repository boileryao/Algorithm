package leetcode;

import static leetcode.LeetCode.Level.EASY;

/**
 * Created by boileryao on 9/3/2019.
 * Licensed under WTFPL©2019.
 */
public class BitsOperations {
    @LeetCode(id = 136, problemName = "single-number", level = EASY, accepted = true)
    public int singleNumber(int[] nums) {
        int ops = 0;
        for (int num : nums) {
            ops ^= num;
        }
        return ops;
    }
}
