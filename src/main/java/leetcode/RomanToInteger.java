package leetcode;

/**
 * Created by boileryao on 9/4/2019.
 * Licensed under WTFPL©2019.
 */
public class RomanToInteger {
    private char[] romans = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private int[] digits = new int[]{1000, 500, 100, 50, 10, 5, 1};

    @LeetCode(id = 13, problemName = "roman-to-integer", level = LeetCode.Level.EASY)
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) return 0;

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int idx = indexOf(s.charAt(i));
            int tmp = digits[idx];
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    tmp += digits[idx];
                    i = j;
                    continue;
                }
                int postIdx = indexOf(s.charAt(j));
                if (postIdx < idx) {
                    tmp = digits[postIdx] - tmp;
                    i = j;
                }
                break;
            }
            num += tmp;
        }
        return num;
    }

    private int indexOf(char ch) {
        for (int i = 0; i < romans.length; i++) {
            if (romans[i] == ch) return i;
        }
        throw new IllegalArgumentException("illegal roman digit character");
    }
}
