package com.muru.designpatterns.iterator;

import com.muru.datastructures.linkedlist.LinkedList;
import com.muru.datastructures.linkedlist.List;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 8/3/16.
 */
public class LinkedListIteratorTest {

    @Test
    public void hasNextMustReturnFalseIfTheListIsEmpty() {
        List<Integer> list = new LinkedList<Integer>();
        Iterator<Integer> listIterator = new LinkedListIterator<Integer>(list);
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void hasNextMustReturnTrueIfTheHasAtLeastOneElement() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(100);
        Iterator<Integer> listIterator = new LinkedListIterator<Integer>(list);
        assertTrue(listIterator.hasNext());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void nextShouldThrowExceptionIfTheListIsEmpty() {
        List<Integer> list = new LinkedList<Integer>();
        Iterator<Integer> listIterator = new LinkedListIterator<Integer>(list);
        listIterator.next();
    }

    @Test
    public void nextShouldReturnTheNextElementInTheList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        Iterator<Integer> listIterator = new LinkedListIterator<Integer>(list);
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