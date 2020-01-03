package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by boileryao on 2020/1/3.
 * Licensed under WTFPL©2020.
 */
public class PermutationInStringTest {

    @Test
    public void testCheckInclusion() {
        String target = "ab";
        Map<String, Boolean> sourceResults = new HashMap<>();
        sourceResults.put("eidbaooo", true);
        sourceResults.put("eidboaoo", false);

        PermutationInString permutationInString = new PermutationInString();
        sourceResults.forEach((source, expect) -> {
            boolean actual = permutationInString.checkInclusion(target, source);
            Assert.assertEquals(actual, expect.booleanValue());
        });
    }
}
