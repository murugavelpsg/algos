package com.muru.problems.searching;

/**
 * Created by msivagna on 6/10/16.
 */
public class CountOccurenceOfANumber {
    /**
     * Problem - 1
     * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[].
     * Time Complexity : O(logn)
     * @return
     */
    public int countOccurenceOfANumber(int[] input, int number) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        if (input.length == 0) {
            return 0;
        }

        int firstOccurence = findFirstOccurence(input, 0, input.length - 1, number);
        int lastOccurence = findLastOccurence(input, 0, input.length - 1, number);
        if (firstOccurence == -1 && lastOccurence == -1) {
            return 0;
        } else {
            return (lastOccurence-firstOccurence+1);
        }
    }

    private int findFirstOccurence(int[] input, int start, int end, int number) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int startIndex = start;
        int endIndex = end;
        int minIndex = -1;
        if (input[mid] == number) {
            minIndex = mid;
            endIndex = mid -1;
        } else {
            if (input[mid] > number ) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        int nextIndex = findFirstOccurence(input, startIndex, endIndex, number);
        if (minIndex == -1) {
            return nextIndex;
        } else if (nextIndex == -1) {
            return minIndex;
        } else {
            return (minIndex < nextIndex ? minIndex : nextIndex);
        }
    }

    private int findLastOccurence(int[] input, int start, int end, int number) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        int startIndex = start;
        int endIndex = end;
        int maxIndex = -1;
        if (input[mid] == number) {
            maxIndex = mid;
            startIndex = mid +1;
        } else {
            if (input[mid] > number ) {
                endIndex = mid - 1;
            } else {
                startIndex = mid + 1;
            }
        }
        int nextIndex = findLastOccurence(input, startIndex, endIndex, number);
        if (maxIndex == -1) {
            return nextIndex;
        } else if (nextIndex == -1) {
            return maxIndex;
        } else {
            return (maxIndex > nextIndex ? maxIndex : nextIndex);
        }
    }
}
