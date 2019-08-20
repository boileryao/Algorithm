package leetcode;

/**
 * Created by boileryao on 4/6/2019.
 * Licensed under WTFPL©2019.
 */
public class Utf8Validation {
    @LeetCode(id = 393, problemName = "utf-8-validation", accepted = true)
    public boolean validUtf8(int[] data) {
        int remainingHalves = 0;
        for (int bt : data) {
            if ((bt >> 5) == 0b110) {
                if (remainingHalves != 0) return false;
                remainingHalves = 1;
                continue;
            }

            if ((bt >> 4) == 0b1110) {
                if (remainingHalves != 0) return false;
                remainingHalves = 2;
                continue;
            }

            if ((bt >> 3) == 0b11110) {
                if (remainingHalves != 0) return false;
                remainingHalves = 3;
                continue;
            }

            if ((bt >> 6) == 0b10) {
                if (remainingHalves <= 0) return false;
                remainingHalves--;
                continue;
            }

            if ((bt & 0x80) != 0) return false;
        }
        return remainingHalves == 0;
    }
}
