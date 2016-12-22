package com.muru.problems.array;

import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 12/23/16.
 */
public class MinDifferenceBetweenTwoSortedArraysTest {

    @Test
    public void mustGetTheMinDiff() throws ValidationException {
        int[] input1 = {3, 27, 45, 68, 70, 81, 99};
        int[] input2 = {9, 16, 25, 35, 70, 84};
        int expectedDifference = 0;
        int expectedArray1Index = 4;
        int expectedArray2Index = 4;
        MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
        MinDiffSummary minDiffSummary = minDifference.calculateDifference(input1, input2);
        assertEquals(minDiffSummary.getMinDiff(), expectedDifference);
        assertEquals(minDiffSummary.getArray1Index(), expectedArray1Index);
        assertEquals(minDiffSummary.getArray2Index(), expectedArray2Index);
    }

    @Test
    public void mustGetTheMinDiffWhenArray1IsMuchSmaller() throws ValidationException {
        int[] input1 = {3, 27, 45, 65, 72, 82, 85, 99};
        int[] input2 = {9, 70, 84};
        int expectedDifference = 1;
        int expectedArray1Index = 6;
        int expectedArray2Index = 2;
        MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
        MinDiffSummary minDiffSummary = minDifference.calculateDifference(input1, input2);
        assertEquals(minDiffSummary.getMinDiff(), expectedDifference);
        assertEquals(minDiffSummary.getArray1Index(), expectedArray1Index);
        assertEquals(minDiffSummary.getArray2Index(), expectedArray2Index);
    }

    @Test
    public void mustGetTheMinDiffWhenArray2IsMuchSmaller() throws ValidationException {
        int[] input1 = {9, 70, 84};
        int[] input2 = {3, 27, 45, 65, 72, 82, 85, 99};
        int expectedDifference = 1;
        int expectedArray1Index = 2;
        int expectedArray2Index = 6;
        MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
        MinDiffSummary minDiffSummary = minDifference.calculateDifference(input1, input2);
        assertEquals(minDiffSummary.getMinDiff(), expectedDifference);
        assertEquals(minDiffSummary.getArray1Index(), expectedArray1Index);
        assertEquals(minDiffSummary.getArray2Index(), expectedArray2Index);
    }

    @Test
    public void mustGetTheMinDiffWhenTheArraysAreOfEqualLength() throws ValidationException {
        int[] input1 = {3, 27, 71};
        int[] input2 = {9, 70, 84};
        int expectedDifference = 1;
        int expectedArray1Index = 2;
        int expectedArray2Index = 1;
        MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
        MinDiffSummary minDiffSummary = minDifference.calculateDifference(input1, input2);
        assertEquals(minDiffSummary.getMinDiff(), expectedDifference);
        assertEquals(minDiffSummary.getArray1Index(), expectedArray1Index);
        assertEquals(minDiffSummary.getArray2Index(), expectedArray2Index);
    }

    @Test
    public void mustGetTheMinDiffWhenTheLastElementsAreEqualAndArraysAreEqualLength() throws ValidationException {
        int[] input1 = {3, 27, 83};
        int[] input2 = {9, 70, 84};
        int expectedDifference = 1;
        int expectedArray1Index = 2;
        int expectedArray2Index = 2;
        MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
        MinDiffSummary minDiffSummary = minDifference.calculateDifference(input1, input2);
        assertEquals(minDiffSummary.getMinDiff(), expectedDifference);
        assertEquals(minDiffSummary.getArray1Index(), expectedArray1Index);
        assertEquals(minDiffSummary.getArray2Index(), expectedArray2Index);
    }

    @Test
    public void mustGetTheMinDiffWhenMinIsAtTheEndOfArray() throws ValidationException {
        int[] input1 = {1, 5, 7};
        int[] input2 = {2, 3, 6, 7};
        int expectedDifference = 0;
        int expectedArray1Index = 2;
        int expectedArray2Index = 3;
        MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
        MinDiffSummary minDiffSummary = minDifference.calculateDifference(input1, input2);
        assertEquals(minDiffSummary.getMinDiff(), expectedDifference);
        assertEquals(minDiffSummary.getArray1Index(), expectedArray1Index);
        assertEquals(minDiffSummary.getArray2Index(), expectedArray2Index);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfOneOfTheArrayIsEmpty() throws ValidationException {
        int[] input1 = {3, 27, 45, 68, 70, 81, 99};
        int[] input2 = {};
        MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
        MinDiffSummary minDiffSummary = minDifference.calculateDifference(input1, input2);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfOneOrBothInputIsNull() throws ValidationException {
        int[] input1 = {3, 27, 45, 68, 70, 81, 99};
        int[] input2 = null;
        MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
        minDifference.calculateDifference(input1, input2);
    }
}