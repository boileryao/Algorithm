package leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by boileryao on 4/6/2019.
 * Licensed under WTFPL©2019.
 */
public class SqrtXTest {
    SqrtX sqrtX = new SqrtX();

    @Test
    public void testMySqrt_1() {
        assertEquals(sqrtX.mySqrt(1), 1);
    }

    @Test
    public void testMySqrt_2() {
        assertEquals(sqrtX.mySqrt(2), 1);
    }

    @Test
    public void testMySqrt_3() {
        assertEquals(sqrtX.mySqrt(3), 1);
    }

    @Test
    public void testMySqrt_4() {
        assertEquals(sqrtX.mySqrt(4), 2);
    }

    @Test
    public void testMySqrt_8() {
        assertEquals(sqrtX.mySqrt(8), 2);
    }

    @Test
    public void testMySqrt_10000() {
        assertEquals(sqrtX.mySqrt(10000), 100);
    }

    @Test
    public void testMySqrt_big1() {
        assertEquals(sqrtX.mySqrt(2147395599), 46339);
    }

    @Test
    public void testMySqrt_max() {
        assertEquals(sqrtX.mySqrt(Integer.MAX_VALUE), 46340);
    }
}