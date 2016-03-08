package com.muru.sorting;

import java.util.List;

/**
 * Sort a given list in ascending order using insertion sort
 * Created by msivagna on 3/7/16.
 */
public class InsertionSort<T extends Comparable<T>> {
    /**
     * Sort a given list in ascending order
     * Algorithm
     *  - All the elements between 0 and i are sorted
     *  - Take the element i + 1
     *  - Find an appropriate place in the sorted sublist lets say k
     *  - Shift all the elements to the right until i + 1
     *  - Insert the i + 1 th element at kth position
     *  - Do this until the end of the list
     * @param inputList
     */
    public void sort(List<T> inputList) {
        for (int i = 0; i < inputList.size() - 1; i++) {
            T elementCurrentlySorted = inputList.get(i + 1);
            int position = i + 1;
            for (int j = i; j >= 0 && elementCurrentlySorted.compareTo(inputList.get(j)) <= 0; j--) {
                inputList.set(j+1, inputList.get(j));
                position = j;
            }
            inputList.set(position, elementCurrentlySorted);
        }
    }
}
