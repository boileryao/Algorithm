package lcof;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2018/9/9.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class _65_FannyAddTest {

    @Test
    public void testAdd_Zero() {
        Assert.assertEquals(_65_FannyAdd.add(0, 1), 1);
    }

    @Test
    public void testAdd_1024s() {
        Assert.assertEquals(_65_FannyAdd.add(1024, 1024), 2048);
    }

    @Test
    public void testAdd_Ones() {
        Assert.assertEquals(_65_FannyAdd.add(1, 1), 2);
    }

    @Test
    public void testAdd_OneThree() {
        Assert.assertEquals(_65_FannyAdd.add(1, 3), 4);
    }

    @Test
    public void testAdd_OneTwo() {
        Assert.assertEquals(_65_FannyAdd.add(1, 2), 3);
    }

}
