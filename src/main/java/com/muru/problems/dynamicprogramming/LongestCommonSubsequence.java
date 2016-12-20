package com.muru.problems.dynamicprogramming;

import org.apache.commons.lang.StringUtils;

/**
 * Created by msivagna on 12/20/16.
 */
public class LongestCommonSubsequence {
    public int calculateLength(String sequence1, String sequence2) {
        if (StringUtils.isEmpty(sequence1) || StringUtils.isEmpty(sequence2)) {
            return 0;
        }
        String sequence11 = " " + sequence1;
        String sequence21 = " " + sequence2;
        int[][] lcs = findLongestCommonSubsequence(sequence11, sequence21);
        return lcs[sequence11.length() - 1][sequence21.length() - 1];
    }

    public String getCommonSubsequence(String sequence1, String sequence2) {
        if (StringUtils.isEmpty(sequence1) || StringUtils.isEmpty(sequence2)) {
            return "";
        }
        String sequence11 = " " + sequence1;
        String sequence21 = " " + sequence2;
        int[][] lcs = findLongestCommonSubsequence(sequence11, sequence21);
        return getCommonSubsequence(lcs, sequence11, sequence21, sequence11.length() - 1, sequence21.length() - 1);
    }

    //Goes bottom up for finding the sequence
    //Traces the path of the highest number
    private String getCommonSubsequence(int[][] lcs, String sequence1, String sequence2, int index1, int index2) {
        if (index1 > 0 && index2 > 0) {
            if (sequence1.charAt(index1) == sequence2.charAt(index2)) {
                return getCommonSubsequence(lcs, sequence1, sequence2, index1 - 1, index2 - 1) + sequence1.charAt(index1);
            } else if (lcs[index1 - 1][index2] > lcs[index1][index2 - 1]) {
                return getCommonSubsequence(lcs, sequence1, sequence2, index1 - 1, index2);
            } else {
                return getCommonSubsequence(lcs, sequence1, sequence2, index1, index2 - 1);
            }
        }
        return "";
    }

    //Builds the matrix to find the longest common subsequence
    //If the characters are equal then take the largest match so far and increment it by one
    //Else carryover the previous greatest match and continue
    private int[][] findLongestCommonSubsequence(String sequence1, String sequence2) {
        int[][] lcs = getInitialized2DArray(sequence1.length(), sequence2.length());
        for (int i = 1; i < sequence1.length(); i++) {
            for (int j = 1; j < sequence2.length(); j++) {
                if (sequence1.charAt(i) == sequence2.charAt(j)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else if (lcs[i-1][j] > lcs[i][j-1]) {
                    lcs[i][j] = lcs[i-1][j];
                } else {
                    lcs[i][j] = lcs[i][j-1];
                }
            }
        }
        return lcs;
    }

    private int[][] getInitialized2DArray(int length1, int length2) {
        int[][] twoDArray = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                twoDArray[i][j] = 0;
            }
        }
        return twoDArray;
    }
}
