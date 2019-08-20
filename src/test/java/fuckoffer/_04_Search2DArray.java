package fuckoffer;

/**
 * Created by boileryao on 2018/8/26.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class _04_Search2DArray {
    /**
     * @param arr, require RECT
     * @param num, the number to check if contains
     * @return true if arr contains num
     */
    public boolean contains(int[][] arr, int num) {
        int lrow = 0, lcol = 0;
        int hrow = arr.length, hcol = arr.length;
        int row = 0, col = 0;
        return arr[row][col] == num;
    }
}
