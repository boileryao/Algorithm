package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 8/29/2019.
 * Licensed under WTFPL©2019.
 */
public class MergeIntervals {
    @LeetCode(id = 56, problemName = "merge-intervals", level = MEDIUM)
    public int[][] merge(int[][] intervals) {
        Map<Integer, int[]> reflection = new HashMap<>();
        for (int[] interval : intervals) {
            int key = interval[0];
            int[] old = reflection.put(key, interval);
            if (old != null) {
                reflection.get(key)[1] = Math.max(old[1], interval[1]);
            }
        }

        Integer[] keys = reflection.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);

        for (int i = 0; i < keys.length - 1; i++) {
            int[] formerRange = reflection.get(keys[i]);
            int[] laterRange = reflection.get(keys[i + 1]);
            if (formerRange[1] >= laterRange[0]) {
                laterRange[0] = formerRange[0];
                laterRange[1] = Math.max(formerRange[1], laterRange[1]);
                reflection.remove(keys[i]);
            }
        }

        return reflection.values().toArray(new int[][]{});
    }
}
