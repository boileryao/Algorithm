package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 8/22/2019.
 * Licensed under WTFPL©2019.
 */
public class PalindromeNumberTest {
    PalindromeNumber solution = new PalindromeNumber();

    @Test
    public void testIsPalindrome_121() {
        Assert.assertTrue(solution.isPalindrome(121));
    }

    @Test
    public void testIsPalindrome_121NG() {
        Assert.assertFalse(solution.isPalindrome(-121));
    }

    @Test
    public void testIsPalindrome_10() {
        Assert.assertFalse(solution.isPalindrome(10));
    }

    @Test
    public void testIsPalindrome_Big1() {
        Assert.assertFalse(solution.isPalindrome(1234567899));
    }

    @Test
    public void testIsPalindrome_Big2() {
        Assert.assertTrue(solution.isPalindrome(123454321));
    }
}
