package com.muru.problems.general.datastream;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 12/20/16.
 */
public class MovingAverageTest {
    @Test
    public void mustGetMovingAverageForOneElement() {
        MovingAverage movingAverage = new MovingAverage(3);
        double expectedAverage = 10.0;
        double actualAverage = movingAverage.next(10);
        assertEquals(actualAverage, expectedAverage);
    }

    @Test
    public void mustGetMovingAverageForTwoElements() {
        MovingAverage movingAverage = new MovingAverage(3);
        double expectedAverage = 8.0;
        double actualAverage = movingAverage.next(10);
        actualAverage = movingAverage.next(6);
        assertEquals(actualAverage, expectedAverage);
    }

    @Test
    public void mustGetMovingAverageForThreeElements() {
        MovingAverage movingAverage = new MovingAverage(3);
        double expectedAverage = 8.0;
        double actualAverage = movingAverage.next(10);
        actualAverage = movingAverage.next(6);
        actualAverage = movingAverage.next(8);
        assertEquals(actualAverage, expectedAverage);
    }

    @Test
    public void mustGetMovingAverageAsTheElementsAreAdded() {
        MovingAverage movingAverage = new MovingAverage(3);
        double expectedAverage = 8.0;
        double actualAverage = movingAverage.next(10);
        actualAverage = movingAverage.next(6);
        actualAverage = movingAverage.next(8);
        assertEquals(actualAverage, expectedAverage);
        actualAverage = movingAverage.next(1);
        actualAverage = movingAverage.next(0);
        expectedAverage = 3.0;
        assertEquals(actualAverage, expectedAverage);
        actualAverage = movingAverage.next(19);
        actualAverage = movingAverage.next(20);
        expectedAverage = 13.0;
        assertEquals(actualAverage, expectedAverage);
    }
}