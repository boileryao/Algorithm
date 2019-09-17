package leetcode;

/**
 * Created by boileryao on 8/30/2019.
 * Licensed under WTFPL©2019.
 */
public class JumpGame {
    @LeetCode(id = 55, problemName = "jump-game", level = LeetCode.Level.MEDIUM)
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) return false;
            if (nums[i] > nums[i + 1]) {
                nums[i + 1] = nums[i] - 1;
            }
        }
        return nums[nums.length - 2] >= 1;
    }
}
