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

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0。
     */
    @LeetCode(id = 58, problemName = "length-of-last-word", level = LeetCode.Level.EASY)
    public int lengthOfLastWord(String s) {
        int lastWordLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (lastWordLen > 0) break;
            } else {
                lastWordLen++;
            }
        }
        return lastWordLen;
    }

    /**
     * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
     */
    @LeetCode(id = 583, problemName = "delete-operation-for-two-strings", level = LeetCode.Level.MEDIUM)
    public int minDistance(String word1, String word2) {
        int lcs = 0;
        int[][] lcsCache = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                int top = (i != 0) ? lcsCache[i - 1][j] : 0;
                int left = (j != 0) ? lcsCache[i][j - 1] : 0;
                int topLeft = (i != 0 && j != 0) ? lcsCache[i - 1][j - 1] : 0;
                lcsCache[i][j] = Math.max(top, left);
                if (word1.charAt(i) == word2.charAt(j)) {
                    lcsCache[i][j] = Math.max(topLeft + 1, lcsCache[i][j]);
                    if (lcsCache[i][j] > lcs) {
                        lcs = lcsCache[i][j];
                    }
                }
            }
        }
        return word1.length() + word2.length() - 2 * lcs;
    }
}
