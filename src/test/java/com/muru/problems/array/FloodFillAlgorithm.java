package com.muru.problems.array;

/**
 * In MS-Paint, when we take the brush to a pixel and click, the color of the region of that pixel is replaced
 * with a new selected color. Following is the problem statement to do this task.
 *
 * Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel and all
 * adjacent same colored pixels with the given color.
 * Created by Murugavel on 6/14/2016.
 */
public class FloodFillAlgorithm {
    public void fill(int[][] pixels, int xIndex, int yIndex, int newValue) {
        if (pixels == null) {
            return;
        }

        if (xIndex < 0 || yIndex < 0 || xIndex > pixels.length || yIndex > pixels[0].length) {
            throw new ArrayIndexOutOfBoundsException("Array Index out of bound exception");
        }

        fillHelper(pixels, xIndex, yIndex, pixels[xIndex][yIndex], newValue);
    }

    private void fillHelper(int[][] pixels, int xIndex, int yIndex, int oldValue, int newValue) {
        if (xIndex < 0 || yIndex < 0 || xIndex > pixels.length || yIndex > pixels[0].length) {
            return;
        }

        if (pixels[xIndex][yIndex] == oldValue) {
            pixels[xIndex][yIndex] = newValue;
            fillHelper(pixels, xIndex, yIndex - 1, oldValue, newValue);
            fillHelper(pixels, xIndex, yIndex + 1, oldValue, newValue);
            fillHelper(pixels, xIndex - 1, yIndex, oldValue, newValue);
            fillHelper(pixels, xIndex + 1, yIndex, oldValue, newValue);
        }
    }
}
