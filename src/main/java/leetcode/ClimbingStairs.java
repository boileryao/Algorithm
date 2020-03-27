package leetcode;

/**
 * Created by boileryao on 2020/3/27.
 * Licensed under WTFPL©2020.
 */
@SuppressWarnings("unused")
public class ClimbingStairs {
    /**
     * @param n, positive, 楼的层数
     * @return 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    @LeetCode(id = 70, problemName = "climbing-stairs", level = LeetCode.Level.EASY)
    public int climbStairs(int n) {
        int pre = 1;
        int pre2 = 0;

        for (int i = 0; i < n; i++) {
            int tmp = pre;
            pre = pre + pre2;
            pre2 = tmp;
        }

        return pre;
    }
}

