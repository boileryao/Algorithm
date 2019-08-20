package interview;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boileryao on 2018/8/28.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class PasswordCheckerTest {

    @Test
    public void testIsValidPassword_Valid1() {
        Assert.assertTrue(PasswordChecker.isValidPassword("021Abc9000"));
    }

    @Test
    public void testIsValidPassword_Valid2() {
        Assert.assertTrue(PasswordChecker.isValidPassword("021$bc9000"));
    }

    @Test
    public void testIsValidPassword_Invalid1() {
        Assert.assertFalse(PasswordChecker.isValidPassword("021Abc9Abc1"));
    }

    @Test
    public void testIsValidPassword_Invalid2() {
        Assert.assertFalse(PasswordChecker.isValidPassword("021ABC9000"));
    }
}