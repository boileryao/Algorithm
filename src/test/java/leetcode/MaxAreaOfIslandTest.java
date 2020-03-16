package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/3/15.
 * Licensed under WTFPL©2020.
 */
public class MaxAreaOfIslandTest {
    private MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

    @Test
    public void testMaxAreaOfIsland() {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        Assert.assertEquals(maxAreaOfIsland.maxAreaOfIsland(grid), 6);
    }

    @Test
    public void testMaxAreaOfIsland_Fail1() {
        int[][] grid = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        Assert.assertEquals(maxAreaOfIsland.maxAreaOfIsland(grid), 4);
    }
}
