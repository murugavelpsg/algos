package com.muru.problems.recursion;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class MagicIndexInAnArrayTest {
    MagicIndexInAnArray magicIndexInAnArray = new MagicIndexInAnArray();
    @Test
    public void mustSuccessfullyReturnTheMagicNumberWhichIsOnTheLeft() {
        List<Integer> inputList = Arrays.asList(0, 3, 4, 5, 6, 8, 1000);
        Integer magicIndex = magicIndexInAnArray.findMagicIndex(inputList);
        assertEquals(magicIndex, new Integer(0));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustSuccessfullyReturnTheMagicNumberIfAllElementsAreIdentical() {
        List<Integer> inputList = Arrays.asList(1, 1, 1, 1, 1, 1, 1);
        Integer magicIndex = magicIndexInAnArray.findMagicIndex(inputList);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustSuccessfullyReturnTheMagicNumberWhichIsOnTheRight() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 4, 5, 6);
        Integer magicIndex = magicIndexInAnArray.findMagicIndex(inputList);
    }
}