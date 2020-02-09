package dp;

import org.testng.Assert;

import java.util.Arrays;

/**
 * Created by boileryao on 2018/3/2.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class LIS {
    public static void main(String[] args) {
        Assert.assertEquals(lis(new int[]{1, 2, 3, 2, 5, 4, 5}), 5);  // 5
        Assert.assertEquals(lis(new int[]{89, 256, 78, 1, 46, 78, 8}), 3);  // 3
        Assert.assertEquals(lis(new int[]{6, 4, 8, 2, 17}), 3);  // 3
    }

    public static int lis(int[] arr) {
        int[] dp = new int[arr.length];
        int len = 0;
        for (int num : arr) {
            int pos = Arrays.binarySearch(dp, 0, len, num);
            if (pos < 0) pos = -(pos + 1);
            dp[pos] = num;
            if (pos == len) len++;
        }
        return len;
    }
}
