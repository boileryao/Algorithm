package leetcode;

import kotlin.collections.CollectionsKt;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by boileryao on 8/28/2019.
 * Licensed under WTFPL©2019.
 */
public class BinarySearchesTest {

    BinarySearches solution = new BinarySearches();

    @Test
    public void testSearchRange_Exist() {
        assertEquals(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4});
    }

    @Test
    public void testSearchRange_Absent() {
        assertEquals(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6), new int[]{-1, -1});
    }

    @Test
    public void testSearchRange_OnlyOne_High() {
        assertEquals(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10), new int[]{5, 5});
    }

    @Test
    public void testSearchRange_OnlyOne_Low() {
        assertEquals(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5), new int[]{0, 0});
    }

    @Test
    public void testSearchRange_Fail1() {
        assertEquals(solution.searchRange(new int[]{2, 2}, 2), new int[]{0, 1});
    }

    @Test
    public void testSearchInsert() {
        // Run test 100 times, compared with std lib
        for (int i = 0; i < 100; i++) {
            // Generate ordered array with max size of 10, avg size 5
            List<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                if (Math.random() > 0.5) {
                    arrayList.add(j);
                }
            }
            int target = (int) (10 * Math.random());
            int[] nums = CollectionsKt.toIntArray(arrayList);
            int expect = Arrays.binarySearch(nums, target);
            // std lib returns (-insertPosition - 1) if not found, adjust it here
            if (expect < 0) expect = -1 * expect - 1;
            int actual = solution.searchInsert(nums, target);
            assertEquals(actual, expect, String.format("Finding %d in %s\n", target, Arrays.toString(nums)));
        }
    }
}
