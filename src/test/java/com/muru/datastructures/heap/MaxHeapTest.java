package com.muru.datastructures.heap;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 8/26/16.
 */
public class MaxHeapTest {

    @Test
    public void mustInsertElementIntoHeap() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(10);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(40);
        assertEquals(maxHeap.size(), 4);
        assertEquals(maxHeap.remove(), new Integer(40));
        assertEquals(maxHeap.remove(), new Integer(30));
        assertEquals(maxHeap.size(), 2);
    }

    @Test
    public void mustInsertElementBeyondInitialSize() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        maxHeap.add(10);
        maxHeap.add(20);
        assertEquals(maxHeap.size(), 2);
        maxHeap.add(30);
        maxHeap.add(40);
        assertEquals(maxHeap.size(), 4);
        maxHeap.add(50);
        maxHeap.add(60);
        assertEquals(maxHeap.size(), 6);
    }

    @Test
    public void mustRemoveDuplicateMaxElementsInHeapConsecutively() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(40);
        maxHeap.add(40);
        maxHeap.add(40);
        assertEquals(maxHeap.size(), 6);
        assertEquals(maxHeap.remove(), new Integer(40));
        assertEquals(maxHeap.remove(), new Integer(40));
        assertEquals(maxHeap.remove(), new Integer(40));
        assertEquals(maxHeap.remove(), new Integer(30));
        assertEquals(maxHeap.size(), 2);
    }

    @Test
    public void mustSatisfyTheMaxHeapProperty() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        maxHeap.add(60);
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(50);
        maxHeap.add(40);
        assertEquals(maxHeap.remove(), new Integer(60));
        assertEquals(maxHeap.remove(), new Integer(50));
        assertEquals(maxHeap.remove(), new Integer(40));
        assertEquals(maxHeap.remove(), new Integer(30));
        assertEquals(maxHeap.size(), 2);
    }

    @Test
    public void mustRemoveAllTheElementsFromHeap() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        maxHeap.add(40);
        maxHeap.add(50);
        maxHeap.add(60);
        assertEquals(maxHeap.remove(), new Integer(60));
        assertEquals(maxHeap.remove(), new Integer(50));
        assertEquals(maxHeap.remove(), new Integer(40));
        assertEquals(maxHeap.remove(), new Integer(30));
        assertEquals(maxHeap.size(), 2);
        assertEquals(maxHeap.remove(), new Integer(20));
        assertEquals(maxHeap.remove(), new Integer(10));
        assertEquals(maxHeap.size(), 0);
        assertEquals(maxHeap.remove(), null);
        assertEquals(maxHeap.size(), 0);
    }

    @Test
    public void mustGetTheMaxElementWhenPeeked() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        maxHeap.add(60);
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(50);
        maxHeap.add(40);
        assertEquals(maxHeap.peek(), new Integer(60));
        maxHeap.remove();
        maxHeap.remove();
        assertEquals(maxHeap.peek(), new Integer(40));
        assertEquals(maxHeap.size(), 4);
    }

    @Test
    public void mustGetTrueIfTheElementIsInHeap() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        maxHeap.add(60);
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(50);
        maxHeap.add(40);
        assertEquals(maxHeap.contains(new Integer(10)), true);
    }

    @Test
    public void mustGetFalseIfTheElementIsNotInHeap() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        maxHeap.add(60);
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(50);
        maxHeap.add(40);
        assertEquals(maxHeap.contains(new Integer(100)), false);
    }

    @Test
    public void mustGetCorrectSizeOfTheHeap() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        assertEquals(maxHeap.size(), 0);
        maxHeap.add(60);
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(50);
        maxHeap.add(40);
        maxHeap.add(70);
        assertEquals(maxHeap.size(), 7);
        maxHeap.remove();
        maxHeap.remove();
        assertEquals(maxHeap.size(), 5);
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        assertEquals(maxHeap.size(), 0);
    }

    @Test
    public void mustGetNullWhenRemovedFromEmptyHeap() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        assertEquals(maxHeap.remove(), null);
    }

    @Test
    public void mustGetNullWhenPeekedOnAnEmptyHeap() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        assertEquals(maxHeap.peek(), null);
    }

    @Test
    public void mustGetFalseWhenContainsCalledOnAnEmptyHeap() {
        Heap<Integer> maxHeap = new MaxHeap<Integer>(2);
        assertEquals(maxHeap.contains(new Integer(30)), false);
    }
}