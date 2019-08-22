package leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by boileryao on 8/21/2019.
 * Licensed under WTFPL©2019.
 */
public class LongestSubstringWithoutRepeatingCharactersTest {
    LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    public void testLengthOfLongestSubstring_01() {
        assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3);
    }

    @Test
    public void testLengthOfLongestSubstring_02() {
        assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1);
    }

    @Test
    public void testLengthOfLongestSubstring_03() {
        assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3);
    }
}
