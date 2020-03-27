package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * Created by boileryao on 2018/2/14.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class SlidingWindowMaximum {
    @LeetCode(id = 239, problemName = "sliding-window-maximum", tag = "[DP]", level = LeetCode.Level.HARD)
    public int[] benchMark_ON(final int[] nums, final int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return new int[0];
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];

        maxLeft[0] = nums[0];
        maxRight[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            maxLeft[i] = (i % k == 0) ? nums[i] : Math.max(maxLeft[i - 1], nums[i]);
            int j = nums.length - i - 1;
            maxRight[j] = (j % k == 0) ? nums[j] : Math.max(maxRight[j + 1], nums[j]);
        }

        int[] slidingMax = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            slidingMax[i] = Math.max(maxRight[i], maxLeft[i + k - 1]);
        }

        return slidingMax;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] msw = new int[nums.length - k + 1];
        Deque<Integer> maxIdxes = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!maxIdxes.isEmpty() && maxIdxes.getFirst() == (i - k)) {
                maxIdxes.removeFirst();
            }
            while (!maxIdxes.isEmpty() && maxIdxes.getLast() <= nums[i]) {
                maxIdxes.removeLast();
            }
            maxIdxes.add(nums[i]);

            if (i < k) {
                if (nums[i] > msw[0]) msw[0] = nums[i];
            } else {
                msw[i - k + 1] = maxIdxes.getFirst();
            }
        }

        return msw;
    }

    public int[] maxSlidingWindow_ONLGN_TreeMap(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            map.put(nums[i], 1);
        }
        result[0] = map.lastKey();

        for (int i = 1; i < result.length; i++) {
            int slideOut = nums[i - 1];
            int slideOutCount = map.get(slideOut);
            if (slideOutCount == 1) {
                map.remove(slideOut);
            } else {
                map.put(slideOut, slideOutCount - 1);
            }
            int slideIn = nums[k + i - 1];
            map.put(slideIn, map.getOrDefault(slideIn, 0) + 1);
            result[i] = map.lastKey();
        }
        return result;
    }
}
