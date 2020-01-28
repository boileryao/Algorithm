package leetcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ZigzagConversionTest {
    ZigzagConversion conversion = new ZigzagConversion();
    String origin = "LEETCODEISHIRING";

    @Test
    public void testConvert_TestCaseRow1() {
        String actual = conversion.convert(origin, 1);
        Assert.assertEquals(actual, origin);
    }

    @Test
    public void testConvert_TestCaseRow2() {
        String actual = conversion.convert(origin, 2);
        Assert.assertEquals(actual, "LECDIHRNETOESIIG");
    }

    @Test
    public void testConvert_TestCaseRow3() {
        String actual = conversion.convert(origin, 3);
        Assert.assertEquals(actual, "LCIRETOESIIGEDHN");
    }

    @Test
    public void testConvert_TestCaseRow4() {
        String actual = conversion.convert(origin, 4);
        Assert.assertEquals(actual, "LDREOEIIECIHNTSG");
    }
}