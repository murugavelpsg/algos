package com.muru.problems.string;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example, "code" -> False, "aab" -> True, "carerac" -> True.
 * Created by msivagna on 12/20/16.
 */
public class PalindromePermutation {
    public boolean isPalindromePossible(String input) {
        if (StringUtils.isEmpty(input)) {
            return false;
        }

        Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (characterMap.get(input.charAt(i)) == null) {
                characterMap.put(input.charAt(i), 1);
            } else {
                characterMap.put(input.charAt(i), characterMap.get(input.charAt(i)) + 1);
            }
        }

        boolean isOddAlreadyPresent = false;
        for (Character key : characterMap.keySet()) {
            if (characterMap.get(key) % 2 == 1) {
                if (isOddAlreadyPresent) {
                    return false;
                }
                isOddAlreadyPresent = true;
            }
        }
        return true;
    }
}
