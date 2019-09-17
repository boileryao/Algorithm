package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by boileryao on 9/6/2019.
 * Licensed under WTFPL©2019.
 */
public class SpiralMatrix {
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;
    private static final int EDGES = 4;

    @LeetCode(id = 54, problemName = "spiral-matrix", level = LeetCode.Level.MEDIUM)
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Collections.emptyList();

        int entrySize = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>(entrySize);

        int leftEdge = 0;
        int rightEdge = matrix[0].length - 1;
        int upEdge = 0;
        int bottomEdge = matrix.length - 1;

        int direction = RIGHT;
        int row = 0, col = 0;

        while (result.size() < entrySize) {
            switch (direction) {
                case RIGHT:
                    if (col == rightEdge) {
                        direction = (direction + 1) % EDGES;
                        upEdge++;
                    } else {
                        result.add(matrix[row][col++]);
                    }
                    break;
                case DOWN:
                    if (row == bottomEdge) {
                        rightEdge--;
                        direction = (direction + 1) % EDGES;
                    } else {
                        result.add(matrix[row++][col]);
                    }
                    break;
                case LEFT:
                    if (col == leftEdge) {
                        bottomEdge--;
                        direction = (direction + 1) % EDGES;
                    } else {
                        result.add(matrix[row][col--]);
                    }
                    break;
                case UP:
                    if (row == upEdge) {
                        leftEdge++;
                        direction = (direction + 1) % EDGES;
                    } else {
                        result.add(matrix[row--][col]);
                    }
                    break;
            }
        }

        return result;
    }

    @LeetCode(id = 59, problemName = "spiral-matrix-ii", level = LeetCode.Level.MEDIUM)
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int entryCount = n * n;

        int leftEdge = 0;
        int rightEdge = n - 1;
        int upEdge = 0;
        int bottomEdge = n - 1;

        int direction = RIGHT;
        int row = 0, col = 0;

        int current = 1;
        while (/*entry not filled*/current <= entryCount) {
            switch (direction) {
                case RIGHT:
                    if (col == rightEdge) {
                        direction = (direction + 1) % EDGES;
                        upEdge++;
                        continue;
                    }
                    matrix[row][col++] = current++;
                    break;
                case DOWN:
                    if (row == bottomEdge) {
                        rightEdge--;
                        direction = (direction + 1) % EDGES;
                        continue;
                    }
                    matrix[row++][col] = current++;
                    break;
                case LEFT:
                    if (col == leftEdge) {
                        bottomEdge--;
                        direction = (direction + 1) % EDGES;
                        continue;
                    }
                    matrix[row][col--] = current++;
                    break;
                case UP:
                    if (row == upEdge) {
                        leftEdge++;
                        direction = (direction + 1) % EDGES;
                        continue;
                    }
                    matrix[row--][col] = current++;
                    break;
            }
        }
        return matrix;
    }
}
