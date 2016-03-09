package com.muru.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msivagna on 3/8/16.
 */
public class Fibonacci {
    /*
        Key = nth number in the fibonacci series
        Value = Fibonacci value of the nth number
     */
    private Map<Integer, Long> memoizedFibonacciMap;

    public Fibonacci() {
        memoizedFibonacciMap = new HashMap<Integer, Long>();
        memoizedFibonacciMap.put(0, new Long(0));
        memoizedFibonacciMap.put(1, new Long(1));
    }

    /**
     * Solution to calculate fibonacci series using simple recursion
     * @param n
     * @return
     */
    public Long calculateNthFibNumber(Integer n) {
        if (n == 0) {
            return new Long(0);
        }
        if (n == 1) {
            return new Long(1);
        }
        return calculateNthFibNumber(n-1) + calculateNthFibNumber(n-2);
    }

    /**
     * Solution to calculate fibonacci series using memoized recursion
     * @param n
     * @return
     */
    public Long calculateNthFibNumberUsingMemoization(Integer n) {
        if (memoizedFibonacciMap.containsKey(n)) {
            return memoizedFibonacciMap.get(n);
        }
        memoizedFibonacciMap.put(n, calculateNthFibNumberUsingMemoization(n - 1) + calculateNthFibNumberUsingMemoization(n - 2));
        return memoizedFibonacciMap.get(n);
    }
}
