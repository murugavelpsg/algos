package com.muru.datastructures.heap;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 12/8/16.
 */
public class MinHeapTest {
    @Test
    public void mustInsertElementsToHeap() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        assertEquals(minHeap.size(), 3);
        assertEquals(minHeap.peek(), new Integer(10));
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void mustGetErrorWhenNullIsInserted() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(null);
    }

    @Test
    public void mustInsertElementsBeyondInitialCapacity() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(50));
        minHeap.add(new Integer(60));
        assertEquals(minHeap.size(), 5);
        minHeap.add(new Integer(5));
        assertEquals(minHeap.size(), 6);
        minHeap.add(new Integer(2));
        assertEquals(minHeap.size(), 7);
        assertEquals(minHeap.peek(), new Integer(2));
    }

    @Test
    public void mustGetTheMinElementOnPeek() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        assertEquals(minHeap.size(), 3);
        assertEquals(minHeap.peek(), new Integer(10));
    }

    @Test
    public void mustGetNullWhenPeakedOnEmptyHeap() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        assertEquals(minHeap.peek(), null);
    }

    @Test
    public void mustGetTheCurrentSizeAfterInsertion() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        assertEquals(minHeap.size(), 1);
        minHeap.add(new Integer(20));
        assertEquals(minHeap.size(), 2);
        minHeap.add(new Integer(10));
        assertEquals(minHeap.size(), 3);
    }

    @Test
    public void mustGetNullWhenRemovedFromEmptyHeap() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        Integer removedElem = minHeap.remove();
        assertEquals(removedElem, null);
        assertEquals(minHeap.size(), 0);
    }

    @Test
    public void mustSuccessfullyRemoveElemFromHeap() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(60));
        minHeap.add(new Integer(50));
        assertEquals(minHeap.size(), 5);
        Integer removedElem = minHeap.remove();
        assertEquals(removedElem, new Integer(10));
        assertEquals(minHeap.size(), 4);
        removedElem = minHeap.remove();
        removedElem = minHeap.remove();
        removedElem = minHeap.remove();
        assertEquals(removedElem, new Integer(50));
        assertEquals(minHeap.size(), 1);
        removedElem = minHeap.remove();
        assertEquals(minHeap.size(), 0);
        removedElem = minHeap.remove();
        assertEquals(removedElem, null);
    }

    @Test
    public void mustHaveNextSmallestElementAfterDelete() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(60));
        minHeap.add(new Integer(50));
        assertEquals(minHeap.size(), 5);
        Integer removedElem = minHeap.remove();
        assertEquals(removedElem, new Integer(10));
        assertEquals(minHeap.peek(), new Integer(20));
        assertEquals(minHeap.size(), 4);
    }

    @Test
    public void mustUpdateSizeAfterEachDelete() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(60));
        minHeap.add(new Integer(50));
        assertEquals(minHeap.size(), 5);
        minHeap.remove();
        assertEquals(minHeap.size(), 4);
        minHeap.remove();
        minHeap.remove();
        minHeap.remove();
        assertEquals(minHeap.size(), 1);
        minHeap.remove();
        assertEquals(minHeap.size(), 0);
        minHeap.remove();
        assertEquals(minHeap.size(), 0);
    }

    @Test
    public void mustGetTrueIfElementIsPresent() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(60));
        minHeap.add(new Integer(50));
        assertEquals(minHeap.contains(10), true);
    }

    @Test
    public void mustGetFalseIfElementIsNotPresent() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(60));
        minHeap.add(new Integer(50));
        assertEquals(minHeap.contains(100), false);
    }

    @Test
    public void mustGetFalseIfElementSearchedIsNull() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(30));
        minHeap.add(new Integer(20));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(60));
        minHeap.add(new Integer(50));
        assertEquals(minHeap.contains(null), false);
    }

    @Test
    public void mustReturnFalseIfElementIsSearchedInEmptyHeap() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        assertEquals(minHeap.contains(100), false);
    }

    @Test
    public void mustAddAndRemoveTheSameElementsFromHeap() {
        Heap<Integer> minHeap = new MinHeap<Integer>(4);
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(10));
        minHeap.add(new Integer(10));
        assertEquals(minHeap.size(), 5);
        minHeap.remove();
        minHeap.remove();
        minHeap.remove();
        minHeap.remove();
        assertEquals(minHeap.size(), 1);
        assertEquals(minHeap.peek(), new Integer(10));
        minHeap.remove();
        assertEquals(minHeap.size(), 0);
        assertEquals(minHeap.peek(), null);
    }
}