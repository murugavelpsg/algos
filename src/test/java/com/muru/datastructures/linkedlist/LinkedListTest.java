package com.muru.datastructures.linkedlist;

import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.*;

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
        assertEquals(list.size(), 0);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionWhenRemovedFromEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        list.remove();
    }

    @Test
    public void mustReturnTrueIfElementIsPresent() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));
        list.add(new Integer(40));
        assertEquals(list.contains(10), true);
        assertEquals(list.contains(20), true);
    }

    @Test
    public void mustReturnFalseIfElementIsNotPresent() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));
        list.add(new Integer(40));
        assertEquals(list.contains(100), false);
        assertEquals(list.contains(200), false);
    }

    @Test
    public void mustReturnFalseForContainsInEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        assertEquals(list.contains(100), false);
        assertEquals(list.contains(200), false);
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

    @Test
    public void mustGetTheRecentlyAddedElement() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));
        list.add(new Integer(40));
        Integer addAtFirstElem = new Integer(500);
        list.addAtFirst(addAtFirstElem);
        assertEquals(list.size(), 5);
        assertEquals(list.peek(), addAtFirstElem);
    }

    @Test
    public void mustGetTheRecentlyAddedElementToEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        Integer addAtFirstElem = new Integer(500);
        list.addAtFirst(addAtFirstElem);
        assertEquals(list.size(), 1);
        assertEquals(list.peek(), addAtFirstElem);
    }

    @Test
    public void mustGetTheHeadElementWhenPeeked() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));
        list.add(new Integer(40));
        assertEquals(list.peek(), new Integer(10));
        list.remove();
        assertEquals(list.peek(), new Integer(20));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionWhenPeekedAnEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        list.peek();
    }

    @Test
    public void mustGetElementAtTheEndOfTheList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));
        list.add(new Integer(40));
        assertEquals(list.size(), 4);
        assertEquals(list.removeAtEnd(), new Integer(40));
        assertEquals(list.removeAtEnd(), new Integer(30));
        assertEquals(list.removeAtEnd(), new Integer(20));
        assertEquals(list.size(), 1);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionWhenRemovedAtEndFromAnEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        list.removeAtEnd();
    }

    @Test
    public void mustRemoveAtEndFromOneElementList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(10));
        assertEquals(list.removeAtEnd(), new Integer(10));
        assertEquals(list.size(), 0);
    }

    @Test
    public void mustGetFalseWhenTheListIsEmpty() {
        List<Integer> list = new LinkedList<Integer>();
        assertFalse(list.removeLastOccurence(new Integer(5)));
        assertEquals(list.size(), 0);
    }

    @Test
    public void mustGetFalseIfTheLastOccurenceIsNotFound() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));
        list.add(new Integer(40));
        assertFalse(list.removeLastOccurence(new Integer(5)));
        assertEquals(list.size(), 6);
    }

    @Test
    public void mustGetTrueIfTheWhenTheLastOccurenceIsLastElement() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(3));
        list.add(new Integer(5));
        list.add(new Integer(3));
        assertTrue(list.removeLastOccurence(new Integer(3)));
        assertEquals(list.size(), 5);
        assertEquals(list.peekLast(), new Integer(5));
    }

    @Test
    public void mustGetTrueIfTheWhenTheLastOccurenceIsFirstElement() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(3));
        list.add(new Integer(5));
        list.add(new Integer(3));
        assertTrue(list.removeLastOccurence(new Integer(1)));
        assertEquals(list.size(), 5);
        assertEquals(list.peek(), new Integer(3));
    }

    @Test
    public void mustGetTrueIfTheWhenTheLastOccurenceIsInMiddle() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(10));
        list.add(new Integer(5));
        list.add(new Integer(3));
        assertTrue(list.removeLastOccurence(new Integer(10)));
        assertEquals(list.size(), 5);
    }

    @Test
    public void mustGetNullHeadWhenTheListIsEmpty() {
        List<Integer> list = new LinkedList<Integer>();
        assertEquals(list.getHead(), null);
    }

    @Test
    public void mustGetFirstElementWhenTheListIsNotEmpty() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        assertEquals(list.getHead().getData(), new Integer(1));
    }

    @Test
    public void mustGetNullForPeekLastIfListIsEmpty() {
        List<Integer> list = new LinkedList<Integer>();
        assertNull(list.peekLast());
    }

    @Test
    public void mustGetLastElementForPeekLastIfListIsEmpty() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(10));
        list.add(new Integer(5));
        list.add(new Integer(3));
        assertEquals(list.peekLast(), new Integer(3));
        assertEquals(list.size(), 6);
    }

    @Test
    public void mustGetFalseWhenObjectRemovedFromEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        assertFalse(list.remove(new Integer(1)));
    }

    @Test
    public void mustGetFalseWhenObjectRemovedNotPresentInNonEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(10));
        list.add(new Integer(5));
        list.add(new Integer(3));
        assertFalse(list.remove(new Integer(100)));
        assertEquals(list.size(), 6);
    }

    @Test
    public void mustGetTrueWhenObjectRemovedIsFirstInNonEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(10));
        list.add(new Integer(5));
        list.add(new Integer(3));
        assertTrue(list.remove(new Integer(1)));
        assertEquals(list.size(), 5);
        assertEquals(list.peek(), new Integer(3));
    }

    @Test
    public void mustGetTrueWhenObjectRemovedIsMiddleInNonEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(10));
        list.add(new Integer(5));
        list.add(new Integer(3));
        assertTrue(list.remove(new Integer(10)));
        assertEquals(list.size(), 5);
    }

    @Test
    public void mustGetTrueWhenObjectRemovedIsLastInNonEmptyList() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(10));
        list.add(new Integer(10));
        list.add(new Integer(5));
        list.add(new Integer(30));
        assertTrue(list.remove(new Integer(30)));
        assertEquals(list.size(), 5);
        assertEquals(list.peekLast(), new Integer(5));
    }
}