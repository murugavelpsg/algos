package com.muru.problems.string;

/**
 * Created by msivagna on 7/27/16.
 */

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * You need to write a program to print all duplicate character and their count in Java.
 * String inputs are case sensitive
 * For example if given String is "Programming" then your program should print
     g : 2
     r : 2
     m : 2
 */
public class FindDuplicateCharacters {
    public Map<Character, Integer> findDuplicateCharacters(String input) {
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        if (!StringUtils.isEmpty(input)) {
            for (int i = 0; i < input.length(); i++) {
                Character c = input.charAt(i);
                Integer charCount;
                if ((charCount = charCountMap.get(c)) != null) {
                    charCount += 1;
                } else {
                    charCount = 1;
                }
                charCountMap.put(c, charCount);
            }
        }
        Map<Character, Integer> finalCharCountMap = new HashMap<Character, Integer>();
        for (Character c : charCountMap.keySet()) {
            if (charCountMap.get(c) > 1) {
                finalCharCountMap.put(c, charCountMap.get(c));
            }
        }
        return finalCharCountMap;
    }
}
