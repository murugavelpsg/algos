package com.muru.problems.array;

/**
 * Created by msivagna on 12/23/16.
 */
public class MinDiffSummary {
    int array1Index;
    int array2Index;
    int minDiff;

    public MinDiffSummary() {
        this.array1Index = -1;
        this.array2Index = -1;
        this.minDiff = Integer.MAX_VALUE;
    }

    public int getArray1Index() {
        return array1Index;
    }

    public void setArray1Index(int array1Index) {
        this.array1Index = array1Index;
    }

    public int getArray2Index() {
        return array2Index;
    }

    public void setArray2Index(int array2Index) {
        this.array2Index = array2Index;
    }

    public int getMinDiff() {
        return minDiff;
    }

    public void setMinDiff(int minDiff) {
        this.minDiff = minDiff;
    }
}