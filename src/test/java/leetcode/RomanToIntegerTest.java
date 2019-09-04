package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 9/4/2019.
 * Licensed under WTFPL©2019.
 */
public class RomanToIntegerTest {
    RomanToInteger solution = new RomanToInteger();

    @Test
    public void testRomanToInt_III() {
        Assert.assertEquals(solution.romanToInt("III"), 3);
    }

    @Test
    public void testRomanToInt_IV() {
        Assert.assertEquals(solution.romanToInt("IV"), 4);
    }

    @Test
    public void testRomanToInt_IX() {
        Assert.assertEquals(solution.romanToInt("IX"), 9);
    }

    @Test
    public void testRomanToInt_LVIII() {
        Assert.assertEquals(solution.romanToInt("LVIII"), 58);
    }

    @Test
    public void testRomanToInt_MCMXCIV() {
        Assert.assertEquals(solution.romanToInt("MCMXCIV"), 1994);
    }
}
