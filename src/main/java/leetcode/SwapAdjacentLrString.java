package leetcode;

import java.util.Objects;

/**
 * Created by boileryao on 2018/2/6.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class SwapAdjacentLrString {
    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        System.out.println(canTransform(start, end));
    }

    @LeetCode(id = 777, problemName = "swap-adjacent-in-lr-string", level = LeetCode.Level.MEDIUM)
    private static boolean canTransform(String start, String end) {
        if (start.length() != end.length()) throw new IllegalArgumentException("start and end must have same length");

        if (!Objects.equals(start.replace("X", ""), end.replace("X", ""))) {
            return false;
        }

        int fromIndexStart;
        int fromIndexEnd;
        for (char c : new char[]{'L', 'R'}) {
            fromIndexStart = -1;
            fromIndexEnd = -1;
            while ((fromIndexStart = start.indexOf(c, ++fromIndexStart)) != -1) {
                fromIndexEnd = end.indexOf(c, ++fromIndexEnd);
                if (c == 'L' && fromIndexStart < fromIndexEnd) return false;
                if (c == 'R' && fromIndexStart > fromIndexEnd) return false;
            }
        }

        return true;
    }
}
