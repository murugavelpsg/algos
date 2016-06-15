package com.muru.problems.array;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Murugavel on 6/14/2016.
 */
public class FloodFillAlgorithmTest {
    @Test
    public void mustFailWhenInputIsNull() {
        int[][] pixels = null;
        FloodFillAlgorithm floodFillAlgorithm = new FloodFillAlgorithm();
        floodFillAlgorithm.fill(pixels, 100, 100, 2);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void mustFailWhenXAndYAreGreaterThanMaxIndex() {
        int[][] pixels = {
                {1, 2, 3, 5, 2, 1, 3},
                {1, 2, 2, 2, 1, 2, 3},
                {3, 2, 2, 2, 1, 3, 2},
                {4, 2, 4, 2, 4, 2, 1},
                {5, 1, 3, 2, 5, 1, 2},
                {1, 4, 2, 1, 1, 3, 5},
        };
        FloodFillAlgorithm floodFillAlgorithm = new FloodFillAlgorithm();
        floodFillAlgorithm.fill(pixels, 100, 100, 2);
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void mustFailWhenXAndYAreLessThanZero() {
        int[][] pixels = {
                {1, 2, 3, 5, 2, 1, 3},
                {1, 2, 2, 2, 1, 2, 3},
                {3, 2, 2, 2, 1, 3, 2},
                {4, 2, 4, 2, 4, 2, 1},
                {5, 1, 3, 2, 5, 1, 2},
                {1, 4, 2, 1, 1, 3, 5},
        };
        FloodFillAlgorithm floodFillAlgorithm = new FloodFillAlgorithm();
        floodFillAlgorithm.fill(pixels, -1, -1, 2);
    }

    @Test
    public void onlyOnePixelMustChange() {
        int[][] pixels = {
                {1, 2, 3, 5, 2, 1, 3},
                {1, 2, 2, 2, 1, 2, 3},
                {3, 2, 2, 2, 1, 3, 2},
                {4, 2, 4, 2, 4, 2, 1},
                {5, 1, 3, 2, 5, 1, 2},
                {1, 4, 2, 1, 1, 3, 5},
        };
        FloodFillAlgorithm floodFillAlgorithm = new FloodFillAlgorithm();
        floodFillAlgorithm.fill(pixels, 3, 4, 10);
        assertEquals(1, countPixels(pixels, 10));
        assertEquals(3, countPixels(pixels, 4));
    }

    @Test
    public void allPixelsWithInTheBoundaryMustChangeToTheGivenValue() {
        int[][] pixels = {
                {1, 1, 3, 5, 2, 1, 3},
                {1, 2, 2, 2, 1, 2, 3},
                {3, 2, 2, 2, 1, 3, 2},
                {4, 2, 4, 2, 4, 2, 1},
                {5, 1, 3, 2, 5, 1, 2},
                {1, 4, 2, 1, 1, 3, 5},
        };
        FloodFillAlgorithm floodFillAlgorithm = new FloodFillAlgorithm();
        floodFillAlgorithm.fill(pixels, 4, 3, 10);
        assertEquals(9, countPixels(pixels, 10));
        assertEquals(6, countPixels(pixels, 2));
    }

    private int countPixels(int[][] pixels, int pixelValue) {
        int count = 0;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[row].length; col++) {
                if (pixels[row][col] == pixelValue) {
                    count++;
                }
            }
        }
        return count;
    }
}