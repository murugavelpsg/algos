package com.muru.problems.array;

import java.util.Arrays;

/**
 * Given an array and a value, find if there is a triplet in array whose sum is equal to
 * the given value. If there is such a triplet present in array, then print the triplet
 * and return true. Else return false.
 *
 * For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24,
 * then there is a triplet (12, 3 and 9) present in array whose sum is 24.
 *
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * Created by msivagna on 6/11/16.
 */
public class TripletsSumToANumber {
    public boolean findTripletsThatSumToANumber(int[] input, int sum) {
        if (input == null || input.length < 2) {
            return false;
        }
        int[] copyOfInput = new int[input.length];
        System.arraycopy(input, 0, copyOfInput, 0, input.length);
        Arrays.sort(copyOfInput);
        for (int i = 0; i < copyOfInput.length - 2; i++) {
            int left = i + 1;
            int right = copyOfInput.length - 1;
            while (left < right) {
                int arraySum = copyOfInput[i] + copyOfInput[left] + copyOfInput[right];
                if (arraySum == sum) {
                    return true;
                } else if (arraySum < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}
