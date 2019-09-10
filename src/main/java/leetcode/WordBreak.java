package leetcode;

import java.util.*;

/**
 * Created by boileryao on 9/5/2019.
 * Licensed under WTFPL©2019.
 */
public class WordBreak {
    @LeetCode(id = 139, problemName = "word-break", level = LeetCode.Level.MEDIUM, accepted = true)
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) {
            return false;
        }

        Map<Integer, Set<String>> iterMap = new HashMap<>();
        Stack<String> walkHistory = new Stack<>();

        int idx = 0;
        while (idx < s.length()) {
            for (String word : wordDict) {
                boolean alreadyTried = iterMap.getOrDefault(idx, Collections.emptySet()).contains(word);
                if (!alreadyTried && s.startsWith(word, idx)) {
                    walkHistory.push(word);
                    idx += word.length();
                    break;
                }

                iterMap.computeIfAbsent(idx, k -> new HashSet<>());
                iterMap.get(idx).add(word);

                if (wordDict.size() == iterMap.get(idx).size()) {
                    if (walkHistory.isEmpty()) {
                        return false;
                    }
                    String lastWord = walkHistory.pop();
                    idx -= lastWord.length();
                    iterMap.computeIfAbsent(idx, k -> new HashSet<>());
                    iterMap.get(idx).add(lastWord);
                }
            }
        }
        return true;
    }
}
