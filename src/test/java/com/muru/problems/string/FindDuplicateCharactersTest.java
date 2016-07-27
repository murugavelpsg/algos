package com.muru.problems.string;

import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;


/**
 * Created by msivagna on 7/27/16.
 */
public class FindDuplicateCharactersTest {
    @Test
    public void mustGetEmptyHashMapForNullString() {
        String input = null;
        FindDuplicateCharacters findDuplicateCharacters = new FindDuplicateCharacters();
        Map<Character, Integer> output = findDuplicateCharacters.findDuplicateCharacters(input);
        assertEquals(output.size(), 0);
    }

    @Test
    public void mustGetEmptyHashMapForEmptyString() {
        String input = "";
        FindDuplicateCharacters findDuplicateCharacters = new FindDuplicateCharacters();
        Map<Character, Integer> output = findDuplicateCharacters.findDuplicateCharacters(input);
        assertEquals(output.size(), 0);
    }

    @Test
    public void mustGetEmptyHashMapForOneCharacterString() {
        String input = "a";
        FindDuplicateCharacters findDuplicateCharacters = new FindDuplicateCharacters();
        Map<Character, Integer> output = findDuplicateCharacters.findDuplicateCharacters(input);
        assertEquals(output.size(), 0);
    }

    @Test
    public void mustGetDuplicateCharacterAndCountForLowercaseString() {
        String input = "programming";
        FindDuplicateCharacters findDuplicateCharacters = new FindDuplicateCharacters();
        Map<Character, Integer> output = findDuplicateCharacters.findDuplicateCharacters(input);
        assertEquals(output.size(), 3);
        assertEquals(output.get('g'), new Integer(2));
        assertEquals(output.get('r'), new Integer(2));
        assertEquals(output.get('m'), new Integer(2));
    }

    @Test
    public void mustGetDuplicateCharacterAndCountForLowerAndUppercaseString() {
        String input = "ProGraMming";
        FindDuplicateCharacters findDuplicateCharacters = new FindDuplicateCharacters();
        Map<Character, Integer> output = findDuplicateCharacters.findDuplicateCharacters(input);
        assertEquals(output.size(), 1);
        assertEquals(output.get('r'), new Integer(2));
    }
}