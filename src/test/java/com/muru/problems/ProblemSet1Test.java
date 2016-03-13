package com.muru.problems;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 3/13/16.
 */
public class ProblemSet1Test {
    ProblemSet1 problemSet1 = new ProblemSet1();

    /*
        START: PROBLEM SET 1
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
        END: PROBLEM SET 1
     */
}