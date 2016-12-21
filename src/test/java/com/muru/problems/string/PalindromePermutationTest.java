package com.muru.problems.string;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 12/20/16.
 */
public class PalindromePermutationTest {
    @Test
    public void mustReturnTrueIfPermutationResultInPalindrome() {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        assertTrue(palindromePermutation.isPalindromePossible("aab"));
        assertTrue(palindromePermutation.isPalindromePossible("abab"));
        assertTrue(palindromePermutation.isPalindromePossible("carerac"));
    }

    @Test
    public void mustReturnFalseIfPermutationNotResultInPalindrome() {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        assertFalse(palindromePermutation.isPalindromePossible("myname"));
        assertFalse(palindromePermutation.isPalindromePossible("shutterfly"));
    }

    @Test
    public void mustReturnFalseIfTheInputIsNull() {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        assertFalse(palindromePermutation.isPalindromePossible(null));
    }

    @Test
    public void mustReturnFalseIfTheInputIsEmpty() {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        assertFalse(palindromePermutation.isPalindromePossible(""));
    }
}