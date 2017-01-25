package com.muru.problems.array;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 1/25/17.
 */
public class IntersectionOfTwoArraysTest {
    @Test
    public void mustGetIntersectionOfTwoArrays() {
        Integer[] input1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] input2 = {4, 5, 6, 7, 8, 9, 10};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Integer[] actualOutput = intersectionOfTwoArrays.findIntersection(input1, input2);
        Integer[] expectedOutput = {4, 5, 6, 7};
        assertEquals(actualOutput.length, expectedOutput.length);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetIntersectionOfTwoArraysIfInputsAreSame() {
        Integer[] input1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] input2 = {1, 2, 3, 4, 5, 6, 7};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Integer[] actualOutput = intersectionOfTwoArrays.findIntersection(input1, input2);
        Integer[] expectedOutput = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(actualOutput.length, expectedOutput.length);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetUniqueIntersectionIfTheInputsAreRepeating() {
        Integer[] input1 = {1, 2, 2, 2, 3, 4, 5, 6, 7};
        Integer[] input2 = {2, 2, 8, 7};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Integer[] actualOutput = intersectionOfTwoArrays.findIntersection(input1, input2);
        Integer[] expectedOutput = {2, 7};
        assertEquals(actualOutput.length, expectedOutput.length);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetEmptyArrayIfNoElementsAreCommon() {
        Integer[] input1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] input2 = {8, 9, 19};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Integer[] actualOutput = intersectionOfTwoArrays.findIntersection(input1, input2);
        Integer[] expectedOutput = {};
        assertEquals(actualOutput.length, expectedOutput.length);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetEmptyArrayIfOneOfTheInputIsNull() {
        Integer[] input1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] input2 = null;
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Integer[] actualOutput = intersectionOfTwoArrays.findIntersection(input1, input2);
        Integer[] expectedOutput = {};
        assertEquals(actualOutput.length, expectedOutput.length);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetEmptyArrayIfOneOfTheInputIsEmpty() {
        Integer[] input1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] input2 = {};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Integer[] actualOutput = intersectionOfTwoArrays.findIntersection(input1, input2);
        Integer[] expectedOutput = {};
        assertEquals(actualOutput.length, expectedOutput.length);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetIntersectionIfBothTheInputsAreSameAndOfLengthOne() {
        Integer[] input1 = {1};
        Integer[] input2 = {1};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Integer[] actualOutput = intersectionOfTwoArrays.findIntersection(input1, input2);
        Integer[] expectedOutput = {1};
        assertEquals(actualOutput.length, expectedOutput.length);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetEmptyArrayIfInputsAreDifferentAndOfLengthOne() {
        Integer[] input1 = {1};
        Integer[] input2 = {4};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        Integer[] actualOutput = intersectionOfTwoArrays.findIntersection(input1, input2);
        Integer[] expectedOutput = {};
        assertEquals(actualOutput.length, expectedOutput.length);
        assertEquals(actualOutput, expectedOutput);
    }
}