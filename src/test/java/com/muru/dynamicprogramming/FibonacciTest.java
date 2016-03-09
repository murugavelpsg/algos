package com.muru.dynamicprogramming;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 3/8/16.
 */
public class FibonacciTest {
    private Fibonacci fibonacci = new Fibonacci();

    @Test
    public void mustSuccessfullyGet0thFibonacciNumber() {
        assertEquals(fibonacci.calculateNthFibNumber(0), new Integer(0));
    }

    @Test
    public void mustSuccessfullyGet1stFibonacciNumber() {
        assertEquals(fibonacci.calculateNthFibNumber(1), new Integer(1));
    }

    @Test
    public void mustSuccessfullyGet9thFibonacciNumber() {
        assertEquals(fibonacci.calculateNthFibNumber(9), new Integer(34));
    }

    @Test
    public void mustSuccessfullyGetMemoized0thFibonacciNumber() {
        assertEquals(fibonacci.calculateNthFibNumberUsingMemoization(0), new Integer(0));
    }

    @Test
    public void mustSuccessfullyGetMemoized1stFibonacciNumber() {
        assertEquals(fibonacci.calculateNthFibNumberUsingMemoization(1), new Integer(1));
    }

    @Test
    public void mustSuccessfullyGetMemoized10thFibonacciNumber() {
        assertEquals(fibonacci.calculateNthFibNumberUsingMemoization(10), new Integer(55));
    }
}