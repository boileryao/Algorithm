package leetcode;

import java.util.Arrays;

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

    @LeetCode(id = 1160, problemName = "find-words-that-can-be-formed-by-characters", level = LeetCode.Level.EASY)
    public int countCharacters(String[] words, String chars) {
        char[] charArray = chars.toCharArray();
        Arrays.sort(charArray);

        int knowledge = 0;
        for (String word : words) {
            if (word.length() > charArray.length) continue;
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            int legoIdx = 0;
            int wordIdx;
            out:
            for (wordIdx = 0; wordIdx < word.length(); wordIdx++) {
                if (legoIdx >= charArray.length) {
                    break;
                }
                while (wordArray[wordIdx] != charArray[legoIdx]) {
                    legoIdx++;
                    if (legoIdx >= charArray.length) {
                        break out;
                    }
                }
                legoIdx++;
            }
            if (wordIdx == word.length()) {
                knowledge += word.length();
            }
        }

        return knowledge;
    }

    @LeetCode(id = 409, problemName = "longest-palindrome", level = LeetCode.Level.EASY)
    public int longestPalindrome(String s) {
        int[] charCounts = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - (Character.isLowerCase(ch) ? 'a' : 'A' - 26);
            charCounts[idx]++;
        }

        int evenCountSum = 0;
        boolean hasOddCount = false;
        for (int count : charCounts) {
            evenCountSum += count & 0xFFFFFFFE;
            if (count % 2 != 0) hasOddCount = true;
        }

        return evenCountSum + (hasOddCount ? 1 : 0);
    }

    private String remaining(String a, String b) {
        String remaining = a.replaceFirst(String.format("(%s)+", b), "");
        if (b.startsWith(remaining)) {
            return remaining;
        }
        return null;
    }
}
