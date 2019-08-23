package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by boileryao on 8/23/2019.
 * Licensed under WTFPL©2019.
 */
public class LetterCombinationsOfPhoneNumberTest {

    LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();

    @Test
    public void testLetterCombinations() {
        String digits = "23";
        List<String> expect = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> actual = solution.letterCombinations(digits);
        expect.sort(String::compareTo);
        actual.sort(String::compareTo);
        Assert.assertTrue(Arrays.equals(actual.toArray(), expect.toArray()));
    }

    @Test
    public void testLetterCombinations_empty() {
        String digits = "";
        List<String> actual = solution.letterCombinations(digits);
        Assert.assertEquals(actual.size(), 0);
    }
}
