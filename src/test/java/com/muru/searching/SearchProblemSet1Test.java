package com.muru.searching;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 5/1/16.
 */
public class SearchProblemSet1Test {

    /*
        START: Problem 1
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void mustGetExceptionWhenInputIsNull() {
        int[] input = null;
        SearchProblemSet1 searchProblemSet1 = new SearchProblemSet1();
        searchProblemSet1.countOccurenceOfANumber(input, 1);
    }

    @Test
    public void mustGetZeroIfTheNumberIsNotPresent() {
        int[] input = {1,1,2,2,3,3,4,4,4,5,5,5,5,6};
        SearchProblemSet1 searchProblemSet1 = new SearchProblemSet1();
        assertEquals(searchProblemSet1.countOccurenceOfANumber(input, 7), 0);
    }

    @Test
    public void mustGetOneIfTheNumberOccursOnce() {
        int[] input = {1,1,2,2,3,3,4,4,4,5,5,5,5,6,7,7};
        SearchProblemSet1 searchProblemSet1 = new SearchProblemSet1();
        assertEquals(searchProblemSet1.countOccurenceOfANumber(input, 6), 1);
    }

    @Test
    public void mustGetCorrectNumberOfOccurencesInAGivenArrayOnRight() {
        int[] input = {1,1,2,2,3,3,4,4,4,5,5,5,5,6};
        SearchProblemSet1 searchProblemSet1 = new SearchProblemSet1();
        assertEquals(searchProblemSet1.countOccurenceOfANumber(input, 5), 4);
    }

    @Test
    public void mustGetCorrectNumberOfOccurencesInAGivenArrayOnLeft() {
        int[] input = {1,1,2,2,3,3,4,4,4,5,5,5,5,6};
        SearchProblemSet1 searchProblemSet1 = new SearchProblemSet1();
        assertEquals(searchProblemSet1.countOccurenceOfANumber(input, 2), 2);
    }

    @Test
    public void mustGetZeroIfTheArrayIsEmpty() {
        int[] input = {};
        SearchProblemSet1 searchProblemSet1 = new SearchProblemSet1();
        assertEquals(searchProblemSet1.countOccurenceOfANumber(input, 5), 0);
    }

    @Test
    public void mustFindNumberOfOccurencesInAOneElementArray() {
        int[] input = {6};
        SearchProblemSet1 searchProblemSet1 = new SearchProblemSet1();
        assertEquals(searchProblemSet1.countOccurenceOfANumber(input, 6), 1);
    }
    /*
        END: Problem 1
     */
}