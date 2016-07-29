package com.muru.problems.linkedlist;

import com.muru.datastructures.linkedlist.LinkedList;
import com.muru.datastructures.linkedlist.List;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 7/28/16.
 */
public class MergeTwoSortedListsInAscendingOrderTest {
    @Test
    public void mustGetEmptyListWhenTwoListsAreEmpty() {
        MergeTwoSortedListsInAscendingOrder mergeTwoSortedListsInAscendingOrder =
                new MergeTwoSortedListsInAscendingOrder();
        List<Integer> list1 = new LinkedList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();
        List<Integer> mergedList = mergeTwoSortedListsInAscendingOrder.mergeInAscendingOrder(list1, list2);
        assertEquals(mergedList.size(), list1.size() + list2.size());
    }

    @Test
    public void mustGetTheOtherListWhenOneOfTheListIsEmpty() {
        MergeTwoSortedListsInAscendingOrder mergeTwoSortedListsInAscendingOrder =
                new MergeTwoSortedListsInAscendingOrder();
        List<Integer> list1 = new LinkedList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(2);
        list2.add(3);
        list2.add(10);
        list2.add(12);
        list2.add(15);
        List<Integer> mergedList = mergeTwoSortedListsInAscendingOrder.mergeInAscendingOrder(list1, list2);
        assertEquals(mergedList.size(), list1.size() + list2.size());
    }

    @Test
    public void mustGetTheMergedListsInAscendingOrder() {
        MergeTwoSortedListsInAscendingOrder mergeTwoSortedListsInAscendingOrder =
                new MergeTwoSortedListsInAscendingOrder();
        List<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(7);
        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(2);
        list2.add(3);
        list2.add(10);
        list2.add(12);
        list2.add(15);
        List<Integer> mergedList = mergeTwoSortedListsInAscendingOrder.mergeInAscendingOrder(list1, list2);
        assertEquals(mergedList.size(), list1.size() + list2.size());
        assertEquals(mergedList.remove(), new Integer(1));
        assertEquals(mergedList.remove(), new Integer(2));
        assertEquals(mergedList.remove(), new Integer(3));
        assertEquals(mergedList.remove(), new Integer(4));
        assertEquals(mergedList.remove(), new Integer(5));
        assertEquals(mergedList.remove(), new Integer(7));
        assertEquals(mergedList.remove(), new Integer(10));
        assertEquals(mergedList.remove(), new Integer(12));
        assertEquals(mergedList.remove(), new Integer(15));
        assertEquals(mergedList.size(), 0);
    }

    @Test
    public void mustMergeOneElemListAndMultipleElemInAscendingOrder() {
        MergeTwoSortedListsInAscendingOrder mergeTwoSortedListsInAscendingOrder =
                new MergeTwoSortedListsInAscendingOrder();
        List<Integer> list1 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(7);
        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(2);
        List<Integer> mergedList = mergeTwoSortedListsInAscendingOrder.mergeInAscendingOrder(list1, list2);
        assertEquals(mergedList.size(), list1.size() + list2.size());
        assertEquals(mergedList.remove(), new Integer(1));
        assertEquals(mergedList.remove(), new Integer(2));
        assertEquals(mergedList.remove(), new Integer(4));
        assertEquals(mergedList.remove(), new Integer(5));
        assertEquals(mergedList.remove(), new Integer(7));
        assertEquals(mergedList.size(), 0);
    }
}