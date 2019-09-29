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
}
