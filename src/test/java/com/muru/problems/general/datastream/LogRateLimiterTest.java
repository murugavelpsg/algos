package com.muru.problems.general.datastream;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 12/20/16.
 */
public class LogRateLimiterTest {
    @Test
    public void mustReturnTrueWhenMessagesAreNotRepeated() {
        long currentTime = System.currentTimeMillis();
        LogRateLimiter logRateLimiter = new LogRateLimiter();
        assertTrue(logRateLimiter.shouldPrintMessage("hello", currentTime));
        assertTrue(logRateLimiter.shouldPrintMessage("world!", System.currentTimeMillis()));
        assertTrue(logRateLimiter.shouldPrintMessage("hi there!", System.currentTimeMillis()));
    }

    @Test
    public void mustReturnFalseWhenMessagesAreRepeatedIn10Seconds() {
        long initialTime = System.currentTimeMillis() - 50000L;
        LogRateLimiter logRateLimiter = new LogRateLimiter();
        assertTrue(logRateLimiter.shouldPrintMessage("hello", initialTime));
        assertFalse(logRateLimiter.shouldPrintMessage("hello", initialTime + 5000L));
        assertTrue(logRateLimiter.shouldPrintMessage("hello", initialTime + 11000L));
    }
}