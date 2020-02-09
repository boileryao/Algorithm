package leetcode;

import dp.LIS;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by boileryao on 2020/2/9.
 * Licensed under WTFPL©2020.
 */
class RussianDollEnvelopes {
    @LeetCode(id = 354, problemName = "russian-doll-envelopes", tag = "[DP]", level = LeetCode.Level.HARD)
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        int maxEnvelopes = 1;
        int[] memo = new int[envelopes.length];

        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));
        Arrays.fill(memo, 1);

        for (int i = 0; i < envelopes.length; i++) {
            int w = envelopes[i][0], d = envelopes[i][1];
            for (int row = 0; row <= i; row++) {
                int w0 = envelopes[row][0], d0 = envelopes[row][1];
                if (w > w0 && d > d0) {
                    memo[i] = Math.max(memo[i], memo[row] + 1);
                    maxEnvelopes = Math.max(maxEnvelopes, memo[i]);
                }
            }
        }
        return maxEnvelopes;
    }

    public int maxEnvelopesNLN(int[][] envelopes) {
        // sort on increasing in first dimension and decreasing in second
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        // extract the second dimension and run LIS
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];
        return LIS.lis(secondDim);
    }
}
