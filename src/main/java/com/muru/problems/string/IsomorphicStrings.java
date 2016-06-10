package com.muru.problems.string;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msivagna on 6/10/16.
 */
public class IsomorphicStrings {
    /**
     * Problem 2:
     *
     * Two words are called isomorphic if the letters in one word can be remapped to get the second word.
     Remapping a letter means replacing all occurrences of it with another letter. The ordering of the letters remains unchanged.
     No two letters may map to the same letter, but a letter may map to itself.
     For example, the words "abca" and "zbxz" are isomorphic because we can map 'a' to 'z', 'b' to 'b' and 'c' to 'x'.

     Given a String[] words, return how many (unordered) pairs of words are isomorphic.
     * @param word1
     * @param word2
     * @return
     */
    public boolean areWordsIsomorphic(String word1, String word2) {
        Map<Character, Character> characterMap = new HashMap<Character, Character>();
        if (word1 == null || word2 == null) {
            return false;
        }

        if (word1.length() != word2.length()) {
            return false;
        }

        for (int i = 0; i < word1.length(); i++) {
            //If character doesn't exist in the map then add the value to map unless a letter already maps to it already
            //If it exists check if the mapping is correct.
            //  - If yes continue until the end of string
            //  - If not return false
            if (!characterMap.containsKey(word1.charAt(i))) {
                Collection<Character> values = characterMap.values();
                if (values.contains(word2.charAt(i))) {
                    return false;
                }
                characterMap.put(word1.charAt(i), word2.charAt(i));
            } else {
                Character mappedValue = characterMap.get(word1.charAt(i));
                if (!mappedValue.equals(word2.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
