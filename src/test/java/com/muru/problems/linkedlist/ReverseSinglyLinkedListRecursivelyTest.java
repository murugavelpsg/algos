package com.muru.problems.linkedlist;

import com.muru.datastructures.linkedlist.LinkedList;
import com.muru.datastructures.linkedlist.List;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 7/29/16.
 */
public class ReverseSinglyLinkedListRecursivelyTest {
    @Test
    public void mustGetExceptionIfTheInputIsNull() {
        ReverseSinglyLinkedListRecursively<Integer> reverseList = new ReverseSinglyLinkedListRecursively();
        List<Integer> list = null;
        reverseList.reverse(list);
    }

    @Test
    public void mustGetEmptyListIfTheInputListIsEmpty() {
        ReverseSinglyLinkedListRecursively<Integer> reverseList = new ReverseSinglyLinkedListRecursively();
        List<Integer> list = new LinkedList<Integer>();
        reverseList.reverse(list);
        assertEquals(list.size(), 0);
    }

    @Test
    public void mustGetSameListIfTheInputListHasOneElement() {
        ReverseSinglyLinkedListRecursively<Integer> reverseList = new ReverseSinglyLinkedListRecursively();
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        reverseList.reverse(list);
        assertEquals(list.size(), 1);
    }

    @Test
    public void mustGetReversedListIfTheInputListIsNotEmpty() {
        ReverseSinglyLinkedListRecursively<Integer> reverseList = new ReverseSinglyLinkedListRecursively();
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(2));
        list.add(new Integer(6));
        list.add(new Integer(7));
        list.add(new Integer(10));
        list.add(new Integer(5));
        reverseList.reverse(list);
        assertEquals(list.size(), 7);
        assertEquals(list.remove(), new Integer(5));
        assertEquals(list.remove(), new Integer(10));
        assertEquals(list.remove(), new Integer(7));
        assertEquals(list.remove(), new Integer(6));
        assertEquals(list.remove(), new Integer(2));
        assertEquals(list.remove(), new Integer(3));
        assertEquals(list.remove(), new Integer(1));
        assertEquals(list.size(), 0);
    }
}