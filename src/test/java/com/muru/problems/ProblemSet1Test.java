package com.muru.problems;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 3/13/16.
 */
public class ProblemSet1Test {
    ProblemSet1 problemSet1 = new ProblemSet1();

    /*
        START: PROBLEM 1
     */
    @Test
    public void mustSuccessfullyGetMinAndMaxStockIndex() {
        List<Integer> stockList = Arrays.asList(10, 3, 2, 4, 1, 3, 5, 3, 16, 6);
        ProblemSet1.StockReport stockReport = problemSet1.getBestTimeToBuyAndSellStock(stockList);
        assertEquals(stockReport.getBuyIndex(), 4);
        assertEquals(stockReport.getSellIndex(), 8);
        assertEquals(stockReport.getMaxProfit(), 15);
    }

    @Test
    public void mustSuccessfullyGetResultForAStockThatIsAlwaysDecreasing() {
        List<Integer> stockList = Arrays.asList(100, 99, 88, 77, 66, 55, 44, 33, 22, 11);
        ProblemSet1.StockReport stockReport = problemSet1.getBestTimeToBuyAndSellStock(stockList);
        assertEquals(stockReport.getBuyIndex(), -1);
        assertEquals(stockReport.getSellIndex(), -1);
        assertEquals(stockReport.getMaxProfit(), 0);
    }

    @Test
    public void mustSuccessfullyGetResultForAStockThatIsIncreasing() {
        List<Integer> stockList = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 100);
        ProblemSet1.StockReport stockReport = problemSet1.getBestTimeToBuyAndSellStock(stockList);
        assertEquals(stockReport.getBuyIndex(), 0);
        assertEquals(stockReport.getSellIndex(), 9);
        assertEquals(stockReport.getMaxProfit(), 89);
    }

    @Test
    public void mustSuccessfullyGetResultForAStockThatIsAlwaysConstant() {
        List<Integer> stockList = Arrays.asList(11, 11, 11, 11, 11, 11, 11, 11, 11, 11);
        ProblemSet1.StockReport stockReport = problemSet1.getBestTimeToBuyAndSellStock(stockList);
        assertEquals(stockReport.getBuyIndex(), -1);
        assertEquals(stockReport.getSellIndex(), -1);
        assertEquals(stockReport.getMaxProfit(), 0);
    }
    /*
        END: PROBLEM 1
     */
    /*
        START: PROBLEM 2
     */
    @Test
    public void mustReturnSuccessForIsomorphicStrings() {
        String word1 = "abca";
        String word2 = "zbxz";
        assertTrue(problemSet1.areWordsIsomorphic(word1, word2));
    }

    @Test
    public void mustReturnFailureForNonIsomorphicStringsWithTwoLettersMappingToSameValue() {
        String word1 = "abcadaf";
        String word2 = "zbxzdrg";
        assertFalse(problemSet1.areWordsIsomorphic(word1, word2));
    }

    @Test
    public void mustReturnFailureForNonIsomorphicStrings() {
        String word1 = "abca";
        String word2 = "zbss";
        assertFalse(problemSet1.areWordsIsomorphic(word1, word2));
    }

    @Test
    public void mustReturnFailureIfStringsAreOfDifferentLength() {
        String word1 = "abca";
        String word2 = "zbszasdf";
        assertFalse(problemSet1.areWordsIsomorphic(word1, word2));
    }

    @Test
    public void mustReturnFailureIfOneOfTheStringIsNull() {
        String word1 = "abca";
        String word2 = null;
        assertFalse(problemSet1.areWordsIsomorphic(word1, word2));
    }
    /*
        END: PROBLEM 2
     */
}