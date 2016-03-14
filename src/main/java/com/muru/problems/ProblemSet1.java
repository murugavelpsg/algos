package com.muru.problems;

import java.util.*;

/**
 * Created by msivagna on 3/13/16.
 */
public class ProblemSet1 {
    public class StockReport {
        int buyIndex;
        int sellIndex;
        int maxProfit;

        public StockReport() {
            buyIndex = -1;
            sellIndex = -1;
            maxProfit = 0;
        }

        public int getBuyIndex() {
            return buyIndex;
        }

        public void setBuyIndex(int buyIndex) {
            this.buyIndex = buyIndex;
        }

        public int getSellIndex() {
            return sellIndex;
        }

        public void setSellIndex(int sellIndex) {
            this.sellIndex = sellIndex;
        }

        public int getMaxProfit() {
            return maxProfit;
        }

        public void setMaxProfit(int maxProfit) {
            this.maxProfit = maxProfit;
        }
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

     If you were only permitted to buy one share of the stock and sell one share of the stock,
     design an algorithm to find the best times to buy and sell.
     * @param inputList
     * @return
     */
    public StockReport getBestTimeToBuyAndSellStock(List<Integer> inputList) {
        StockReport stockReport = new StockReport();
        Integer minIndex = 0;
        Integer maxProfit = 0;
        for (int i = 0; i < inputList.size(); i++) {
            //Iterate through each element in the list
            //Check if the inputList[i] is less than minIndex
            //If yes update the current minimum
            //Calculate the running difference
            //If it is greater than maxSum then update min, max and maxDiff
            if (inputList.get(i) < inputList.get(minIndex)) {
                minIndex = i;
            }
            maxProfit = inputList.get(i) - inputList.get(minIndex);
            if (maxProfit > stockReport.getMaxProfit()) {
                stockReport.setBuyIndex(minIndex);
                stockReport.setSellIndex(i);
                stockReport.setMaxProfit(maxProfit);
            }
        }
        return stockReport;
    }

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
