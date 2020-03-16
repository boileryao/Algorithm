package lcof;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

/**
 * Created by boileryao on 2018/9/4.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class _56_TwoNumbersAppearsOnceOnlyTest {

    @Test
    public void testFindTheTwoSingleNumbers_Normal() {
        int[] normalArray = {2, 4, 3, 6, 3, 2, 5, 5};
        Pair<Integer, Integer> actual = _56_TwoNumbersAppearsOnceOnly.findTheTwoSingleNumbers(normalArray);
        Assert.assertNotNull(actual);
        Assert.assertEquals(Math.min(actual.first(), actual.second()), 4);
        Assert.assertEquals(Math.max(actual.first(), actual.second()), 6);
    }

    @Test
    public void testFindTheTwoSingleNumbers_SinglesOnly() {
        int[] normalArray = {2, 4};
        Pair<Integer, Integer> actual = _56_TwoNumbersAppearsOnceOnly.findTheTwoSingleNumbers(normalArray);
        Assert.assertNotNull(actual);
        Assert.assertEquals(Math.min(actual.first(), actual.second()), 2);
        Assert.assertEquals(Math.max(actual.first(), actual.second()), 4);
    }


}
