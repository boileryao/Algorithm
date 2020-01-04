package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2020/1/4.
 * Licensed under WTFPL©2020.
 */
public class SortRocksTest {

    SortRocks sortRocks = new SortRocks();

    @Test
    public void testFindKthLargest() {
        Assert.assertEquals(sortRocks.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2), 5, "#1");
        Assert.assertEquals(sortRocks.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), 4, "#2");
    }
}
