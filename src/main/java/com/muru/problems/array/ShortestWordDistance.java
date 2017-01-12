package com.muru.problems.array;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

 Word1 may be equal to word2 and both the words may or may not be present in the list.

 * Created by msivagna on 12/31/16.
 */
public class ShortestWordDistance {
    public int calculateDistance(String[] words, String word1, String word2) throws ValidationException {
        if (words == null || words.length < 2) {
            throw new ValidationException(String.format("Insufficient set of words (length = %d) to find the distance",
                                                        (words == null? 0 : words.length)));
        }

        if (StringUtils.isEmpty(word1) || StringUtils.isEmpty(word2)) {
            throw new ValidationException("Input word is either null or empty.");
        }

        Map<String, List<Integer>> wordIndexList = composeWordIndexList(words);

        if (word1.equals(word2)) {
            List<Integer> word1Indices = wordIndexList.get(word1);
            if (word1Indices == null) {
                return -1;
            }

            if (word1Indices.size() == 1) {
                return 0;
            }

            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < word1Indices.size() - 1; i++) {
                int currentDiff = Math.abs(word1Indices.get(i + 1)) - Math.abs(word1Indices.get(i));
                if (currentDiff < minDiff) {
                    minDiff = currentDiff;
                }
            }
            return minDiff;
        } else {
            List<Integer> word1Indices = wordIndexList.get(word1);
            List<Integer> word2Indices = wordIndexList.get(word2);
            if (word1Indices == null || word2Indices == null) {
                return -1;
            }

            MinDifferenceBetweenTwoSortedArrays minDifference = new MinDifferenceBetweenTwoSortedArrays();
            MinDiffSummary minDiffSummary = minDifference.calculateDifference(word1Indices.toArray(new Integer[word1Indices.size()]),
                                                                              word2Indices.toArray(new Integer[word2Indices.size()])
            );
            return minDiffSummary.getMinDiff();
        }

    }

    private Map<String, List<Integer>> composeWordIndexList(String[] words) {
        Map<String, List<Integer>> wordIndexMap = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (wordIndexMap.get(words[i]) == null) {
                wordIndexMap.put(words[i], new ArrayList<Integer>());
            }
            List<Integer> wordIndexList = wordIndexMap.get(words[i]);
            wordIndexList.add(i);
        }
        return wordIndexMap;
    }
}
