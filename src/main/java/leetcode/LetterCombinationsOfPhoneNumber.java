package leetcode;

import java.util.*;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 8/23/2019.
 * Licensed under WTFPL©2019.
 */
public class LetterCombinationsOfPhoneNumber {
    private Map<Character, String> phoneKeys = new HashMap<>();
    private List<String> result;

    {
        phoneKeys.put('2', "abc");
        phoneKeys.put('3', "def");
        phoneKeys.put('4', "ghi");
        phoneKeys.put('5', "jkl");
        phoneKeys.put('6', "mno");
        phoneKeys.put('7', "pqrs");
        phoneKeys.put('8', "tuv");
        phoneKeys.put('9', "wxyz");
    }

    @LeetCode(id = 17, problemName = "letter-combinations-of-a-phone-number", level = MEDIUM, accepted = true)
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        result = new ArrayList<>(calcResultListSize(digits));
        backtrack("", digits);
        return result;
    }

    private void backtrack(String combination, String remainingDigits) {
        // if there is no more digits to check
        if (remainingDigits.length() == 0) {
            result.add(combination);
            return;
        }
        // there are still digits to check
        char digit = remainingDigits.charAt(0);
        String letters = phoneKeys.get(digit);
        for (char letter : letters.toCharArray()) {
            backtrack(combination + letter, remainingDigits.substring(1));
        }
    }

    private int calcResultListSize(String digits) {
        int fours = 0;
        for (char c : digits.toCharArray()) {
            if (c == '7' || c == '9') fours++;
        }
        return (int) Math.round(Math.pow(4, fours) + Math.pow(3, digits.length() - fours));
    }
}
