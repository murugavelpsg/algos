package com.muru.problems.array;

import javax.xml.bind.ValidationException;

/**
 * Given two positive integer arrays sorted in ascending order,
 * find the absolute minimum difference between any pair of elements |a-b|
 * such that a is from one array and b is from another array.

     For example consider the following two arrays.

     array1 = [3, 27, 45, 68, 70, 81, 99]
     array2 = [9, 16, 25, 35, 70, 84]
     The minimum difference is 0 (70 - 70).
 * Created by msivagna on 12/23/16.
 */
public class MinDifferenceBetweenTwoSortedArrays {
    public MinDiffSummary calculateDifference(int[] input1, int[] input2) throws ValidationException {
        MinDiffSummary minDiffSummary = new MinDiffSummary();
        if (input1 == null || input2 == null || input1.length ==0 || input2.length == 0) {
            throw new ValidationException("Input arrays cannot be null or empty");
        }

        int i = 0;
        int j = 0;

        while (i < input1.length && j < input2.length) {
            int currentMinDiff = Math.abs(input1[i] - input2[j]);
            if (currentMinDiff < minDiffSummary.getMinDiff()) {
                minDiffSummary.setMinDiff(currentMinDiff);
                minDiffSummary.setArray1Index(i);
                minDiffSummary.setArray2Index(j);
                if (currentMinDiff == 0) {
                    return minDiffSummary;
                }
            }
            if (input1[i] < input2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return minDiffSummary;
    }
}
