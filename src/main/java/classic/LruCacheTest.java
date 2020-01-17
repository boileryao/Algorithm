package classic;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by boileryao on 4/24/2019.
 * Licensed under WTFPL©2019.
 */
public class LruCacheTest {

    LruCache<Integer, Integer> lruCache = new LruCache<>(3);

    @Test
    public void testAdd() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testRemove() {
    }

    // 7 0 1 2 0 3 0 4
    // / / 1 2 0 3 0 4
    // / 0 0 1 2 0 3 0
    // 7 7 7 0 1 2 2 3
    @Test
    public void integrateTest() {
        lruCache.add(7, 7);
        lruCache.add(0, 0);
        lruCache.add(1, 1);
        lruCache.add(2, 2);
        Assert.assertNull(lruCache.get(7));
        Assert.assertEquals(lruCache.get(0), Integer.valueOf(0));
        Assert.assertEquals(lruCache.get(1), Integer.valueOf(1));
        Assert.assertEquals(lruCache.get(2), Integer.valueOf(2));
        lruCache.add(0, 0);
        lruCache.add(3, 3);
        lruCache.add(0, 0);
        lruCache.add(4, 4);
        Assert.assertNull(lruCache.get(7));
        Assert.assertEquals(lruCache.get(0), Integer.valueOf(0));
        Assert.assertNull(lruCache.get(1));
        Assert.assertNull(lruCache.get(2));
        Assert.assertEquals(lruCache.get(3), Integer.valueOf(3));
        Assert.assertEquals(lruCache.get(4), Integer.valueOf(4));
    }
}