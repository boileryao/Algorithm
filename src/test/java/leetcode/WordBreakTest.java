package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by boileryao on 9/10/2019.
 * Licensed under WTFPL©2019.
 */
public class WordBreakTest {
    WordBreak wordBreak = new WordBreak();

    @Test
    public void testWordBreak_Case1() {
        boolean actual = wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"));
        Assert.assertTrue(actual);
    }

    @Test
    public void testWordBreak_Case2() {
        boolean actual = wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        Assert.assertTrue(actual);
    }

    @Test
    public void testWordBreak_Case3() {
        boolean actual = wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        Assert.assertFalse(actual);
    }

    @Test
    public void testWordBreak_Fail1() {
        boolean actual = wordBreak.wordBreak("a", Collections.emptyList());
        Assert.assertFalse(actual);
    }
}
