package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by boileryao on 2019/12/31.
 * Licensed under WTFPL©2019.
 */
public class ValidParentheses {
    private static final char[] LEFT_PARENTHESES = {'('/*40*/, '['/*91*/, '{'/*123*/};
    private static final char[] RIGHT_PARENTHESES = {')'/*41*/, ']'/*93*/, '}'/*125*/};

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     */
    @LeetCode(id = 20, problemName = "valid-parentheses", level = LeetCode.Level.EASY)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int rightIdx = Arrays.binarySearch(RIGHT_PARENTHESES, cur);
            if (rightIdx >= 0) {
                if (stack.isEmpty() || stack.pop() != LEFT_PARENTHESES[rightIdx]) {
                    return false;
                }
            } else {
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }

    @LeetCode(id = 32, problemName = "longest-valid-parentheses", level = LeetCode.Level.HARD)
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] hasMatch = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) continue;
                int leftIdx = stack.pop();
                hasMatch[i] = hasMatch[leftIdx] = 1;
            } else {
                stack.push(i);
            }
        }

        int length = 0;
        int maxLength = 0;
        for (int match : hasMatch) {
            if (match == 0) {
                length = 0;
            } else {
                length++;
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }

    public int longestValidParenthesesDp(String s) {
        int[] dp = new int[s.length()];  // 第i个元素表示以下标为i的字符结尾的最长有效子字符串的长度
        int maxLength = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxLength = Math.max(dp[i], maxLength);
            }
        }

        return maxLength;
    }
}
