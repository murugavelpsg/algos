package com.muru.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by msivagna on 3/10/16.
 */
public class RecursionProblemSet1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecursionProblemSet1.class);

    /**
     * Problem-1
     * Problem statement: A magic index in an array A[0 ... n-1] is defined to be an index such that A[i] = i.
     * Given a sorted array of distinct integers, write a method to find a magic
     * index, if one exists in array A.
     * @param inputList
     * @return
     */
    public Integer findMagicIndex(List<Integer> inputList) {
        return findMagicIndex(inputList, 0, inputList.size() - 1);
    }

    private Integer findMagicIndex(List<Integer> inputList, int start, int end) {
        if (start > end) {
            throw new NoSuchElementException();
        }
        int mid = (start + end)/2;
        if (inputList.get(mid).compareTo(mid) == 0) {
            return mid;
        } else if (inputList.get(mid).compareTo(mid) > 0){
            return findMagicIndex(inputList, start, mid - 1);
        } else {
            return findMagicIndex(inputList, mid + 1, end);
        }
    }

    public Integer findMagicIndexWithRepetition(List<Integer> inputList) {
        return findMagicIndexWithRepetition(inputList, 0, inputList.size() - 1);
    }

    /**
     * Followup of Problem-1:
     * Find the magic index when the elements are repeating.
     * @param inputList
     * @param start
     * @param end
     * @return
     */
    private Integer findMagicIndexWithRepetition(List<Integer> inputList, int start, int end) {
        if (start > end) {
            throw new NoSuchElementException();
        }

        int mid = (start + end) / 2;

        if (inputList.get(mid).compareTo(mid) == 0) {
            return mid;
        }

        //Since the list repeats we don't know on which side the magic index is. So search both sides
        try {
            int leftIndex = Math.min(inputList.get(mid), mid-1);
            return findMagicIndexWithRepetition(inputList, start, leftIndex);
        } catch (NoSuchElementException e) {
            LOGGER.debug("Element not found on the left hand side of the input list");
        }

        //Search the right side
        int rightIndex = Math.max(inputList.get(mid), mid+1);
        return findMagicIndexWithRepetition(inputList, rightIndex, end);
    }

    /**
     * Write a method to compute all permutations of a string of unique characters
     * Note: Not sure if it is right to ask the caller to supply the memoizedMap. But I felt it is better to have
     * the caller pass it than declaring a class variable. Class variable maintain state. If a single object is used
     * across multiple threads then we might run into race conditions
     * @param input
     * @param memoizedPermutationMap
     * @return
     */
    public List<String> findPermutationOfNonRepeatingString(String input,
                                                            Map<String, List<String>> memoizedPermutationMap) {
        List<String> result = new ArrayList<String>();

        //Return empty permutation for null String
        if (input == null) {
            return result;
        }

        //Look into the memoizedMap. If the result is present then return the result.
        if (memoizedPermutationMap.containsKey(input)) {
            return memoizedPermutationMap.get(input);
        }
        //If not continue and add the result to the memoized map

        //If the input element is of length one then add the string to the result and return
        if (input.length() == 1) {
            result.add(input);
            memoizedPermutationMap.put(input, result);
            return result;
        }
        /*
            For each letter in the string find the permutation of the rest of the string
            and prepend the value of the letter to each permuted value
         */
        for (int i = 0; i < input.length(); i++) {
            String restOfTheString = splitAndGetRestOfTheString(input, i);
            List<String> permutedList = findPermutationOfNonRepeatingString(restOfTheString, memoizedPermutationMap);
            for (String permutedItem : permutedList) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(input.charAt(i));
                stringBuilder.append(permutedItem);
                result.add(stringBuilder.toString());
            }
        }
        memoizedPermutationMap.put(input, result);
        return result;
    }

    private String splitAndGetRestOfTheString(String input, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 0) {
            stringBuilder.append(input.substring(i+1));
        } else if (i == input.length() - 1) {
            stringBuilder.append(input.substring(0, i));
        } else {
            stringBuilder.append(input.substring(0, i));
            stringBuilder.append(input.substring(i+1));
        }
        return stringBuilder.toString();
    }
}
