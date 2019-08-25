package leetcode;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 8/25/2019.
 * Licensed under WTFPL©2019.
 */
public class ContainerWithMostWater {
    @LeetCode(id = 11, problemName = "container-with-most-water", level = MEDIUM, accepted = true)
    public int maxArea(int[] height) {
        if (height.length < 2) throw new IllegalArgumentException("require at least 2 elements");

        int maxArea = 0;
        int idxLeft = 0;
        int idxRight = height.length - 1;

        while (idxLeft < idxRight) {
            int area = Math.min(height[idxLeft], height[idxRight]) * (idxRight - idxLeft);
            if (area > maxArea) maxArea = area;

            if (height[idxLeft] < height[idxRight]) idxLeft++;
            else idxRight--;
        }

        return maxArea;
    }

    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }
}
