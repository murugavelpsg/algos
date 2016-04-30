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
}