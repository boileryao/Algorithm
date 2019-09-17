package leetcode;

import java.util.ArrayList;
import java.util.List;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 8/24/2019.
 * Licensed under WTFPL©2019.
 */
public class GenerateParentheses {
    private List<String> result = new ArrayList<>();
    private int parenthesis;

    @LeetCode(id = 22, problemName = "generate-parentheses", level = MEDIUM)
    public List<String> generateParenthesis(int n) {
        parenthesis = n;
        backtrack("", 0, 0);
        return result;
    }

    private void backtrack(String prefix, int allOpen, int unpairedOpen) {
        if (allOpen == parenthesis && unpairedOpen == 0) {
            if (prefix.length() > 0) result.add(prefix);
            return;
        }
        if (unpairedOpen > 0) {
            backtrack(prefix + ')', allOpen, unpairedOpen - 1);
        }
        if (allOpen < parenthesis) {
            backtrack(prefix + '(', allOpen + 1, unpairedOpen + 1);
        }
    }
}
