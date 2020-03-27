package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 逆波兰表达式求值
 * <p>
 * Created by boileryao on 2020/3/27.
 * Licensed under WTFPL©2020.
 */
public class EvaluateReversePolishNotation {
    private static final String[] OPERATORS = {"+", "-", "*", "/"};

    static {
        Arrays.sort(OPERATORS);
    }

    @LeetCode(id = 150, problemName = "evaluate-reverse-polish-notation", level = LeetCode.Level.MEDIUM)
    public int evalRPN(String[] tokens) {
        Stack<String> tokenStack = new Stack<>();
        for (String token : tokens) {
            boolean isOperator = Arrays.binarySearch(OPERATORS, token) >= 0;
            if (isOperator) {
                int b = Integer.parseInt(tokenStack.pop());
                int a = Integer.parseInt(tokenStack.pop());
                switch (token) {
                    case "+":
                        tokenStack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        tokenStack.push(String.valueOf(a - b));
                        break;
                    case "*":
                        tokenStack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        tokenStack.push(String.valueOf(a / b));
                        break;
                }
            } else {
                tokenStack.push(token);
            }
        }

        return Integer.parseInt(tokenStack.pop());
    }
}
