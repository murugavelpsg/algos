package com.muru.datastructures.linkedlist;

import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 5/30/16.
 */
public class SortedCircularlyLinkedListTest {
    @Test
    public void mustInsertIntoAnEmptyList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        assertEquals(list.size(), 0);
        list.add(2);
        assertEquals(list.size(), 1);
    }

    @Test
    public void mustInsertAtEndIntoOneElementList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        assertEquals(list.size(), 1);
        list.add(3);
        assertEquals(list.size(), 2);
        assertEquals(list.getHead().getData(), new Integer(2));
    }

    @Test
    public void mustInsertAtBeginingIntoOneElementList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        assertEquals(list.size(), 1);
        list.add(1);
        assertEquals(list.size(), 2);
        assertEquals(list.getHead().getData(), new Integer(1));
    }

    @Test
    public void mustInsertToTheBeginingOfTheMultiElementList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        assertEquals(list.size(), 4);
        list.add(1);
        assertEquals(list.size(), 5);
        assertEquals(list.getHead().getData(), new Integer(1));
    }

    @Test
    public void mustInsertToTheEndOfTheMultiElementList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        assertEquals(list.size(), 4);
        list.add(6);
        assertEquals(list.size(), 5);
        assertEquals(list.getHead().getData(), new Integer(1));
    }

    @Test
    public void mustInsertToTheMiddleOfTheMultiElementList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        assertEquals(list.size(), 4);
        list.add(3);
        assertEquals(list.size(), 5);
        assertEquals(list.getHead().getData(), new Integer(1));
    }

    @Test
    public void mustSuccessfullyGetTheSizeOfTheList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        assertEquals(list.size(), 4);
        list.add(3);
        assertEquals(list.size(), 5);
    }

    @Test
    public void mustInsertIntoAListWithSameElements() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        assertEquals(list.size(), 4);
        list.add(2);
        assertEquals(list.size(), 5);
    }

    @Test
    public void mustInsertADifferentElementIntoAListWithSameElements() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        assertEquals(list.size(), 4);
        list.add(3);
        assertEquals(list.size(), 5);
        assertEquals(list.getHead().getData(), new Integer(2));
    }

    @Test
    public void mustGetTrueIfTheElementIsInList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        assertTrue(list.contains(new Integer(5)));
    }

    @Test
    public void mustGetTrueIfTheElementIsInOneElementList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        assertTrue(list.contains(new Integer(2)));
    }

    @Test
    public void mustGetFalseIfContainsInvokedOnEmptyList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        assertFalse(list.contains(new Integer(2)));
    }

    @Test
    public void mustGetFalseIfTheElementIsNotInList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(4);
        assertFalse(list.contains(new Integer(100)));
    }

    @Test
    public void mustGetFalseIfTheElementIsNotInEmptyList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        assertFalse(list.contains(new Integer(100)));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void mustGetUnsupportedOperationExceptionForAddAtFirstMethod() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.addAtFirst(new Integer(100));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void mustGetUnsupportedOperationExceptionForRemoveAtEndMethod() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.removeAtEnd();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void mustGetUnsupportedOperationExceptionForPeekMethod() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.peek();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionWhenElementIsRemovedFromEmptyList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.remove();
    }

    @Test
    public void mustRemoveElementFromOneElementList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(new Integer(1));
        Integer elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(1));
        assertEquals(list.getHead(), null);
        assertEquals(list.size(), 0);
    }

    @Test
    public void mustRemoveElementFromTheBeginingOfTheList() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(5));
        list.add(new Integer(2));
        list.add(new Integer(4));
        Integer elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(1));
        elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(2));
        assertEquals(list.getHead().getData(), new Integer(4));
        assertEquals(list.size(), 2);
    }

    @Test
    public void mustIterateThroughAllTheElementsInTheListSuccessfully() {
        Integer[] elemsInList = {1, 2, 5, 4};
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(5));
        list.add(new Integer(2));
        list.add(new Integer(4));
        int i = 0;
        for (Integer data : list) {
            assertEquals(data, elemsInList[i]);
            i++;
        }
    }

    @Test
    public void mustIterateThroughEmptyListSuccessfully() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        for (Integer data : list) {
            assertTrue(false, "should not iterate");
        }
        assertTrue(true);
    }

    @Test
    public void mustGetAllElementsInASortedOrder() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(5));
        list.add(new Integer(2));
        list.add(new Integer(4));
        assertEquals(list.size(), 4);
        Integer elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(1));
        assertEquals(list.size(), 3);
        elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(2));
        assertEquals(list.size(), 2);
        elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(4));
        assertEquals(list.size(), 1);
        elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(5));
        assertEquals(list.getHead(), null);
        assertEquals(list.size(), 0);
    }

    @Test
    public void mustInsertAndDeleteNodesInsertedInDescendingOrder() {
        List<Integer> list = new SortedCircularlyLinkedList<Integer>();
        list.add(new Integer(5));
        list.add(new Integer(4));
        list.add(new Integer(3));
        list.add(new Integer(2));
        assertEquals(list.size(), 4);
        Integer elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(2));
        assertEquals(list.size(), 3);
        elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(3));
        assertEquals(list.size(), 2);
        elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(4));
        assertEquals(list.size(), 1);
        elemRemoved = list.remove();
        assertEquals(elemRemoved, new Integer(5));
        assertEquals(list.getHead(), null);
        assertEquals(list.size(), 0);
    }
}