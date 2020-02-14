package leetcode;

public class Sudoku {
    private static final char EMPTY = '.';

    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 1. 数字 1-9 在每一行只能出现一次。
     * 2. 数字 1-9 在每一列只能出现一次。
     * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     */
    @LeetCode(id = 36, problemName = "valid-sudoku", level = LeetCode.Level.MEDIUM)
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }

        int[] rowFlags = new int[9];
        int[] colFlags = new int[9];
        int[] boxFlags = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current == EMPTY) continue;
                int number = current - '0';
                int boxIndex = i / 3 * 3 + j / 3;
                if (checkDuplicateWithDigit(rowFlags, i, number)) return false;
                if (checkDuplicateWithDigit(colFlags, j, number)) return false;
                if (checkDuplicateWithDigit(boxFlags, boxIndex, number)) return false;
            }
        }

        return true;
    }

    private boolean checkDuplicateWithDigit(int[] flags, int flagIndex, int number) {
        if ((flags[flagIndex] & (1 << number)) != 0) {
            return true;
        }
        flags[flagIndex] |= 1 << number;
        return false;
    }
}
