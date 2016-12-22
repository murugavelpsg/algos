package com.muru.problems.general;

import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 12/22/16.
 */
public class SumOfDigitsTest {

    @Test
    public void mustGetSumOfDigits() throws ValidationException {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int input = 38;
        int expectedOutput = 2;
        int actualOutput = sumOfDigits.calculateSumOfDigits(input);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetZeroIfInputIsZero() throws ValidationException {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int input = 0;
        int expectedOutput = 0;
        int actualOutput = sumOfDigits.calculateSumOfDigits(input);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetSamNumberIfInputIsOneDigit() throws ValidationException {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int input = 8;
        int expectedOutput = input;
        int actualOutput = sumOfDigits.calculateSumOfDigits(input);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfTheInputIsNegative() throws ValidationException {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int input = -10;
        sumOfDigits.calculateSumOfDigits(input);
    }
}