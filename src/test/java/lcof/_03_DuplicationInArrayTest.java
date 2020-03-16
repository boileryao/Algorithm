package lcof;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2018/8/26.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class _03_DuplicationInArrayTest {

    @Test
    public void testDuplicate() {
        _03_DuplicationInArray duplicationInArray = new _03_DuplicationInArray();

        Assert.assertTrue(duplicationInArray.duplicate(new int[]{1, 3, 2, 1}, 3, new int[1]));
        Assert.assertFalse(duplicationInArray.duplicate(new int[]{1, 3, 2, 0}, 3, new int[1]));
        Assert.assertFalse(duplicationInArray.duplicate(null, 0, null));
        Assert.assertFalse(duplicationInArray.duplicate(new int[]{1, 3, 2, 0, 4}, 4, new int[1]));
    }
}
