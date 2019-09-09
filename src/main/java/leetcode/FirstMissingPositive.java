package leetcode;

/**
 * Created by boileryao on 9/9/2019.
 * Licensed under WTFPL©2019.
 */
public class FirstMissingPositive {
    @LeetCode(id = 41, problemName = "first-missing-positive", level = LeetCode.Level.HARD, accepted = true)
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        boolean containsOne = false;
        for (int num : nums) {
            if (num == 1) {
                containsOne = true;
                break;
            }
        }
        if (!containsOne) return 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i + 1;
        }

        return nums.length + 1;
    }
}
