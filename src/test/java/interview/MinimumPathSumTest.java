package interview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MinimumPathSumTest {
    MinimumPathSum minimumPathSum = new MinimumPathSum();

    @Test
    public void testMinPathSum_Square() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        testMinPathSum(grid, 7);
    }


    @Test
    public void testMinPathSum_Row() {
        int[][] grid = {{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}};
        testMinPathSum(grid, 7);
    }

    @Test
    public void testMinPathSum_Row1() {
        int[][] grid = {{1, 1, 1, 1, 1}};
        testMinPathSum(grid, 5);
    }

    @Test
    public void testMinPathSum_Column() {
        int[][] grid = {{1, 2}, {1, 2}, {1, 2}, {1, 2}, {1, 2}};
        testMinPathSum(grid, 7);
    }

    @Test
    public void testMinPathSum_Column1() {
        int[][] grid = {{1}, {1}, {1}, {1}, {1}};
        testMinPathSum(grid, 5);
    }

    private void testMinPathSum(int[][] grid, int expect) {
        int actual1 = minimumPathSum.minPathSum(grid);
        int actual2 = minimumPathSum.minPathSum2(grid);
        Assert.assertEquals(actual1, actual2, "method result diffs,");
        Assert.assertEquals(actual2, expect);
    }
}