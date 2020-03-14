package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boileryao on 2020/3/14.
 * Licensed under WTFPL©2020.
 */
public class LongestIncreasingSubsequenceTest {

    @Test
    public void testLengthOfLIS() {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        Map<int[], Integer> testCases = new HashMap<>();
        testCases.put(new int[]{1, 46, 78, 8}, 3);
        testCases.put(new int[]{1, 2, 3, 2, 5, 4, 5}, 5);
        testCases.put(new int[]{6, 4, 8, 2, 17}, 3);
        testCases.put(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4);

        testCases.forEach((nums, expect) -> Assert.assertEquals(solution.lengthOfLIS(nums), expect.intValue()));
    }
}
