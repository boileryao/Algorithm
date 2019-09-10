package leetcode;

import static leetcode.LeetCode.Level.EASY;

/**
 * Created by boileryao on 8/31/2019.
 * Licensed under WTFPL©2019.
 */
public class ArrayOperations {
    @LeetCode(id = 26, problemName = "remove-duplicates-from-sorted-array", level = EASY, accepted = true)
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (curNum == nums[j]) i++;
                else break;
            }
            nums[uniqueCount] = curNum;
            uniqueCount++;
        }
        return uniqueCount;
    }

    @LeetCode(id = 27, problemName = "remove-element", level = EASY, accepted = true)
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
