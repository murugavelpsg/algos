package com.muru.problems.string;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 7/27/16.
 */
public class CheckIfStringIsPalindromeTest {
    @Test
    public void mustGetFalseForNullString() {
        String input = null;
        CheckIfStringIsPalindrome checkIfStringIsPalindrome = new CheckIfStringIsPalindrome();
        assertFalse(checkIfStringIsPalindrome.isPalindrome(input));
    }

    @Test
    public void mustGetTrueForEmptyString() {
        String input = "";
        CheckIfStringIsPalindrome checkIfStringIsPalindrome = new CheckIfStringIsPalindrome();
        assertTrue(checkIfStringIsPalindrome.isPalindrome(input));
    }

    @Test
    public void mustGetTrueForOneCharacterString() {
        String input = "a";
        CheckIfStringIsPalindrome checkIfStringIsPalindrome = new CheckIfStringIsPalindrome();
        assertTrue(checkIfStringIsPalindrome.isPalindrome(input));
    }

    @Test
    public void mustGetTrueForAValidPalindrome() {
        String input = "abba";
        CheckIfStringIsPalindrome checkIfStringIsPalindrome = new CheckIfStringIsPalindrome();
        assertTrue(checkIfStringIsPalindrome.isPalindrome(input));
    }

    @Test
    public void mustGetFalseForInvalidPalindrome() {
        String input = "java";
        CheckIfStringIsPalindrome checkIfStringIsPalindrome = new CheckIfStringIsPalindrome();
        assertFalse(checkIfStringIsPalindrome.isPalindrome(input));
    }

    @Test
    public void mustGetTrueForCaseSensitiveValidPalindrome() {
        String input = "Abba";
        CheckIfStringIsPalindrome checkIfStringIsPalindrome = new CheckIfStringIsPalindrome();
        assertTrue(checkIfStringIsPalindrome.isPalindrome(input));
    }
}