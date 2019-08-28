package leetcode;

import org.testng.annotations.Test;

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
}
