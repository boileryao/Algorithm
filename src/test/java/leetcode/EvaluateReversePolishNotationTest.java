package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/3/27.
 * Licensed under WTFPL©2020.
 */
public class EvaluateReversePolishNotationTest {
    private EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

    @Test
    public void testEvalRPN_PM() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Assert.assertEquals(solution.evalRPN(tokens), 9);
    }

    @Test
    public void testEvalRPN_DP() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        Assert.assertEquals(solution.evalRPN(tokens), 6);
    }

    @Test
    public void testEvalRPN_PMD() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Assert.assertEquals(solution.evalRPN(tokens), 22);
    }

}
