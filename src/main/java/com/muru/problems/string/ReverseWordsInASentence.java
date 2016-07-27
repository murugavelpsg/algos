package com.muru.problems.string;

/**
 * Created by msivagna on 7/27/16.
 */

import org.apache.commons.lang.StringUtils;

/**
 * Write a function, which takes a String word and returns sentence on which words are reversed in order
 * Leading/Trailing spaces and multiple spaces between the words in a sentence are trimmed
 * e.g. if an input is "Java is best programming language",
 * the output should be "language programming best is Java".
 */
public class ReverseWordsInASentence {
    public String reverseWords(String input) {
        if (StringUtils.isEmpty(input)) {
            return input;
        }

        //Reverse the whole sentence
        String reversedInput = reverseString(input);
        //Find out each word and reverseWords them seperately
        String[] splitStrings = reversedInput.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < splitStrings.length - 1; i++) {
            if (!StringUtils.isEmpty(splitStrings[i])) {
                stringBuilder.append(reverseString(splitStrings[i]));
                stringBuilder.append(" ");
            }
        }
        stringBuilder.append(reverseString(splitStrings[splitStrings.length - 1]));
        return stringBuilder.toString();
    }

    private String reverseString(String input) {
        input = input.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0 ; i--) {
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }
}
