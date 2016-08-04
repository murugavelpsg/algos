package com.muru.problems.searching;

/**
 * Created by msivagna on 8/3/16.
 *
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in the array.
 * You may assume that the array was originally sorted in increasing order
 *
 * Example:
 * Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 {the index 5 of the array}
 */
public class FindAnElementInASortedRotatedArray {
    public int findElement(Integer[] input, Integer value) {
        if (input == null || input.length == 0) {
            return -1;
        }

        return findElement(input, 0, input.length - 1, value);
    }

    private int findElement(Integer[] input, int start, int end, Integer value) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (input[mid] == value) {
            return mid;
        }

        //Check which one is the sorted half
        //See if the element can fall in the sorted half.
        //If so search, otherwise search the other half
        if (input[start] < input[mid]) {
            if (value >= input[start] && value < input[mid]) {
                return findElement(input, start, mid - 1, value);
            } else {
                return findElement(input, mid + 1, end, value);
            }
        } else if (input[mid] < input[end]) {
            if (value > input[mid] && value <= input[end]) {
                return findElement(input, mid + 1, end, value);
            } else {
                return findElement(input, start, mid - 1, value);
            }
        } else if (input[start] == input[mid]) {
            if (input[mid] != input[end]) {
                return findElement(input, mid + 1, end, value);
            } else {
                int retval = findElement(input, start, mid - 1, value);
                if (retval == -1) {
                    return findElement(input, mid + 1, end, value);
                }
                return retval;
            }
        }
        return -1;
    }
}
