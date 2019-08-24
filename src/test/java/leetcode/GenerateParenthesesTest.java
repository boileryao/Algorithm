package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by boileryao on 8/24/2019.
 * Licensed under WTFPL©2019.
 */
public class GenerateParenthesesTest {

    @Test
    public void testGenerateParenthesis_0() {
        GenerateParentheses solution = new GenerateParentheses();
        List<String> actual = solution.generateParenthesis(0);
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testGenerateParenthesis_1() {
        GenerateParentheses solution = new GenerateParentheses();
        String[] actual = solution.generateParenthesis(1).toArray(new String[]{});
        String[] expected = new String[]{"()"};
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assert.assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }

    @Test
    public void testGenerateParenthesis_2() {
        GenerateParentheses solution = new GenerateParentheses();
        String[] actual = solution.generateParenthesis(2).toArray(new String[]{});
        String[] expected = new String[]{"()()", "(())"};
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assert.assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }

    @Test
    public void testGenerateParenthesis_3() {
        GenerateParentheses solution = new GenerateParentheses();
        String[] actual = solution.generateParenthesis(3).toArray(new String[]{});
        String[] expected = new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"};
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assert.assertEquals(Arrays.toString(actual), Arrays.toString(expected));
    }
}
