package com.muru.problems.searching;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class CountOccurenceOfANumberTest {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void mustGetExceptionWhenInputIsNull() {
        int[] input = null;
        CountOccurenceOfANumber countOccurenceOfANumber = new CountOccurenceOfANumber();
        countOccurenceOfANumber.countOccurenceOfANumber(input, 1);
    }

    @Test
    public void mustGetZeroIfTheNumberIsNotPresent() {
        int[] input = {1,1,2,2,3,3,4,4,4,5,5,5,5,6};
        CountOccurenceOfANumber countOccurenceOfANumber = new CountOccurenceOfANumber();
        assertEquals(countOccurenceOfANumber.countOccurenceOfANumber(input, 7), 0);
    }

    @Test
    public void mustGetOneIfTheNumberOccursOnce() {
        int[] input = {1,1,2,2,3,3,4,4,4,5,5,5,5,6,7,7};
        CountOccurenceOfANumber countOccurenceOfANumber = new CountOccurenceOfANumber();
        assertEquals(countOccurenceOfANumber.countOccurenceOfANumber(input, 6), 1);
    }

    @Test
    public void mustGetCorrectNumberOfOccurencesInAGivenArrayOnRight() {
        int[] input = {1,1,2,2,3,3,4,4,4,5,5,5,5,6};
        CountOccurenceOfANumber countOccurenceOfANumber = new CountOccurenceOfANumber();
        assertEquals(countOccurenceOfANumber.countOccurenceOfANumber(input, 5), 4);
    }

    @Test
    public void mustGetCorrectNumberOfOccurencesInAGivenArrayOnLeft() {
        int[] input = {1,1,2,2,3,3,4,4,4,5,5,5,5,6};
        CountOccurenceOfANumber countOccurenceOfANumber = new CountOccurenceOfANumber();
        assertEquals(countOccurenceOfANumber.countOccurenceOfANumber(input, 2), 2);
    }

    @Test
    public void mustGetZeroIfTheArrayIsEmpty() {
        int[] input = {};
        CountOccurenceOfANumber countOccurenceOfANumber = new CountOccurenceOfANumber();
        assertEquals(countOccurenceOfANumber.countOccurenceOfANumber(input, 5), 0);
    }

    @Test
    public void mustFindNumberOfOccurencesInAOneElementArray() {
        int[] input = {6};
        CountOccurenceOfANumber countOccurenceOfANumber = new CountOccurenceOfANumber();
        assertEquals(countOccurenceOfANumber.countOccurenceOfANumber(input, 6), 1);
    }
}