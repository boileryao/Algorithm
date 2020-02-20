package leetcode;

import java.util.*;

import static leetcode.LeetCode.Level.MEDIUM;

/**
 * Created by boileryao on 8/29/2019.
 * Licensed under WTFPL©2019.
 */
public class MergeIntervals {
    @LeetCode(id = 56, problemName = "merge-intervals", level = MEDIUM)
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] lastExpanded = merged.get(merged.size() - 1);
            if (current[0] <= lastExpanded[1]) {
                lastExpanded[1] = Math.max(lastExpanded[1], current[1]);
            } else {
                merged.add(current);
            }
        }
        return merged.toArray(new int[][]{});
    }

    @SuppressWarnings("unused")
    public int[][] merge2(int[][] intervals) {
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
    // [[2,3],[4,5],[6,7],[8,9],[1,10]] ==> [[1, 10]]
    // [[1,4],[5,6]] ==> [[1,4],[5,6]]
    // [[1,4],[2,3]] ==> [[1,4]]
}
