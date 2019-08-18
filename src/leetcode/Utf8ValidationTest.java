package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 4/6/2019.
 * Licensed under WTFPL©2019.
 */
public class Utf8ValidationTest {
    Utf8Validation utf8Validation = new Utf8Validation();

    @Test
    public void testValidUtf8_bad() {
        Assert.assertFalse(utf8Validation.validUtf8(new int[]{0b11101011, 0b10001100, 0b00000100}));
    }

    @Test
    public void testValidUtf8_good() {
        Assert.assertTrue(utf8Validation.validUtf8(new int[]{0b11000101, 0b10000010, 0b00000001}));
    }

    @Test
    public void testValidUtf8_255() {
        Assert.assertFalse(utf8Validation.validUtf8(new int[]{0xFF}));
    }
}