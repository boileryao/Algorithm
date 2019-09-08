package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by boileryao on 9/6/2019.
 * Licensed under WTFPL©2019.
 */
public class SpiralMatrixTest {
    SpiralMatrix solution = new SpiralMatrix();

    @Test
    public void testSpiralOrder_SquareOdd() {
        List<Integer> actual = solution.spiralOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        });
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void testSpiralOrder_Rect() {
        List<Integer> actual = solution.spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
        });
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
        Assert.assertEquals(actual, expect);
    }

    @Test
    public void testGenerateMatrix_3() {
        int[][] actual = solution.generateMatrix(3);
        int[][] expect = new int[][]{
                new int[]{1, 2, 3},
                new int[]{8, 9, 4},
                new int[]{7, 6, 5},
        };
        Assert.assertEquals(Arrays.deepToString(actual), Arrays.deepToString(expect));
    }
}
