package leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by boileryao on 2020/3/13.
 * Licensed under WTFPL©2020.
 */
public class DrunkStringsTest {
    private DrunkStrings drunkStrings = new DrunkStrings();

    @Test
    public void testGcdOfStrings_Case1() {
        assertEquals(drunkStrings.gcdOfStrings("ABABAB", "ABAB"), "AB");
    }

    @Test
    public void testGcdOfStrings_Case2() {
        assertEquals(drunkStrings.gcdOfStrings("ABCABC", "ABC"), "ABC");
    }

    @Test
    public void testGcdOfStrings_Case3() {
        assertEquals(drunkStrings.gcdOfStrings("LEET", "CODE"), "");
    }
}
