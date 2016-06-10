package com.muru.problems.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 6/10/16.
 */
public class MagicIndexInAnArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(MagicIndexInAnArray.class);

    /**
     * Problem-1
     * Problem statement: A magic index in an array A[0 ... n-1] is defined to be an index such that A[i] = i.
     * Given a sorted array of distinct integers, write a method to find a magic
     * index, if one exists in array A.
     * @param inputList
     * @return
     */
    public Integer findMagicIndex(List<Integer> inputList) {
        return findMagicIndex(inputList, 0, inputList.size() - 1);
    }

    private Integer findMagicIndex(List<Integer> inputList, int start, int end) {
        if (start > end) {
            throw new NoSuchElementException();
        }
        int mid = (start + end)/2;
        if (inputList.get(mid).compareTo(mid) == 0) {
            return mid;
        } else if (inputList.get(mid).compareTo(mid) > 0){
            return findMagicIndex(inputList, start, mid - 1);
        } else {
            return findMagicIndex(inputList, mid + 1, end);
        }
    }
}
