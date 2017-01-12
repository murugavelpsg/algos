package com.muru.problems.array;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 1/12/17.
 */
public class MoveZerosInPlaceTest {
    @Test
    public void mustGetNullIfInputIsNull() {
        Integer[] input = null;
        MoveZerosInPlace moveZerosInPlace = new MoveZerosInPlace();
        moveZerosInPlace.doMoveZeros(input);
        Integer[] expectedOutput = null;
        assertEquals(input, expectedOutput);
    }

    @Test
    public void mustGetEmptyArrayIfInputIsEmpty() {
        Integer[] input = {};
        MoveZerosInPlace moveZerosInPlace = new MoveZerosInPlace();
        moveZerosInPlace.doMoveZeros(input);
        Integer[] expectedOutput = {};
        assertEquals(input, expectedOutput);
    }

    @Test
    public void mustGetAllZerosWhenInputIsAllZeros() {
        Integer[] input = {0, 0, 0, 0, 0, 0};
        MoveZerosInPlace moveZerosInPlace = new MoveZerosInPlace();
        moveZerosInPlace.doMoveZeros(input);
        Integer[] expectedOutput = {0, 0, 0, 0, 0, 0};
        assertEquals(input, expectedOutput);
    }

    @Test
    public void mustGetSameAsInputWhenInputContainsNoZeros() {
        Integer[] input = {1, 2, 3, 4, 5, 6};
        MoveZerosInPlace moveZerosInPlace = new MoveZerosInPlace();
        moveZerosInPlace.doMoveZeros(input);
        Integer[] expectedOutput = {1, 2, 3, 4, 5, 6};
        assertEquals(input, expectedOutput);
    }

    @Test
    public void mustMoveZerosToTheEndWithoutDisturbingOtherElements() {
        Integer[] input = {1, 0, 0, 4, 0, 6};
        MoveZerosInPlace moveZerosInPlace = new MoveZerosInPlace();
        moveZerosInPlace.doMoveZeros(input);
        Integer[] expectedOutput = {1, 4, 6, 0, 0, 0};
        assertEquals(input, expectedOutput);
    }

    @Test
    public void mustMoveZerosWhenZeroIsTheLastElement() {
        Integer[] input = {1, 2, 3, 4, 5, 0};
        MoveZerosInPlace moveZerosInPlace = new MoveZerosInPlace();
        moveZerosInPlace.doMoveZeros(input);
        Integer[] expectedOutput = {1, 2, 3, 4, 5, 0};
        assertEquals(input, expectedOutput);
    }

    @Test
    public void mustMoveZerosWhenZeroIsTheFirstElement() {
        Integer[] input = {0, 1, 0, 3, 4, 5};
        MoveZerosInPlace moveZerosInPlace = new MoveZerosInPlace();
        moveZerosInPlace.doMoveZeros(input);
        Integer[] expectedOutput = {1, 3, 4, 5, 0, 0};
        assertEquals(input, expectedOutput);
    }

    @Test
    public void mustMoveZerosForArrayOfSizeOne() {
        Integer[] input = {0};
        MoveZerosInPlace moveZerosInPlace = new MoveZerosInPlace();
        moveZerosInPlace.doMoveZeros(input);
        Integer[] expectedOutput = {0};
        assertEquals(input, expectedOutput);
    }
}