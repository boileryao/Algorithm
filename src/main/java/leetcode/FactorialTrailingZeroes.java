package leetcode;

/**
 * Created by boileryao on 2018/4/5.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        assert trailingZeroes(1) == 0;
        assert trailingZeroes(4) == 0;
        assert trailingZeroes(5) == 1;
        assert trailingZeroes(10) == 2;
        assert trailingZeroes(30) == 7;
        assert trailingZeroes(100) == 25;
    }

    @LeetCode(id = 172, problemName = "factorial-trailing-zeroes", level = LeetCode.Level.EASY)
    public static int trailingZeroes(int n) {
        int tmp = n;
        int zeroes = 0;
        while (tmp > 0) {
            zeroes += tmp /= 5;
        }
        return zeroes;
    }
}
