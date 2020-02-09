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
        testSquares(matrix, 15, 9);
    }

    @Test
    public void testCountSquares_Case2() {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0},
        };
        testSquares(matrix, 7, 4);
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
        testSquares(matrix, 8, 4);
    }

    @Test
    public void testCountSquares_Case4() {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 0}
        };
        testSquares(matrix, 13, 4);
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
        testSquares(matrix, 19, 4);
    }

    @Test
    public void testValidSquare() {
        Assert.assertTrue(squares.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
    }

    @Test
    public void testValidSquare_Zero() {
        int[] zero = {0, 0};
        Assert.assertFalse(squares.validSquare(zero, zero, zero, zero));
    }

    @Test
    public void testValidSquare_Fail1() {
        Assert.assertTrue(squares.validSquare(
                new int[]{6987, -473}, new int[]{6985, -473},
                new int[]{6986, -472}, new int[]{6986, -474})
        );
    }

    @Test
    public void testValidSquare_Fail2() {
        Assert.assertFalse(squares.validSquare(
                new int[]{0, 1}, new int[]{0, 0},
                new int[]{1, 2}, new int[]{0, 2})
        );
    }

    private void testSquares(int[][] matrix, int countExpect, int maxSquareExpect) {
        Assert.assertEquals(squares.countSquares(matrix), countExpect, "Count squares,");
        char[][] charMatrix = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                charMatrix[i][j] = (char) (matrix[i][j] + '0');
            }
        }
        Assert.assertEquals(squares.maximalSquare(charMatrix), maxSquareExpect, "Maximal squares,");
    }
}
