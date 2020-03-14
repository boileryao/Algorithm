package leetcode;

/**
 * Created by boileryao on 2020/3/12.
 * Licensed under WTFPL©2020.
 */
public class DrunkStrings {
    @LeetCode(id = 1071, problemName = "greatest-common-divisor-of-strings", level = LeetCode.Level.EASY)
    public String gcdOfStrings(String str1, String str2) {
        String remaining = str2;

        do {
            str2 = remaining;
            remaining = remaining(str1, str2);
            str1 = str2;
            if (remaining == null) return "";
            if (remaining.isEmpty()) return str2;
        } while (true);
    }

    private String remaining(String a, String b) {
        String remaining = a.replaceFirst(String.format("(%s)+", b), "");
        if (b.startsWith(remaining)) {
            return remaining;
        }
        return null;
    }
}
