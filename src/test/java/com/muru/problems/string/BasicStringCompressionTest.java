package com.muru.problems.string;

import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 1/26/17.
 */
public class BasicStringCompressionTest {
    @Test
    public void mustGetCompressedString() throws ValidationException {
        String input = "aabcccccaaa";
        BasicStringCompression basicStringCompression = new BasicStringCompression();
        String actualOutput = basicStringCompression.compress(input);
        String expectedOutput = "a2b1c5a3";
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetOriginalStringWhenItCannotBeCompressed() throws ValidationException {
        String input = "abcd";
        BasicStringCompression basicStringCompression = new BasicStringCompression();
        String actualOutput = basicStringCompression.compress(input);
        String expectedOutput = "abcd";
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetOriginalStringWhenCompressedStringLengthEqualsOriginal() throws ValidationException {
        String input = "aabbccdd";
        BasicStringCompression basicStringCompression = new BasicStringCompression();
        String actualOutput = basicStringCompression.compress(input);
        String expectedOutput = "aabbccdd";
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetNullIfInputIsNull() throws ValidationException {
        String input = null;
        BasicStringCompression basicStringCompression = new BasicStringCompression();
        String actualOutput = basicStringCompression.compress(input);
        String expectedOutput = null;
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetEmptyIfInputIsEmpty() throws ValidationException {
        String input = "";
        BasicStringCompression basicStringCompression = new BasicStringCompression();
        String actualOutput = basicStringCompression.compress(input);
        String expectedOutput = "";
        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void mustGetOriginalStringIfTheInputIsOneCharacter() throws ValidationException {
        String input = "a";
        BasicStringCompression basicStringCompression = new BasicStringCompression();
        String actualOutput = basicStringCompression.compress(input);
        String expectedOutput = "a";
        assertEquals(actualOutput, expectedOutput);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfTheInputHasAnythingOtherThanAlphabets() throws ValidationException {
        String input = "a2bc32#";
        BasicStringCompression basicStringCompression = new BasicStringCompression();
        String actualOutput = basicStringCompression.compress(input);
        assertTrue(false);
    }
}