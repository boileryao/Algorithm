package leetcode;

/**
 * Created by boileryao on 2018/2/11.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        for (int num : new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE / 10, Integer.MIN_VALUE, Integer.MIN_VALUE / 10,
                0, -123, 120, 1234, -1290}) {
            System.out.println(num + " --> " + reverse(num));
        }
    }

    @LeetCode(id = 7, problemName = "reverse-integer", level = LeetCode.Level.EASY)
    private static int reverse(int x) {
        int tmp = x;
        int reversed = 0;
        while (tmp != 0) {
            int lastDigit = tmp % 10;
            tmp /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE / 10) {
                return 0;
            }
            reversed = reversed * 10 + lastDigit;
        }
        return reversed;
    }
}
