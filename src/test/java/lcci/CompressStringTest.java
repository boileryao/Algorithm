package lcci;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/3/16.
 * Licensed under WTFPL©2020.
 */
public class CompressStringTest {
    private CompressString solution = new CompressString();

    @Test
    public void testCompressString() {
        Assert.assertEquals(solution.compressString("aabcccccaaa"), "a2b1c5a3");
        Assert.assertEquals(solution.compressString("abbccd"), "abbccd");
    }
}
