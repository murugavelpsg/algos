package com.muru.problems.dynamicprogramming;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 3/8/16.
 */
public class MaxSumOfContiguousSequenceTest {
    public MaxSumOfContiguousSequence maxSumOfContiguousSequence = new MaxSumOfContiguousSequence();

    @Test
    public void mustSuccessfullyGetmaxValueWithNegativeAndPositiveNumbers() {
        List<Integer> inputList = Arrays.asList(0, 1, -2, 4, 3, -10, 5);
        MaxSumOfContiguousSequence.MaxSumInfo maxSubsequenceSum =
                maxSumOfContiguousSequence.maximumSumOfContiguousSubsequence(inputList);
        assertEquals(maxSubsequenceSum.getStart(), 3);
        assertEquals(maxSubsequenceSum.getEnd(), 4);
        assertEquals(maxSubsequenceSum.getMaxSum(), 7);
    }

    @Test
    public void mustSuccessfullyGetmaxValueWithOnlyIncreasingPositiveNumbers() {
        List<Integer> inputList = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
        MaxSumOfContiguousSequence.MaxSumInfo maxSubsequenceSum =
                maxSumOfContiguousSequence.maximumSumOfContiguousSubsequence(inputList);
        assertEquals(maxSubsequenceSum.getStart(), 1);
        assertEquals(maxSubsequenceSum.getEnd(), 6);
        assertEquals(maxSubsequenceSum.getMaxSum(), 21);
    }

    @Test
    public void mustSuccessfullyGetmaxValueWithOnlyDecreasingPositiveNumbers() {
        List<Integer> inputList = Arrays.asList(6, 5, 4, 3, 2, 1, 0);
        MaxSumOfContiguousSequence.MaxSumInfo maxSubsequenceSum =
                maxSumOfContiguousSequence.maximumSumOfContiguousSubsequence(inputList);
        assertEquals(maxSubsequenceSum.getStart(), 0);
        assertEquals(maxSubsequenceSum.getEnd(), 5);
        assertEquals(maxSubsequenceSum.getMaxSum(), 21);
    }

    @Test
    public void mustSuccessfullyGetmaxValueWithALargePositiveNumberAtTheEnd() {
        List<Integer> inputList = Arrays.asList(6, 5, 4, 3, 2, 1, 1000);
        MaxSumOfContiguousSequence.MaxSumInfo maxSubsequenceSum =
                maxSumOfContiguousSequence.maximumSumOfContiguousSubsequence(inputList);
        assertEquals(maxSubsequenceSum.getStart(), 0);
        assertEquals(maxSubsequenceSum.getEnd(), 6);
        assertEquals(maxSubsequenceSum.getMaxSum(), 1021);
    }

    @Test
    public void mustSuccessfullyGetmaxValueWithALargeNegativeNumberInTheMiddle() {
        List<Integer> inputList = Arrays.asList(6, 5, 4, -100, 1000, -2000, 3);
        MaxSumOfContiguousSequence.MaxSumInfo maxSubsequenceSum =
                maxSumOfContiguousSequence.maximumSumOfContiguousSubsequence(inputList);
        assertEquals(maxSubsequenceSum.getStart(), 4);
        assertEquals(maxSubsequenceSum.getEnd(), 4);
        assertEquals(maxSubsequenceSum.getMaxSum(), 1000);
    }
}