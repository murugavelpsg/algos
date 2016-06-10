package com.muru.problems.recursion;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class PermutationOfAStringTest {
    PermutationOfAString permutationOfAString = new PermutationOfAString();
    @Test
    public void mustSuccessfullyReturnThePermutedValuesOfAString() {
        String inputString = "abc";
        Map<String, List<String>> memoizedPermutationMap = new HashMap<String, List<String>>();
        List<String> outputList = permutationOfAString.findPermutationOfNonRepeatingString(inputString, memoizedPermutationMap);
        assertEquals(outputList.size(), 6);
    }

    @Test
    public void mustSuccessfullyReturnThePermutedValuesOfALargeString() {
        String inputString = "abcdef";
        Map<String, List<String>> memoizedPermutationMap = new HashMap<String, List<String>>();
        List<String> outputList = permutationOfAString.findPermutationOfNonRepeatingString(inputString, memoizedPermutationMap);
        assertEquals(outputList.size(), 720);
    }

    @Test
    public void mustSuccessfullyReturnThePermutedValuesOfAOneCharString() {
        String inputString = "a";
        Map<String, List<String>> memoizedPermutationMap = new HashMap<String, List<String>>();
        List<String> outputList = permutationOfAString.findPermutationOfNonRepeatingString(inputString, memoizedPermutationMap);
        assertEquals(outputList.size(), 1);
    }

    @Test
    public void mustSuccessfullyReturnThePermutedValuesOfANullString() {
        String inputString = null;
        Map<String, List<String>> memoizedPermutationMap = new HashMap<String, List<String>>();
        List<String> outputList = permutationOfAString.findPermutationOfNonRepeatingString(inputString, memoizedPermutationMap);
        assertEquals(outputList.size(), 0);
    }
}