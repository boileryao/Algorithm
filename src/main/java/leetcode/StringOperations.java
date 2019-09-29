package leetcode;

/**
 * Created by boileryao on 2019/9/29.
 * Licensed under WTFPL©2019.
 */
public class StringOperations {
    @LeetCode(id = 14, problemName = "longest-common-prefix", level = LeetCode.Level.EASY)
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();
        outer:
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) break outer;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
