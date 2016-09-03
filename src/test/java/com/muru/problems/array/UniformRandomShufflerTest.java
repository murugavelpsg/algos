package com.muru.problems.array;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by msivagna on 9/3/16.
 */
public class UniformRandomShufflerTest {
    @Test
    public void mustGetNullIfInputIsNull() {
        UniformRandomShuffler<Integer> shuffler = new UniformRandomShuffler<Integer>();
        Integer[] input = null;
        Comparable[] output = shuffler.shuffle(input);
        assertEquals(output, null);
    }

    @Test
    public void mustGetEmptyArrayIfInputIsEmpty() {
        UniformRandomShuffler<Integer> shuffler = new UniformRandomShuffler<Integer>();
        Integer[] input = new Integer[0];
        Comparable[] output = shuffler.shuffle(input);
        assertEquals(output, new Integer[0]);
    }

    @Test
    public void mustGetShuffledOutputForOneElementArray() {
        UniformRandomShuffler<Integer> shuffler = new UniformRandomShuffler<Integer>();
        Integer[] input = {1};
        Comparable[] output = shuffler.shuffle(input);
        assertEquals(output, input);
    }

    @Test
    public void mustGetShuffledOutput() {
        UniformRandomShuffler<Integer> shuffler = new UniformRandomShuffler<Integer>();
        Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Comparable[] output = shuffler.shuffle(input);
        assertNotEquals(output, input);
    }
}