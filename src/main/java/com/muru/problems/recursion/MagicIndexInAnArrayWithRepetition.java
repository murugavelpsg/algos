package com.muru.problems.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 6/10/16.
 */
public class MagicIndexInAnArrayWithRepetition {
    private static final Logger LOGGER = LoggerFactory.getLogger(MagicIndexInAnArrayWithRepetition.class);

    public Integer findMagicIndexWithRepetition(List<Integer> inputList) {
        return findMagicIndexWithRepetition(inputList, 0, inputList.size() - 1);
    }

    /**
     * Followup of Problem-1:
     * Find the magic index when the elements are repeating.
     * @param inputList
     * @param start
     * @param end
     * @return
     */
    private Integer findMagicIndexWithRepetition(List<Integer> inputList, int start, int end) {
        if (start > end) {
            throw new NoSuchElementException();
        }

        int mid = (start + end) / 2;

        if (inputList.get(mid).compareTo(mid) == 0) {
            return mid;
        }

        //Since the list repeats we don't know on which side the magic index is. So search both sides
        try {
            int leftIndex = Math.min(inputList.get(mid), mid-1);
            return findMagicIndexWithRepetition(inputList, start, leftIndex);
        } catch (NoSuchElementException e) {
            LOGGER.debug("Element not found on the left hand side of the input list");
        }

        //Search the right side
        int rightIndex = Math.max(inputList.get(mid), mid+1);
        return findMagicIndexWithRepetition(inputList, rightIndex, end);
    }
}
