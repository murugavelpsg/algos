package com.muru.sorting;

import java.util.List;

/**
 * Sorts the input list in ascending order using selection sort algorithm
 * Created by msivagna on 3/7/16.
 */
public class SelectionSort<T extends Comparable<T>> {
    /**
     * Sorts the given inputlist in ascending order
     * @param inputList
     */
    public void sort(List<T> inputList) {
        for (int i = 0; i < inputList.size() - 1; i++) {
            T smallestNumber = inputList.get(i);
            int smallestNumberposition = i;
            for (int j = i + 1; j < inputList.size(); j++) {
                if (smallestNumber.compareTo(inputList.get(j)) > 0) {
                    smallestNumber = inputList.get(j);
                    smallestNumberposition = j;
                }
            }
            T temp = inputList.get(i);
            inputList.set(i, inputList.get(smallestNumberposition));
            inputList.set(smallestNumberposition, temp);
        }
    }
}
