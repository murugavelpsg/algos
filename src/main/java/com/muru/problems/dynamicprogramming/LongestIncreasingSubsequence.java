package com.muru.problems.dynamicprogramming;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The task is to find the length of the longest subsequence in a given array of integers such that all elements
 * of the subsequence are sorted in ascending order. For example, the length of the LIS for
 * { 15, 27, 14, 38, 26, 55, 46, 65, 85 } is 6 and the longest increasing subsequence is {15, 27, 38, 55, 65, 85}.
 *
 * Created by msivagna on 12/14/16.
 */
public class LongestIncreasingSubsequence {
    public List<Integer> calculateLongestIncreasingSubsequence(List<Integer> input) {
        if (CollectionUtils.isEmpty(input)) {
            return input;
        }
        return calculateLIS(input);
    }

    private List<Integer> calculateLIS(List<Integer> input) {
        List<List<Integer>> longestIncreasingSubsequences = getInitialized2DList(input.size());
        longestIncreasingSubsequences.get(0).add(input.get(0));
        /*
            L[0] = D[0]
            L[i] = Max(L[j] + 1, L[i]) for D[i] > D[j], j < i
         */
        for (int i = 1; i < input.size(); i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (input.get(i).compareTo(input.get(j)) > 0 &&
                        longestIncreasingSubsequences.get(j).size() + 1 > longestIncreasingSubsequences.get(i).size()) {
                    longestIncreasingSubsequences.set(i, new ArrayList<Integer>(longestIncreasingSubsequences.get(j)));
                }
            }
            longestIncreasingSubsequences.get(i).add(input.get(i));
        }
        return longestIncreasingSubsequences.get(longestIncreasingSubsequences.size() - 1);
    }

    private List<List<Integer>> getInitialized2DList(int size) {
        List<List<Integer>> twoDList = new ArrayList<List<Integer>>();
        for (int i = 0; i < size; i++) {
            twoDList.add(i, new ArrayList<Integer>());
        }
        return twoDList;
    }
}
