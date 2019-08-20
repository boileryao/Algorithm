package leetcode;

/**
 * Created by boileryao on 2018/2/10.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */

/* Problem #495, https://leetcode.com/problems/teemo-attacking */
public class TeemoAttacking {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));  // 3
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));  // 4
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 3));  // 6
        System.out.println(findPoisonedDuration(new int[]{1, 4, 5, 6, 7, 9, 10}, 2));  // 10
    }

    private static int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonTime = 0;

        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        // calc poison in timeSeries[0]..timeSeries[-1]
        for (int i = 1; i < timeSeries.length; i++) {
            int formerAttackTime = timeSeries[i - 1];
            int attackTime = timeSeries[i];
            int gap = attackTime - formerAttackTime;
            poisonTime += (gap >= duration ? duration : gap);
        }

        return poisonTime + duration;  // calc last poison
    }
}
