package leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by boileryao on 8/29/2019.
 * Licensed under WTFPL©2019.
 */
public class MergeIntervalsTest {
    MergeIntervals solution = new MergeIntervals();

    @Test
    public void testMerge_Case1() {
        int[][] actual = solution.merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18},
        });
        String str = Arrays.deepToString(actual);
        assertEquals(actual.length, 3);
        assertTrue(str.contains(Arrays.toString(new int[]{1, 6})));
        assertTrue(str.contains(Arrays.toString(new int[]{8, 10})));
        assertTrue(str.contains(Arrays.toString(new int[]{15, 18})));
    }

    @Test
    public void testMerge_Case2() {
        int[][] actual = solution.merge(new int[][]{
                new int[]{1, 4},
                new int[]{4, 5},
        });
        assertEquals(actual.length, 1);
        assertEquals(actual[0], new int[]{1, 5});
    }
}
