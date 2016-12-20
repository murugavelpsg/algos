package com.muru.problems.dynamicprogramming;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 12/20/16.
 */
public class LongestCommonSubsequenceTest {

    @Test
    public void mustGetTheLengthOfLcs() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = "MZJAWXU";
        int expectedLength = 4;
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int actualLength = longestCommonSubsequence.calculateLength(sequence1, sequence2);
        assertEquals(actualLength, expectedLength);
    }

    @Test
    public void mustGetZeroIfOneOfTheInputIsNull() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = null;
        int expectedLength = 0;
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int actualLength = longestCommonSubsequence.calculateLength(sequence1, sequence2);
        assertEquals(actualLength, expectedLength);
    }

    @Test
    public void mustGetZeroIfOneOfTheInputIsEmpty() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = "";
        int expectedLength = 0;
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int actualLength = longestCommonSubsequence.calculateLength(sequence1, sequence2);
        assertEquals(actualLength, expectedLength);
    }

    @Test
    public void mustGetLcsAsOneOnlyIfOneCharMatch() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = "KKKKKXKKKKK";
        int expectedLength = 1;
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int actualLength = longestCommonSubsequence.calculateLength(sequence1, sequence2);
        assertEquals(actualLength, expectedLength);
    }

    @Test
    public void mustGetZeroIfNoneOfTheCharactersMatch() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = "NNNNNNNNNN";
        int expectedLength = 0;
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int actualLength = longestCommonSubsequence.calculateLength(sequence1, sequence2);
        assertEquals(actualLength, expectedLength);
    }

    @Test
    public void mustGetLcsForTwoStrings() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = "MZJAWXU";
        String expectedOutput = "MJAU";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String actualOutput = longestCommonSubsequence.getCommonSubsequence(sequence1, sequence2);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetEmptyStringIfOneOfTheStringIsEmpty() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = "";
        String expectedOutput = "";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String actualOutput = longestCommonSubsequence.getCommonSubsequence(sequence1, sequence2);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetEmptyStringIfOneOfTheStringIsNull() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = null;
        String expectedOutput = "";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String actualOutput = longestCommonSubsequence.getCommonSubsequence(sequence1, sequence2);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetEmptyStringForNoSubsequence() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = "NNNNNNNNNNNNNN";
        String expectedOutput = "";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String actualOutput = longestCommonSubsequence.getCommonSubsequence(sequence1, sequence2);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetAMatchIfOnlyOneCharMatches() {
        String sequence1 = "XMJYAUZ";
        String sequence2 = "NNNNNJNNNNNNNNN";
        String expectedOutput = "J";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String actualOutput = longestCommonSubsequence.getCommonSubsequence(sequence1, sequence2);
        assertEquals(actualOutput, expectedOutput);
    }
}