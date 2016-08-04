package com.muru.problems.searching;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 8/3/16.
 */
public class FindAnElementInASortedRotatedArrayTest {

    @Test
    public void mustGetNegativeOneForAnNullInput() {
        Integer[] input = null;
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 100), -1);
    }

    @Test
    public void mustGetNegativeOneForAnEmptyArray() {
        Integer[] input = {};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 100), -1);
    }

    @Test
    public void mustGetIndexIfTheElementIsPresentInOneElementArray() {
        Integer[] input = {100};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 100), 0);
    }

    @Test
    public void mustGetIndexIfTheElementIsPresentOnLeftInARightRotatedArray() {
        Integer[] input = {35, 67, 89, 1, 4, 5, 7, 10, 11, 15, 21};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 89), 2);
    }

    @Test
    public void mustGetIndexIfTheElementIsPresentOnRightInARightRotatedArray() {
        Integer[] input = {35, 67, 89, 1, 4, 5, 7, 10, 11, 15, 21};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 11), 8);
    }

    @Test
    public void mustGetIndexIfTheElementIsPresentOnRightInALeftRotatedArray() {
        Integer[] input = {10, 11, 15, 21, 35, 67, 89, 1, 4, 5, 7};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 89), 6);
    }

    @Test
    public void mustGetIndexIfTheElementIsPresentOnLeftInALeftRotatedArray() {
        Integer[] input = {10, 11, 15, 21, 35, 67, 89, 1, 4, 5, 7};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 11), 1);
    }

    @Test
    public void mustGetNegativeOneIfTheElementIsAbsentInMultiElementArray() {
        Integer[] input = {35, 67, 89, 1, 4, 5, 7, 11, 15, 21};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 100), -1);
    }

    @Test
    public void mustGetIndexIfTheElementIsPresentInAnArrayWithRepeatedElementsAtStartAndEnd() {
        Integer[] input = {35, 35, 35, 35, 35, 2, 4, 5, 7, 35};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 5), 7);
    }

    @Test
    public void mustGetIndexIfTheElementIsPresentInAnArrayWithRepeatedElementsOnlyAtStart() {
        Integer[] input = {35, 35, 35, 35, 35, 2, 4, 5, 7, 24};
        FindAnElementInASortedRotatedArray findAnElementInASortedRotatedArray = new FindAnElementInASortedRotatedArray();
        assertEquals(findAnElementInASortedRotatedArray.findElement(input, 5), 7);
    }
}