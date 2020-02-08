package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/2/8.
 * Licensed under WTFPL©2020.
 */
public class SquaresTest {
    Squares squares = new Squares();

    @Test
    public void testCountSquares_Case1() {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int actual = squares.countSquares(matrix);
        Assert.assertEquals(actual, 15);
    }

    @Test
    public void testCountSquares_Case2() {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0},
        };
        int actual = squares.countSquares(matrix);
        Assert.assertEquals(actual, 7);
    }

    @Test
    public void testCountSquares_Case3() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 1, 0},
                {1, 1, 1},
                {1, 1, 0}
        };
        int actual = squares.countSquares(matrix);
        Assert.assertEquals(actual, 8);
    }

    @Test
    public void testCountSquares_Case4() {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 0}
        };
        int actual = squares.countSquares(matrix);
        Assert.assertEquals(actual, 13);
    }

    @Test
    public void testCountSquares_Case5() {
        int[][] matrix = {
                {1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1}
        };
        int actual = squares.countSquares(matrix);
        Assert.assertEquals(actual, 19);
    }
}
