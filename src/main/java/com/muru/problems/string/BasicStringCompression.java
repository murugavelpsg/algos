package com.muru.problems.string;

import javax.xml.bind.ValidationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implement a method to perform basic string compression using the counts of repeated
 * characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * compressed string would not become smaller than the original string your method
 * should return the original string. You can assume the string has only upper and
 * lower case letters
 * Created by msivagna on 1/26/17.
 */
public class BasicStringCompression {
    public String compress(String input) throws ValidationException {
        StringBuilder builder = new StringBuilder();

        if (input == null || input.length() == 0) {
            return input;
        }

        checkIfStringHasOnlyLetters(input);

        Character previousCharacter = input.charAt(0);
        int characterCount = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == previousCharacter) {
                characterCount += 1;
            } else {
                builder.append(input.charAt(i - 1)).append(characterCount);
                characterCount = 1;
            }
            previousCharacter = input.charAt(i);
        }
        builder.append(previousCharacter).append(characterCount);
        String output = builder.toString();
        if (output.length() >= input.length()) {
            return input;
        } else {
            return output;
        }
    }

    private void checkIfStringHasOnlyLetters(String input) throws ValidationException {
        String pattern = "^[a-zA-z]+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);
        if (!m.matches()) {
            throw new ValidationException(String.format("Input String %s contains characters other than letters", input));
        }
    }
}
