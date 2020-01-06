package leetcode;

/**
 * Created by boileryao on 2020/1/6.
 * Licensed under WTFPL©2020.
 */
public class TrappingRainWater {
    @LeetCode(id = 43, problemName = "trapping-rain-water", level = LeetCode.Level.HARD)
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int maxVolume = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    maxVolume += (leftMax - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    maxVolume += (rightMax - height[right]);
                }
                --right;
            }
        }
        return maxVolume;
    }

    public int trapSquare(int[] height) {
        int maxVolume = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = height[i];
            int rightMax = height[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            maxVolume += Math.min(leftMax, rightMax) - height[i];
        }
        return maxVolume;
    }
}
