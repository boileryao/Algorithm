package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by boileryao on 8/21/2019.
 * Licensed under WTFPL©2019.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    @LeetCode(id = 3, problemName = "longest-substring-without-repeating-characters/submissions",
            accepted = true, level = LeetCode.Level.MEDIUM)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}
