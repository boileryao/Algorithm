package leetcode;

/**
 * Created by boileryao on 8/22/2019.
 * Licensed under WTFPL©2019.
 */
public class PalindromeNumber {
    @LeetCode(id = 9, problemName = "palindrome-number", level = LeetCode.Level.EASY)
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int lastHalfReverted = 0;
        int firstHalf = x;

        while (firstHalf > lastHalfReverted) {
            lastHalfReverted = lastHalfReverted * 10 + firstHalf % 10;
            firstHalf /= 10;
        }

        return firstHalf == lastHalfReverted || firstHalf == lastHalfReverted / 10;
    }
}
