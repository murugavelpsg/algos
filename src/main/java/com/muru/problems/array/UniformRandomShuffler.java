package com.muru.problems.array;

import java.util.Random;

/**
 * Algorithm is based on improved version of Fisher-Yates Shuffle
 * Created by msivagna on 9/3/16.
 */
public class UniformRandomShuffler<T extends Comparable<T>> {
    public Comparable[] shuffle(Comparable[] input) {
        if (input == null) {
            return null;
        }
        Comparable[] shuffledOutput = new Comparable[input.length];
        System.arraycopy(input, 0, shuffledOutput, 0, input.length);
        /* Pick an index k between 0 and n-1-m. Shuffle until one element remains
            where
                n is the size of the unshuffled part of the array
                m is the size of the shuffled part of the array
           At each iteration swap the element at the index k with element at n - m
        */
        for (int m = shuffledOutput.length - 1; m > 0; m--) {
            int k = new Random().nextInt(m);
            swap(shuffledOutput, k, m);
        }
        return shuffledOutput;
    }

    private void swap(Comparable[] shuffledOutput, int k, int m) {
        Comparable temp = shuffledOutput[k];
        shuffledOutput[k] = shuffledOutput[m];
        shuffledOutput[m] = temp;
    }
}
