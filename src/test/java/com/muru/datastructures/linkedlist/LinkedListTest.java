package com.muru.datastructures.linkedlist;

import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 4/30/16.
 */
public class LinkedListTest {
    @Test
    public void checkIfElementIsAddedToList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(10));
        assertEquals(list.size(), 1);
        list.add(new Integer(20));
        assertEquals(list.size(), 2);
        list.add(new Integer(20));
        assertEquals(list.size(), 3);
    }

    @Test
    public void checkIfElementIsRemovedFromList() {
        List<Integer> list = new LinkedList<Integer>();
        Integer elemAdded = new Integer(10);
        list.add(elemAdded);
        Integer elemRemoved = list.remove();
        assertEquals(elemRemoved, elemAdded);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionWhenRemovedFromEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        list.remove();
    }

    @Test
    public void checkIfSizeMethodWorks() {
        List<Integer> list = new LinkedList<Integer>();
        assertEquals(list.size(), 0);
        list.add(new Integer(10));
        list.add(new Integer(20));
        assertEquals(list.size(), 2);
        list.remove();
        assertEquals(list.size(), 1);
        list.remove();
        assertEquals(list.size(), 0);
    }
}