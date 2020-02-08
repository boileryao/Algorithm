package leetcode;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 2020/2/8.
 * Licensed under WTFPL©2020.
 */
public class Squares {
    /**
     * 给定一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
     */
    @LeetCode(id = 1277, problemName = "count-square-submatrices-with-all-ones", level = MEDIUM)
    public int countSquares(int[][] matrix) {
        int squares = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    squares++;
                    offset:
                    for (int offset = 1; offset < matrix.length - row; offset++) {
                        for (int i = 0; i <= offset && col + offset < matrix[row].length; i++) {
                            if (matrix[row + offset][col + i] == 0 || matrix[row + i][col + offset] == 0) break offset;
                            if (i == offset) {
                                if (matrix[row + offset][col + offset] == 0) break offset;
                                squares++;
                            }
                        }
                    }
                }
            }
        }
        return squares;
    }
}
