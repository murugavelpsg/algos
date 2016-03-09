package com.muru.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msivagna on 3/8/16.
 */
public class MergeSort<T extends Comparable<T>> {
    public void sort(List<T> inputList) {
        if (inputList == null) {
            return;
        }
        sort(inputList, 0, inputList.size() - 1);
    }

    private void sort(List<T> inputList, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end)/2;
        sort(inputList, start, mid);
        sort(inputList, mid+1, end);
        merge(inputList, start, end);
    }

    private void merge(List<T> inputList, int start, int end) {
        int mid = (start + end) / 2;
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;
        List<T> resultList = new ArrayList<T>();
        while(start1 <= end1 && start2 <= end2) {
            if (inputList.get(start1).compareTo(inputList.get(start2)) <= 0) {
                resultList.add(inputList.get(start1));
                start1 += 1;
            } else {
                resultList.add(inputList.get(start2));
                start2 += 1;
            }
        }

        while (start1 <= end1) {
            resultList.add(inputList.get(start1));
            start1 += 1;
        }

        while(start2 <= end2) {
            resultList.add(inputList.get(start2));
            start2 += 1;
        }

        inputList.subList(start, end+1).clear();
        inputList.addAll(start, resultList);
    }
}
