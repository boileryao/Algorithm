package leetcode;

import java.util.Arrays;

/**
 * Created by boileryao on 2020/1/3.
 * Licensed under WTFPL©2020.
 */
public class PermutationInString {
    @LeetCode(id = 567, problemName = "permutation-in-string", level = LeetCode.Level.MEDIUM)
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            Arrays.fill(s2map, 0);
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map)) return true;
        }
        return false;
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
