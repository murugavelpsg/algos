package com.muru.problems.string;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 6/10/16.
 */
public class IsomorphicStringsTest {
    IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
    @Test
    public void mustReturnSuccessForIsomorphicStrings() {
        String word1 = "abca";
        String word2 = "zbxz";
        assertTrue(isomorphicStrings.areWordsIsomorphic(word1, word2));
    }

    @Test
    public void mustReturnFailureForNonIsomorphicStringsWithTwoLettersMappingToSameValue() {
        String word1 = "abcadaf";
        String word2 = "zbxzdrg";
        assertFalse(isomorphicStrings.areWordsIsomorphic(word1, word2));
    }

    @Test
    public void mustReturnFailureForNonIsomorphicStrings() {
        String word1 = "abca";
        String word2 = "zbss";
        assertFalse(isomorphicStrings.areWordsIsomorphic(word1, word2));
    }

    @Test
    public void mustReturnFailureIfStringsAreOfDifferentLength() {
        String word1 = "abca";
        String word2 = "zbszasdf";
        assertFalse(isomorphicStrings.areWordsIsomorphic(word1, word2));
    }

    @Test
    public void mustReturnFailureIfOneOfTheStringIsNull() {
        String word1 = "abca";
        String word2 = null;
        assertFalse(isomorphicStrings.areWordsIsomorphic(word1, word2));
    }
}