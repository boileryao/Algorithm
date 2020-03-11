package leetcode;

/**
 * Created by boileryao on 2020/3/11.
 * Licensed under WTFPL©2020.
 */
public class DrunkArrays {
    /**
     * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。*
     * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] +
     * A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
     */
    @LeetCode(id = 1013, problemName = "partition-array-into-three-parts-with-equal-sum", level = LeetCode.Level.EASY)
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) sum += num;

        if (sum % 3 != 0) return false;

        int partTargetSum = sum / 3;
        int partSum = 0;
        int matchedPartCount = 0;
        for (int num : A) {
            partSum += num;
            if (partSum == partTargetSum) {
                matchedPartCount++;
                partSum = 0;
            }
        }

        return matchedPartCount == 3 || sum == 0 && matchedPartCount > 3;
    }
}
