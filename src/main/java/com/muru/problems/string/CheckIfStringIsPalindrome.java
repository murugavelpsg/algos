package com.muru.problems.string;

/**
 * Created by msivagna on 7/27/16.
 * Given a string, write a c function to check if it is palindrome or not.
 A string is said to be palindrome if reverse of the string is same as string.
 The method should ignore the case sensitive string
 For example, “abba” is palindrome, but “abbc” is not palindrome.
 */
public class CheckIfStringIsPalindrome {
    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        if (input.length() <= 1) {
            return true;
        }
        String lowerCaseInput = input.toLowerCase();
        int maxLength = lowerCaseInput.length() - 1;
        for (int i = 0; i < lowerCaseInput.length(); i++) {
            if (lowerCaseInput.charAt(i) != lowerCaseInput.charAt(maxLength - i)) {
                return false;
            }
        }
        return true;
    }
}
