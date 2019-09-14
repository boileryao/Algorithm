package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boileryao on 9/14/2019.
 * Licensed under WTFPL©2019.
 */
public class WordSearch {
    private static final int MASK_UP = 0b0001;
    private static final int MASK_DOWN = 0b0010;
    private static final int MASK_LEFT = 0b0100;
    private static final int MASK_RIGHT = 0b1000;

    @LeetCode(id = 79, problemName = "word-search", level = LeetCode.Level.MEDIUM, accepted = true)
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.isEmpty()) {
            return true;
        }

        List<Position> walkHistory = new ArrayList<>(word.length());
        List<Integer> unreachableFlags = new ArrayList<>(word.length());

        Position lastHeadingPosition = null;
        while ((lastHeadingPosition = findNext(board, word.charAt(0), lastHeadingPosition)) != null) {
            walkHistory.clear();
            unreachableFlags.clear();
            for (int i = 0; i < word.length(); i++) {
                unreachableFlags.add(0);
            }
            walkHistory.add(lastHeadingPosition);
            for (int i = 1; i < word.length(); i++) {
                Position last = walkHistory.get(walkHistory.size() - 1);
                int flag = unreachableFlags.get(i);
                char ch = word.charAt(i);

                // Walk Down
                if ((flag & MASK_DOWN) == 0) {
                    if (last.row + 1 >= board.length || board[last.row + 1][last.col] != ch || walkHistory.contains(new Position(last.row + 1, last.col))) {
                        flag |= MASK_DOWN;
                    } else {
                        walkHistory.add(new Position(last.row + 1, last.col));
                        continue;
                    }
                }

                // Walk Up
                if ((flag & MASK_UP) == 0) {
                    if (last.row - 1 < 0 || board[last.row - 1][last.col] != ch || walkHistory.contains(new Position(last.row - 1, last.col))) {
                        flag |= MASK_UP;
                    } else {
                        walkHistory.add(new Position(last.row - 1, last.col));
                        continue;
                    }
                }

                // Walk Right
                if ((flag & MASK_RIGHT) == 0) {
                    if (last.col + 1 >= board[0].length || board[last.row][last.col + 1] != ch || walkHistory.contains(new Position(last.row, last.col + 1))) {
                        flag |= MASK_RIGHT;
                    } else {
                        walkHistory.add(new Position(last.row, last.col + 1));
                        continue;
                    }
                }

                // Walk Left
                if ((flag & MASK_LEFT) == 0) {
                    if (last.col - 1 < 0 || board[last.row][last.col - 1] != ch || walkHistory.contains(new Position(last.row, last.col - 1))) {
                        flag |= MASK_LEFT;
                    } else {
                        walkHistory.add(new Position(last.row, last.col - 1));
                        continue;
                    }
                }

                unreachableFlags.set(i, flag);

                if (flag == 0b1111) {  // no match, do backtrack
                    if (walkHistory.size() <= 1) {
                        break; // fail on this start point
                    } else {
                        Position from = walkHistory.get(walkHistory.size() - 2);
                        unreachableFlags.set(i - 1, unreachableFlags.get(i - 1) | positionOf(from, last));
                        walkHistory.remove(last);
                        unreachableFlags.set(i, 0);
                        i -= 2;
                    }
                }
            }
            if (walkHistory.size() == word.length()) {
                return true;
            }
        }
        return false;
    }

    private Position findNext(char[][] board, char target, Position pre) {
        if (pre == null) {
            pre = new Position(0, -1);
        }
        if (pre.row >= board.length || pre.col >= board[0].length) {
            return null;
        }
        for (int i = pre.col + 1; i < board[0].length; i++) {
            if (board[pre.row][i] == target) {
                return new Position(pre.row, i);
            }
        }
        for (int i = pre.row + 1; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    private int positionOf(Position from, Position to) {
        if (from.row == to.row) {
            return from.col < to.col ? MASK_RIGHT : MASK_LEFT;
        }
        if (from.col == to.col) {
            return from.row < to.row ? MASK_DOWN : MASK_UP;
        }
        throw new Error();
    }

    private class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (row != position.row) return false;
            return col == position.col;
        }
    }
}
