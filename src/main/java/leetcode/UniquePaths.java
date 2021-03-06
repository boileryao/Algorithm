package leetcode;

/**
 * Created by boileryao on 2019/12/30.
 * Licensed under WTFPL©2019.
 */
public class UniquePaths {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     * <p>
     * Case: m=3, n=2 ==> 3
     * Case: m=7, n=3 ==> 28
     */
    @LeetCode(id = 62, problemName = "unique-path", level = LeetCode.Level.MEDIUM)
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = (i == 0 || j == 0) ? 1 : cache[i - 1][j] + cache[i][j - 1];
            }
        }
        return cache[m - 1][n - 1];  // ```latex C^{m-1}_{m+n-2} ```
    }

    /**
     * 同上, 但是多了障碍物
     */
    @LeetCode(id = 63, problemName = "unique-paths-ii", level = LeetCode.Level.MEDIUM)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cache[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    cache[i][j] = 1;
                } else if (i == 0) {  // j is positive, i is 0
                    cache[i][j] = cache[i][j - 1];
                } else if (j == 0) {  // i is positive, j is 0
                    cache[i][j] = cache[i - 1][j];
                } else {  // normal cases
                    cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
                }
            }
        }
        return cache[m - 1][n - 1];
    }
}


