package com.muru.problems.array;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 * Created by msivagna on 1/12/17.
 */
public class MoveZerosInPlace {
    public void doMoveZeros(Integer[] input) {
        if (input == null || input.length <= 1) {
            return;
        }

        int currentIndex = -1;
        int runner = 0;
        //Move all the non zero elements to the front
        while (runner < input.length) {
            if (input[runner] != 0) {
                currentIndex += 1;
                input[currentIndex] = input[runner];
            }
            runner++;
        }

        // fill the rest of the array with zero
        currentIndex += 1;
        while (currentIndex < input.length) {
            input[currentIndex] = 0;
            currentIndex += 1;
        }
    }
}
