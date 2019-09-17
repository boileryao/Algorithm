package leetcode;

/**
 * Created by boileryao on 9/7/2019.
 * Licensed under WTFPL©2019.
 */
public class PlusOne {
    @LeetCode(id = 66, problemName = "plus-one", level = LeetCode.Level.EASY)
    public int[] plusOne(int[] digits) {
        boolean allNines = true;
        for (int digit : digits) {
            if (digit != 9) {
                allNines = false;
                break;
            }
        }

        if (allNines) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            int digitSum = digits[i] + 1;
            if (digitSum < 10) {
                digits[i] = digitSum;
                break;
            }
            digits[i] = 0; // 9 + 1 = 10, we keep the zero in 10
        }

        return digits;
    }
}
