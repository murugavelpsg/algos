package com.muru.problems.recursion;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class MagicIndexInAnArrayWithRepetitionTest {
    MagicIndexInAnArrayWithRepetition magicIndexInAnArrayWithRepetition = new MagicIndexInAnArrayWithRepetition();
    @Test
    public void mustSuccessfullyReturnTheRepeatingMagicNumberWhichIsOnTheLeft() {
        List<Integer> inputList = Arrays.asList(0, 3, 4, 5, 6, 8, 1000);
        Integer magicIndex = magicIndexInAnArrayWithRepetition.findMagicIndexWithRepetition(inputList);
        assertEquals(magicIndex, new Integer(0));
    }

    @Test
    public void mustSuccessfullyReturnTheRepeatingMagicNumberIfAllElementsAreIdentical() {
        List<Integer> inputList = Arrays.asList(1, 1, 1, 1, 1, 1, 1);
        Integer magicIndex = magicIndexInAnArrayWithRepetition.findMagicIndexWithRepetition(inputList);
    }

    @Test
    public void mustSuccessfullyReturnTheRepeatingMagicNumberWhichIsOnTheRight() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 4, 5, 6);
        Integer magicIndex = magicIndexInAnArrayWithRepetition.findMagicIndexWithRepetition(inputList);
    }
}