package com.muru.problems.dynamicprogramming;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 12/14/16.
 */
public class LongestIncreasingSubsequenceTest {

    @Test
    public void mustGetNullWhenTheInputIsNull() {
        List<Integer> input = null;
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        List<Integer> actualOutput = longestIncreasingSubsequence.calculateLongestIncreasingSubsequence(input);
        assertEquals(actualOutput, null);
    }

    @Test
    public void mustGetEmptyListWhenTheInputIsEmpty() {
        List<Integer> input = new ArrayList<Integer>();
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        List<Integer> actualOutput = longestIncreasingSubsequence.calculateLongestIncreasingSubsequence(input);
        assertEquals(actualOutput.size(), 0);
    }

    @Test
    public void mustGetLISForOneElementInput() {
        List<Integer> input = new ArrayList<Integer>();
        input.add(2);
        List<Integer> expectedOutput = new ArrayList<Integer>();
        expectedOutput.add(2);
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        List<Integer> actualOutput = longestIncreasingSubsequence.calculateLongestIncreasingSubsequence(input);
        assertEquals(actualOutput.size(), 1);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetLISForTwoElementInput() {
        List<Integer> input = new ArrayList<Integer>();
        input.add(2);
        input.add(3);
        List<Integer> expectedOutput = new ArrayList<Integer>();
        expectedOutput.add(2);
        expectedOutput.add(3);
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        List<Integer> actualOutput = longestIncreasingSubsequence.calculateLongestIncreasingSubsequence(input);
        assertEquals(actualOutput.size(), 2);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetLISTheCorrectLISForLargeInputs() {
        List<Integer> input = new ArrayList<Integer>();
        input.add(15);
        input.add(27);
        input.add(14);
        input.add(38);
        input.add(26);
        input.add(55);
        input.add(46);
        input.add(65);
        input.add(85);
        List<Integer> expectedOutput = new ArrayList<Integer>();
        expectedOutput.add(15);
        expectedOutput.add(27);
        expectedOutput.add(38);
        expectedOutput.add(55);
        expectedOutput.add(65);
        expectedOutput.add(85);
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        List<Integer> actualOutput = longestIncreasingSubsequence.calculateLongestIncreasingSubsequence(input);
        assertEquals(actualOutput.size(), 6);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetOutputSameAsInputForAscendingSortedArray() {
        List<Integer> input = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            input.add(i);
        }
        Collections.sort(input);
        List<Integer> expectedOutput = input;
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        List<Integer> actualOutput = longestIncreasingSubsequence.calculateLongestIncreasingSubsequence(input);
        assertEquals(actualOutput.size(), input.size());
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetOneElementWhenInputForDescendingSortedArray() {
        List<Integer> input = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            input.add(i);
        }
        Collections.sort(input, Collections.reverseOrder());
        List<Integer> expectedOutput = new ArrayList<Integer>();
        expectedOutput.add(0);
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        List<Integer> actualOutput = longestIncreasingSubsequence.calculateLongestIncreasingSubsequence(input);
        assertEquals(actualOutput.size(), 1);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetOneElementWhenInputIsAllSame() {
        List<Integer> input = new ArrayList<Integer>();
        int SAME_ELEMENT = 10;
        for (int i = 0; i < 10; i++) {
            input.add(SAME_ELEMENT);
        }
        List<Integer> expectedOutput = new ArrayList<Integer>();
        expectedOutput.add(SAME_ELEMENT);
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        List<Integer> actualOutput = longestIncreasingSubsequence.calculateLongestIncreasingSubsequence(input);
        assertEquals(actualOutput.size(), 1);
        assertEquals(actualOutput, expectedOutput);
    }
}