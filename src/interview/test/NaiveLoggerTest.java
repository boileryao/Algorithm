package interview.test;

import interview.NaiveLogger;
import org.testng.annotations.*;

import static org.testng.Assert.*;

/**
 * Created by boileryao on 2018/8/29.
 * Licensed under WTFPL©2018.
 * May you have a good life, may you stand on the firm earth.
 * May you a better man and do no evil.
 */
public class NaiveLoggerTest {

    @BeforeMethod
    public void setUp() {
        NaiveLogger.reset();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("===================!!!==========================");
    }

    @Test
    public void testProcessLog_AllSame() {
        for (int i = 0; i < 100; i++) {
            NaiveLogger.processLog("E:\\V1R2\\product\\fpgadrive.c", 1325);
        }
        NaiveLogger.output();
    }

    @Test
    public void testProcessLog_DiffLines() {
        for (int i = 0; i < 10; i++) {
            NaiveLogger.processLog("E:\\V1R2\\product\\fpgadrive.c", i);
        }
        NaiveLogger.output();
    }
}