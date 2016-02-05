package com.muru.queue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 2/5/16.
 */
public class QueueImplTest {
    Queue<Integer> queue;
    Queue<Integer> emptyQueue;

    @BeforeTest
    public void setup() {
        queue = new QueueImpl<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        emptyQueue = new QueueImpl<Integer>();
    }

    @Test
    public void mustGetAnElementFromNonEmptyQueue(){
        Integer peekedElement = queue.peek();
        Integer removedElement = queue.remove();
        assertEquals(removedElement, peekedElement);
    }

    @Test
    public void mustAddAnElementToQueue(){
        Integer actualData = new Integer(4);
        Integer sizeBeforeAdd = queue.size();
        queue.add(actualData);
        assertEquals(queue.size(), sizeBeforeAdd+1);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailWhenRemovingElementFromEmptyQueue(){
        emptyQueue.remove();
    }

    @Test
    public void mustPeekAnElementFromNonEmptyQueue(){
        Integer actualData = new Integer(1);
        Queue<Integer> peekQueue = new QueueImpl<Integer>();
        peekQueue.add(actualData);
        assertEquals(peekQueue.peek(), actualData);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailWhenPeekingElementFromEmptyQueue(){
        emptyQueue.peek();
    }

    @Test
    public void mustGetQueueSizeCorrectly() {
        Queue<Integer> sizeQueue = new QueueImpl<Integer>();
        sizeQueue.add(1);
        assertEquals(sizeQueue.size(), 1);
        sizeQueue.add(2);
        assertEquals(sizeQueue.size(), 2);
        sizeQueue.remove();
        assertEquals(sizeQueue.size(), 1);
        sizeQueue.remove();
        assertEquals(sizeQueue.size(), 0);
    }

    @Test
    public void mustGetCorrectSizeWhenRemovedElementFromEmptyQueue() {
        Queue<Integer> sizeQueue = new QueueImpl<Integer>();
        assertEquals(sizeQueue.size(), 0);
        try {
            sizeQueue.remove();
        } catch (NoSuchElementException e) {
            //Do nothing
        }
        assertEquals(sizeQueue.size(), 0);
    }
}