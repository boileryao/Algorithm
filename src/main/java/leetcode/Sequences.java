package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Sequences {
    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 要求算法的时间复杂度为 O(n)。
     */
    @LeetCode(id = 128, problemName = "longest-consecutive-sequence", tag = "[Hash]", level = LeetCode.Level.HARD)
    public int longestConsecutive(int[] nums) {
        int longestConsecutive = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        for (int num : nums) {
            if (numSet.contains(num - 1)) continue;
            int currentNum = num;
            int currentConsecutive = 1;
            while (numSet.contains(currentNum + 1)) {
                currentNum++;
                currentConsecutive++;
            }
            if (currentConsecutive > longestConsecutive) longestConsecutive = currentConsecutive;
        }

        return longestConsecutive;
    }
}
