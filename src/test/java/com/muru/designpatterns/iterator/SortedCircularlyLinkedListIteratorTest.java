package com.muru.designpatterns.iterator;

import com.muru.datastructures.linkedlist.List;
import com.muru.datastructures.linkedlist.SortedCircularlyLinkedList;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

/**
 * Created by msivagna on 8/3/16.
 */
public class SortedCircularlyLinkedListIteratorTest {
    @Test
    public void hasNextMustReturnFalseIfTheListIsEmpty() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        Iterator<Integer> listIterator = new SortedCircularlyLinkedListIterator<Integer>(list);
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void hasNextMustReturnTrueIfTheHasAtLeastOneElement() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(100);
        Iterator<Integer> listIterator = new SortedCircularlyLinkedListIterator<Integer>(list);
        assertTrue(listIterator.hasNext());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void nextShouldThrowExceptionIfTheListIsEmpty() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        Iterator<Integer> listIterator = new SortedCircularlyLinkedListIterator<Integer>(list);
        listIterator.next();
    }

    @Test
    public void nextShouldReturnTheNextElementInTheList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(10);
        list.add(40);
        list.add(20);
        list.add(30);
        Iterator<Integer> listIterator = new SortedCircularlyLinkedListIterator<Integer>(list);
        assertEquals(listIterator.next(), new Integer(10));
        assertEquals(listIterator.next(), new Integer(20));
        assertEquals(listIterator.next(), new Integer(30));
        assertEquals(listIterator.next(), new Integer(40));
        try {
            listIterator.next();
            assertTrue(false, "Should get an exception");
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }
}