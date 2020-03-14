package leetcode;

/**
 * Created by boileryao on 2020/3/14.
 * Licensed under WTFPL©2020.
 *
 * @see dp.LIS, a O(N*lgN) solution
 */
public class LongestIncreasingSubsequence {
    @LeetCode(id = 300, problemName = "longest-increasing-subsequence", tag = "[DP]", level = LeetCode.Level.MEDIUM)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] lens = new int[nums.length];
        int maxLis = 1;
        for (int i = 0; i < nums.length; i++) {
            lens[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lens[j] >= lens[i]) {
                    lens[i] = lens[j] + 1;
                    maxLis = Math.max(maxLis, lens[i]);
                }
            }
        }
        return maxLis;
    }
}
