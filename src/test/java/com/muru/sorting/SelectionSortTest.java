package com.muru.sorting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 3/8/16.
 */
public class SelectionSortTest {
    public SelectionSort<Integer> selectionSort;

    @BeforeClass
    public void setup() {
        selectionSort = new SelectionSort<Integer>();
    }

    private List<Integer> generateRandomList() {
        //Generate a list of random numbers between 0 and 9
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

    @Test
    public void mustSuccessfullySortARandomlySortedList() {
        List<Integer> numbers = generateRandomList();
        List<Integer> expectedSortedNumbers = new ArrayList<Integer>(numbers);
        Collections.sort(expectedSortedNumbers);
        selectionSort.sort(numbers);
        assertEquals(numbers, expectedSortedNumbers);
    }

    @Test
    public void mustSuccessfullySortAPreSortedList() {
        List<Integer> numbers = generateRandomList();
        List<Integer> expectedSortedNumbers = new ArrayList<Integer>(numbers);
        Collections.sort(expectedSortedNumbers);
        Collections.sort(numbers);
        selectionSort.sort(numbers);
        assertEquals(numbers, expectedSortedNumbers);
    }

    @Test
    public void mustSuccessfullySortAReverseSortedList() {
        List<Integer> numbers = generateRandomList();
        List<Integer> expectedSortedNumbers = new ArrayList<Integer>(numbers);
        Collections.sort(expectedSortedNumbers);
        Collections.sort(numbers);
        Collections.reverse(numbers);
        selectionSort.sort(numbers);
        assertEquals(numbers, expectedSortedNumbers);
    }
}