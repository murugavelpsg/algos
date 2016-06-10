package com.muru.problems.dynamicprogramming;

import java.util.List;

/**
 * Created by msivagna on 3/8/16.
 */
public class MaxSumOfContiguousSequence {
    public class MaxSumInfo {
        private int start;
        private int end;
        private int maxSum;

        public MaxSumInfo() {
            this.start = 0;
            this.end = 0;
            this.maxSum = 0;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getMaxSum() {
            return maxSum;
        }

        public void setMaxSum(int maxSum) {
            this.maxSum = maxSum;
        }
    }

    /**
     * Given a sequence of n real numbers A(1) ... A(n), determine a contiguous subsequence A(i) ... A(j)
     * for which the sum of elements in the subsequence is maximized.
     * NOTE: Will work only for array with a mix of positive and negative numbers.
     * @return
     */
    public MaxSumInfo maximumSumOfContiguousSubsequence(List<Integer> inputList) {
        MaxSumInfo maxSumInfo = new MaxSumInfo();
        int runningSum = 0;
        int startOfSequence = 0;
        for (int i = 0; i < inputList.size(); i++) {
            runningSum = runningSum + inputList.get(i);
            if (runningSum > 0) {
                if (runningSum <= inputList.get(i)) {
                    runningSum = inputList.get(i);
                    startOfSequence = i;
                }
            } else {
                runningSum = 0;
            }

            //If running sum is greater than maxSum then update the maxsum
            if (runningSum > maxSumInfo.getMaxSum()) {
                maxSumInfo.setMaxSum(runningSum);
                maxSumInfo.setStart(startOfSequence);
                maxSumInfo.setEnd(i);
            }
        }
        return maxSumInfo;
    }
}
