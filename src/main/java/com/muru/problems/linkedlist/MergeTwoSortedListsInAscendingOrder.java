package com.muru.problems.linkedlist;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.linkedlist.LinkedList;
import com.muru.datastructures.linkedlist.List;

/**
 * Created by msivagna on 7/28/16.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the
 * first two lists.
 */
public class MergeTwoSortedListsInAscendingOrder {
    public List<Integer> mergeInAscendingOrder(List<Integer> list1,
                                               List<Integer> list2) {
        List<Integer> mergedList = new LinkedList<Integer>();
        Node<Integer> runner1 = list1.getHead();
        Node<Integer> runner2 = list2.getHead();

        while (runner1 != null && runner2 != null) {
            if (runner1.getData() <= runner2.getData()) {
                mergedList.add(runner1.getData());
                runner1 = runner1.getNext();
            } else {
                mergedList.add(runner2.getData());
                runner2 = runner2.getNext();
            }
        }

        while (runner1 != null) {
            mergedList.add(runner1.getData());
            runner1 = runner1.getNext();
        }

        while(runner2 != null) {
            mergedList.add(runner2.getData());
            runner2 = runner2.getNext();
        }

        return mergedList;
    }
}
