package com.muru.sorting;

import java.util.List;

/**
 * Sorts a given list in ascending order using bubble sort algorithm
 * Created by msivagna on 3/7/16.
 */
public class BubbleSort<T extends Comparable<T>> {

    /**
     * Sort a given list in ascending order
     * @param inputList
     */
    public void sort(List<T> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = 0; j < inputList.size() - i - 1 ; j++) {
                if (inputList.get(j).compareTo(inputList.get(j + 1)) > 0) {
                    T temp = inputList.get(j);
                    inputList.set(j, inputList.get(j+1));
                    inputList.set(j+1, temp);
                }
            }
        }
    }
}
