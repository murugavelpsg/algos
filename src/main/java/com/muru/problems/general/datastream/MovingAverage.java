package com.muru.problems.general.datastream;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * For example,
 * MovingAverage m = new MovingAverage(3);
     m.next(1) = 1
     m.next(10) = (1 + 10) / 2
     m.next(3) = (1 + 10 + 3) / 3
     m.next(5) = (10 + 3 + 5) / 3
 * Created by msivagna on 12/20/16.
 */
public class MovingAverage {
    List<Integer> queue;
    int runningSum;
    int maxWindowSize;

    public MovingAverage(int maxWindowSize) {
        this.queue = new ArrayList<Integer>();
        this.runningSum = 0;
        this.maxWindowSize = maxWindowSize;
    }

    public double next(int element) {
        if (queue.size() >= maxWindowSize) {
            runningSum = runningSum - queue.get(0);
            queue.remove(0);
        }
        runningSum = runningSum + element;
        queue.add(element);
        return runningSum/(queue.size() * 1.0);
    }
}
