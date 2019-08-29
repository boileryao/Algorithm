package leetcode;

import static leetcode.LeetCode.Level.EASY;

/**
 * Created by boiler-yao on 2016/12/20.
 * Check if the given number is a power of ex2.
 */
public class PowerOfN {
    @LeetCode(id = 231, problemName = "power-of-two", level = EASY, accepted = true)
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n < 1) return false;

        return (1 << 31) % n == 0;
    }

    @LeetCode(id = 342, problemName = "power-of-four", level = EASY, accepted = true)
    public boolean isPowerOfFour(int num) {
        if (num < 1) return false;
        int hits = 0;
        for (int i = 0; i < 32; i += 2) {
            int lastTwoBits = num >> i & 0b11;
            if (lastTwoBits == 1) hits++;
            else if (lastTwoBits != 0) return false;
        }
        return hits == 1;
    }
}
