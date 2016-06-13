package com.muru.problems.array;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/11/16.
 */
public class TripletsSumToANumberTest {
    @Test
    public void mustReturnFalseIfTheArrayIsNull() {
        int[] inputArray = null;
        TripletsSumToANumber tripletsSumToANumber = new TripletsSumToANumber();
        boolean result = tripletsSumToANumber.findTripletsThatSumToANumber(inputArray, 0);
        assertEquals(result, false);
    }

    @Test
    public void mustReturnFalseIfTheArrayHasOneElement() {
        int[] inputArray = {1};
        TripletsSumToANumber tripletsSumToANumber = new TripletsSumToANumber();
        boolean result = tripletsSumToANumber.findTripletsThatSumToANumber(inputArray, 0);
        assertEquals(result, false);
    }

    @Test
    public void mustReturnFalseIfTheArrayHasTwoElements() {
        int[] inputArray = {1, 2};
        TripletsSumToANumber tripletsSumToANumber = new TripletsSumToANumber();
        boolean result = tripletsSumToANumber.findTripletsThatSumToANumber(inputArray, 0);
        assertEquals(result, false);
    }

    @Test
    public void mustReturnTrueIfThe3ElementArrayHasTheSum() {
        int[] inputArray = {4, 3, 2};
        TripletsSumToANumber tripletsSumToANumber = new TripletsSumToANumber();
        boolean result = tripletsSumToANumber.findTripletsThatSumToANumber(inputArray, 9);
        assertEquals(result, true);
    }

    @Test
    public void mustReturnTrueIfTheArrayHasTheTripletSumWhichIsNegative() {
        int[] inputArray = {2, 2, -1, -2, -3, -1, -10, 2, 4, 5, 10};
        TripletsSumToANumber tripletsSumToANumber = new TripletsSumToANumber();
        boolean result = tripletsSumToANumber.findTripletsThatSumToANumber(inputArray, -14);
        assertEquals(result, true);
    }

    @Test
    public void mustReturnFalseIfTheArrayDoesNotHaveTheTripletSum() {
        int[] inputArray = {2, 2, -1, -2, -3, -1, -10, 2, 4, 5, 10};
        TripletsSumToANumber tripletsSumToANumber = new TripletsSumToANumber();
        boolean result = tripletsSumToANumber.findTripletsThatSumToANumber(inputArray, 100);
        assertEquals(result, false);
    }

    @Test
    public void mustReturnTrueForAnArrayWithPostiveAndNegativeNumbersThatHasTripletSum() {
        int[] inputArray = {2, 2, -1, -2, -3, -1, -10, 2, 4, 5, 10};
        TripletsSumToANumber tripletsSumToANumber = new TripletsSumToANumber();
        boolean result = tripletsSumToANumber.findTripletsThatSumToANumber(inputArray, 6);
        assertEquals(result, true);
    }
}