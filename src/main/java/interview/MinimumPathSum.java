package interview;

import leetcode.LeetCode;

import java.util.Arrays;

public class MinimumPathSum {
    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 每次只能向下或者向右移动一步。
     */
    @LeetCode(id = 64, problemName = "minimum-path-sum", tag = "[DP]", level = LeetCode.Level.MEDIUM)
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[] slash = new int[Math.min(m, n) + 1];
        Arrays.fill(slash, Integer.MAX_VALUE);

        // slash from left edge to right top
        for (int i = 0; i < m; i++) {
            int[] newSlash = Arrays.copyOf(slash, slash.length);
            newSlash[0] = calcNewDist(slash[0], slash[0], grid[i][0]);
            for (int j = 1; j <= Math.min(i, n - 1); j++) {
                int current = grid[i - j][j];
                newSlash[j] = calcNewDist(slash[j - 1], slash[j], current);
            }
            slash = newSlash;
        }
        // slash from bottom to right top
        for (int i = 0; i < n - 1; i++) {
            int[] newSlash = Arrays.copyOf(slash, slash.length);
            for (int j = 0; j < Math.min(n - i - 1, m); j++) {
                int current = grid[m - 1 - j][i + 1 + j];
                newSlash[j] = calcNewDist(slash[j], slash[j + 1], current);
            }
            slash = newSlash;
        }

        return slash[0];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dist = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    dist[j] = dist[j + 1] + grid[i][j];
                } else if (i != m - 1 && j == n - 1) {
                    dist[j] = dist[j] + grid[i][j];
                } else if (i != m - 1 && j != n - 1) {
                    dist[j] = Math.min(dist[j], dist[j + 1]) + grid[i][j];
                } else {
                    dist[j] = grid[i][j];
                }
            }
        }
        return dist[0];
    }

    private int calcNewDist(int pre1, int pre2, int current) {
        int preMin = Math.min(pre1, pre2);
        if (preMin == Integer.MAX_VALUE) preMin = 0;
        return preMin + current;
    }
}
