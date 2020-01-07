package leetcode;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boileryao on 2020/1/1.
 * Licensed under WTFPL©2020.
 */
public class ValidParenthesesTest {
    private ValidParentheses solution = new ValidParentheses();
    private Map<String, Integer> testCase = new HashMap<>();

    @BeforeTest
    public void before() {
        testCase.put("(()", 2);
        testCase.put(")()())", 4);
        testCase.put(")()(())", 6);
        testCase.put(")())())", 2);
        testCase.put(")()((((()", 2);
    }

    @Test
    public void testLongestValidParentheses() {
        testCase.forEach(this::testLongestValidParentheses);
    }

    private void testLongestValidParentheses(String s, int expect) {
        int actual = solution.longestValidParentheses(s);
        int actualDp = solution.longestValidParenthesesDp(s);
        Assert.assertEquals(actual, expect, String.format("stack solution, input is %s, ", s));
        Assert.assertEquals(actualDp, expect, String.format("dp solution, input is %s, ", s));
    }

    @Test
    public void testIsValid() {
        Assert.assertTrue(solution.isValid("[]"));
        Assert.assertTrue(solution.isValid("()[]{}"));
        Assert.assertTrue(solution.isValid("{[]}"));
        Assert.assertFalse(solution.isValid("(]"));
        Assert.assertFalse(solution.isValid("([)]"));
    }
}
