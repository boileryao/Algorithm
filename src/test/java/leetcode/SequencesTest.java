package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SequencesTest {
    private Sequences sequences = new Sequences();

    @Test
    public void testLongestConsecutive() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, sequences.longestConsecutive(nums));
    }
}