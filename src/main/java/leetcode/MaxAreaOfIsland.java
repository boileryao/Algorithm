package leetcode;

/**
 * Created by boileryao on 2020/3/15.
 * Licensed under WTFPL©2020.
 */
public class MaxAreaOfIsland {
    private int area = 0;

    @LeetCode(id = 695, problemName = "max-area-of-island", tag = "[DFS]", level = LeetCode.Level.MEDIUM)
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                area = 0;
                dfs(grid, visit, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, boolean[][] visit, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visit[x][y]) {
            return;
        }
        visit[x][y] = true;
        if (grid[x][y] == 0) {
            return;
        }
        area += 1;
        dfs(grid, visit, x - 1, y);
        dfs(grid, visit, x + 1, y);
        dfs(grid, visit, x, y - 1);
        dfs(grid, visit, x, y + 1);
    }
}
