package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by boileryao on 2019/9/29.
 * Licensed under WTFPL©2019.
 */
public class StringOperationsTest {
    StringOperations solution = new StringOperations();

    @Test
    public void testLongestCommonPrefix_Case1() {
        String actual = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Assert.assertEquals(actual, "fl");
    }

    @Test
    public void testLongestCommonPrefix_Case2() {
        String actual = solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testLongestCommonPrefix_Fail1() {
        String actual = solution.longestCommonPrefix(new String[]{"aa", "a"});
        Assert.assertEquals(actual, "a");
    }

    @Test
    public void testLongestCommonPrefix_Fail2() {
        String actual = solution.longestCommonPrefix(new String[]{"aaa", "aa", "aaa"});
        Assert.assertEquals(actual, "aa");
    }

    @Test
    public void testMinDistance_Case1() {
        int actual = solution.minDistance("sea", "eat");
        Assert.assertEquals(actual, 2);
    }

    @Test
    public void testMinDistance_SameChar() {
        int actual = solution.minDistance("ss", "sssss");
        Assert.assertEquals(actual, 3);
    }

    @Test
    public void testMinDistance_OneBlank() {
        int actual = solution.minDistance("ss", "");
        Assert.assertEquals(actual, 2);
    }

    @Test
    public void testMinDistance_Fail1() {
        int actual = solution.minDistance("food", "money");
        Assert.assertEquals(actual, 7);
    }

    @Test
    public void testMinDistance_Fail2() {
        int actual = solution.minDistance("park", "spake");
        Assert.assertEquals(actual, 3);
    }

    @Test
    public void testLengthOfLastWord() {
        Assert.assertEquals(solution.lengthOfLastWord("Hello World"), 5);
        Assert.assertEquals(solution.lengthOfLastWord("Hello World "), 5);
        Assert.assertEquals(solution.lengthOfLastWord(" "), 0);
    }

    @Test
    public void testLongestPalindrome_Case1() {
        List<String> acceptable = Arrays.asList("bab", "aba");
        String actual = solution.longestPalindrome("babad");
        Assert.assertTrue(acceptable.contains(actual));
    }

    @Test
    public void testLongestPalindrome_Case2() {
        String actual = solution.longestPalindrome("cbbd");
        Assert.assertEquals(actual, "bb");
    }

    @Test
    public void testLongestPalindrome_2020() {
        String ops = "20200202";
        String actual = solution.longestPalindrome(ops);
        Assert.assertEquals(actual, ops);
    }

    @Test
    public void testLongestPalindrome_Fail1() {
        String actual = solution.longestPalindrome("banananas");
        Assert.assertEquals(actual, "ananana");
    }
}
