package com.muru.problems.array;

import java.util.List;

/**
 * Created by msivagna on 6/10/16.
 */
public class BestTimeToBuyAndSellStocks {
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
}
