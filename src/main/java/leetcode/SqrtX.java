package leetcode;

/**
 * Created by boileryao on 4/6/2019.
 * Licensed under WTFPL©2019.
 */
public class SqrtX {
    @LeetCode(id = 69, problemName = "sqrtx", accepted = true)
    public int mySqrt(int x) {
        int low = 0;
        int high = Math.min(x, 46340);
        int root = (low + high) >> 1;

        while (true) {
            int rr = root * root;
            long rrp = (root + 1L) * (root + 1L);
            if (rr == x || rr < x && rrp > x) return root;

            if (rr > x) {
                high = root - 1;
            } else {
                low = root + 1;
            }
            root = (high + low) >> 1;
        }
    }
}
