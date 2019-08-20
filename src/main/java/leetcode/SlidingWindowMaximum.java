package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by boileryao on 2018/2/14.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/* Problem #239, https://leetcode.com/problems/sliding-window-maximum */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] maxSlidingWindow = benchMark(new int[]{}, 3);
        System.out.println(Arrays.toString(maxSlidingWindow));
    }

    @LeetCode(id = 239, problemName = "sliding-window-maximum", accepted = true)
    private static int[] maxSlidingWindow(int[] nums, int k) {
        int[] msw = new int[nums.length - k + 1];  // max sliding window

        int max = 0; // first window
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) max = nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();

        if (msw.length > 0) msw[0] = max;

        for (int i = 1; i < msw.length; i++) {
            int a = nums[i - 1];
            int b = nums[i + k - 1];
            int delta = -a + b;
            System.out.format("a:%d b:%d delta:%d\n", a, b, delta);

            max += delta;
            msw[i] = max;
        }


        return msw;
    }

    private static int[] benchMark(final int[] nums, final int k) {
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

    private static int[] slidingWindows(int[] nums, int k) {
        int[] msw = new int[nums.length - k + 1];  // max sliding window

        int fw = 0; // first window
        for (int i = 0; i < k; i++) {
            fw += nums[i];
        }

        if (msw.length > 0) msw[0] = fw;

        for (int i = 1; i < msw.length; i++) {
            int a = nums[i - 1];
            int b = nums[i + k - 1];
            int delta = -a + b;
            System.out.format("a:%d b:%d delta:%d\n", a, b, delta);

            fw += delta;
            msw[i] = fw;
        }


        return msw;
    }
}
