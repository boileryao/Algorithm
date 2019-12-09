package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
