package com.muru.problems.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by msivagna on 6/10/16.
 */
public class PermutationOfAString {
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
