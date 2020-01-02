package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/1/2.
 * Licensed under WTFPL©2020.
 */
public class ThirdMaximumNumberTest {
    ThirdMaximumNumber sortRocks = new ThirdMaximumNumber();

    @Test
    public void testThirdMaximumNumber() {
        Assert.assertEquals(sortRocks.thirdMax(new int[]{3, 2, 1}), 1, "#1");
        Assert.assertEquals(sortRocks.thirdMax(new int[]{1, 2}), 2, "#2");
        Assert.assertEquals(sortRocks.thirdMax(new int[]{2, 2, 3, 1}), 1, "#3");
    }
}
