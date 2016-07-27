package com.muru.problems.string;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by msivagna on 7/27/16.
 */
public class ReverseWordsInASentenceTest {
    @Test
    public void mustGetNullWhenInputIsNull() {
        String input = null;
        ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();
        String output = reverseWordsInASentence.reverseWords(input);
        assertNull(output);
    }

    @Test
    public void mustGetEmptyStringWhenInputIsEmpty() {
        String input = "";
        ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();
        String output = reverseWordsInASentence.reverseWords(input);
        assertEquals(output.length(), input.length());
        assertEquals(output, "");
    }

    @Test
    public void mustGetInputStringWhenInputSentenceHasOneWord() {
        String input = "sentence";
        ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();
        String output = reverseWordsInASentence.reverseWords(input);
        assertEquals(output.length(), input.length());
        assertEquals(output, input);
    }

    @Test
    public void mustGetReversedSentence() {
        String input = "reverse words in a sentence";
        ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();
        String output = reverseWordsInASentence.reverseWords(input);
        assertEquals(output.length(), input.length());
        assertEquals(output, "sentence a in words reverse");
    }

    @Test
    public void mustGetReversedSentenceWithMultipleSpaces() {
        String input = "reverse words    in a   sentence";
        ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();
        String output = reverseWordsInASentence.reverseWords(input);
        assertEquals(output.length(), input.length() - 5);
        assertEquals(output, "sentence a in words reverse");
    }

    @Test
    public void mustGetReversedSentenceWithoutLeadingSpaces() {
        String input = "   reverse words    in a   sentence";
        ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();
        String output = reverseWordsInASentence.reverseWords(input);
        assertEquals(output.length(), input.length() - 8);
        assertEquals(output, "sentence a in words reverse");
    }

    @Test
    public void mustGetReversedSentenceWithoutTrailingSpaces() {
        String input = "reverse words    in a   sentence   ";
        ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();
        String output = reverseWordsInASentence.reverseWords(input);
        assertEquals(output.length(), input.length() - 8);
        assertEquals(output, "sentence a in words reverse");
    }
}