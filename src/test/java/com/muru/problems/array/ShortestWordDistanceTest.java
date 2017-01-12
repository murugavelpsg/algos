package com.muru.problems.array;

import org.testng.annotations.Test;

import javax.xml.bind.ValidationException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 12/31/16.
 */
public class ShortestWordDistanceTest {
    @Test
    public void mustGetTheCorrectDistanceForCloserWords() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = "shortest";
        String word2 = "delta";
        int expectedDistance = 1;
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
        assertEquals(actualDistance, expectedDistance);
    }

    @Test
    public void mustGetCorrectDistanceForFarApartWords() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = "tango";
        String word2 = "word";
        int expectedDistance = 10;
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
        assertEquals(actualDistance, expectedDistance);
    }

    @Test
    public void mustGetNegOneIfOneWordDoesnotExist() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = "shortest";
        String word2 = "romeo";
        int expectedDistance = -1;
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
        assertEquals(actualDistance, expectedDistance);
    }

    @Test
    public void mustGetNegOneIfBothWordsDonotExist() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = "pica";
        String word2 = "romeo";
        int expectedDistance = -1;
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
        assertEquals(actualDistance, expectedDistance);
    }

    @Test
    public void mustGetDistanceIfTheWordsAreSame() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = "practice";
        String word2 = "practice";
        int expectedDistance = 7;
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
        assertEquals(actualDistance, expectedDistance);
    }

    @Test
    public void mustGetNegOneIfTheWordsAreSameAndTheyAreAbsent() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = "abc";
        String word2 = "abc";
        int expectedDistance = -1;
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
        assertEquals(actualDistance, expectedDistance);
    }

    @Test
    public void mustGetZeroIfTheWordsAreSameAndOccursOnce() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = "delta";
        String word2 = "delta";
        int expectedDistance = 0;
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
        assertEquals(actualDistance, expectedDistance);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfTheInputWordListIsEmpty() throws ValidationException {
        String[] words = {};
        String word1 = "pica";
        String word2 = "delta";
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfOneInputIsNull() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = null;
        String word2 = "delta";
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfOneInputIsEmpty() throws ValidationException {
        String[] words = {"shortest", "word", "distance", "practice", "makes", "perfect", "coding", "makes", "distance",
                "alpha", "practice", "tango", "delta", "shortest"};
        String word1 = "shortest";
        String word2 = "";
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfTheInputWordListIsOfLengthOne() throws ValidationException {
        String[] words = {"alpha"};
        String word1 = "pica";
        String word2 = "delta";
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void mustFailIfTheInputWordListIsNull() throws ValidationException {
        String[] words = null;
        String word1 = "pica";
        String word2 = "delta";
        ShortestWordDistance shortestWordDistance = new ShortestWordDistance();
        int actualDistance = shortestWordDistance.calculateDistance(words, word1, word2);
    }
}