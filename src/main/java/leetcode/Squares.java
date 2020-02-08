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

    /**
     * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
     * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
     */
    @LeetCode(id = 593, problemName = "valid-square", tag = "[Math]", level = MEDIUM)
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] others = {p2, p3, p4};
        for (int i = 0; i < 3; i++) {
            p2 = others[i];
            int otherIdx = (3 - i - 1) >> 1;
            p3 = others[otherIdx];
            p4 = others[3 - i - otherIdx];

            if (isVerticalLine(p1, p2, p3, p4)) {  // 对边垂直
                // 两边垂直
                return isVerticalLine(p1, p3, p1, p4);
            }
        }
        return false;
    }

    // `p1-p2`和`p3-p4` 两条线是否严格垂直(任一条线长度为0认为不垂直)
    private boolean isVerticalLine(int[] p1, int[] p2, int[] p3, int[] p4) {
        int x1 = p1[0] - p2[0];
        int x2 = p3[0] - p4[0];
        int y1 = p1[1] - p2[1];
        int y2 = p3[1] - p4[1];
        return (x1 | y1) != 0 && (x2 | y2) != 0 && x1 * x2 + y1 * y2 == 0;
    }
}
