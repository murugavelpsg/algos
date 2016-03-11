package com.muru.recursion;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 3/10/16.
 */
public class RecursionProblemSet1Test {
    RecursionProblemSet1 recursionProblemSet1 = new RecursionProblemSet1();

    @Test
    public void mustSuccessfullyReturnTheMagicNumberWhichIsOnTheLeft() {
        List<Integer> inputList = Arrays.asList(0, 3, 4, 5, 6, 8, 1000);
        Integer magicIndex = recursionProblemSet1.findMagicIndex(inputList);
        assertEquals(magicIndex, new Integer(0));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustSuccessfullyReturnTheMagicNumberIfAllElementsAreIdentical() {
        List<Integer> inputList = Arrays.asList(1, 1, 1, 1, 1, 1, 1);
        Integer magicIndex = recursionProblemSet1.findMagicIndex(inputList);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustSuccessfullyReturnTheMagicNumberWhichIsOnTheRight() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 4, 5, 6);
        Integer magicIndex = recursionProblemSet1.findMagicIndex(inputList);
    }

    @Test
    public void mustSuccessfullyReturnTheRepeatingMagicNumberWhichIsOnTheLeft() {
        List<Integer> inputList = Arrays.asList(0, 3, 4, 5, 6, 8, 1000);
        Integer magicIndex = recursionProblemSet1.findMagicIndexWithRepetition(inputList);
        assertEquals(magicIndex, new Integer(0));
    }

    @Test
    public void mustSuccessfullyReturnTheRepeatingMagicNumberIfAllElementsAreIdentical() {
        List<Integer> inputList = Arrays.asList(1, 1, 1, 1, 1, 1, 1);
        Integer magicIndex = recursionProblemSet1.findMagicIndexWithRepetition(inputList);
    }

    @Test
    public void mustSuccessfullyReturnTheRepeatingMagicNumberWhichIsOnTheRight() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 4, 5, 6);
        Integer magicIndex = recursionProblemSet1.findMagicIndexWithRepetition(inputList);
    }

    @Test
    public void mustSuccessfullyReturnThePermutedValuesOfAString() {
        String inputString = "abc";
        List<String> outputList = recursionProblemSet1.findPermutationOfNonRepeatingString(inputString);
        assertEquals(outputList.size(), 6);
    }

    @Test
    public void mustSuccessfullyReturnThePermutedValuesOfALargeString() {
        String inputString = "abcdef";
        List<String> outputList = recursionProblemSet1.findPermutationOfNonRepeatingString(inputString);
        assertEquals(outputList.size(), 720);
    }

    @Test
    public void mustSuccessfullyReturnThePermutedValuesOfAOneCharString() {
        String inputString = "a";
        List<String> outputList = recursionProblemSet1.findPermutationOfNonRepeatingString(inputString);
        assertEquals(outputList.size(), 1);
    }

    @Test
    public void mustSuccessfullyReturnThePermutedValuesOfANullString() {
        String inputString = null;
        List<String> outputList = recursionProblemSet1.findPermutationOfNonRepeatingString(inputString);
        assertEquals(outputList.size(), 0);
    }
}