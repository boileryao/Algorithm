package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2019/12/30.
 * Licensed under WTFPL©2019.
 */
public class UniquePathsTest {
    UniquePaths uniquePaths = new UniquePaths();

    @Test
    public void testUniquePaths_Case1() {
        int actual = uniquePaths.uniquePaths(3, 2);
        Assert.assertEquals(actual, 3);
    }

    @Test
    public void testUniquePaths_Case2() {
        int actual = uniquePaths.uniquePaths(7, 3);
        Assert.assertEquals(actual, 28);
    }

    @Test
    public void testUniquePaths_AtomicCorner() {
        int actual = uniquePaths.uniquePaths(1, 1);
        Assert.assertEquals(actual, 1);
    }

    @Test
    public void testUniquePathsWithObstacles() {
        int[][] obstacles = {
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        };
        int actual = uniquePaths.uniquePathsWithObstacles(obstacles);
        Assert.assertEquals(actual, 2);
    }

    @Test
    public void testUniquePathsWithObstacles_Fail1() {
        int[][] obstacles = {{1, 0}};
        int actual = uniquePaths.uniquePathsWithObstacles(obstacles);
        Assert.assertEquals(actual, 0);
    }

    @Test
    public void testUniquePathsWithObstacles_AtomicCorner() {
        int[][] obstacles = {{0}};
        int actual = uniquePaths.uniquePathsWithObstacles(obstacles);
        Assert.assertEquals(actual, 1);
    }
}
