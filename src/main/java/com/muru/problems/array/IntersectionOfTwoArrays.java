package com.muru.problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by msivagna on 1/25/17.
 */
public class IntersectionOfTwoArrays {
    public Integer[] findIntersection(Integer[] input1, Integer[] input2) {
        Set<Integer> output = new HashSet<Integer>();
        if (input1 == null || input1.length == 0 || input2 == null
                || input2.length == 0) {
            return output.toArray(new Integer[output.size()]);
        }
        Set<Integer> input1Set = new HashSet<Integer>(Arrays.asList(input1));
        for (Integer elem : input2) {
            if (input1Set.contains(elem)) {
                output.add(elem);
            }
        }
        return output.toArray(new Integer[output.size()]);
    }
}
