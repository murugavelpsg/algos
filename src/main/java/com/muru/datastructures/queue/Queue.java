package com.muru.datastructures.queue;

import java.util.NoSuchElementException;

/**
 * Created by msivagna on 2/5/16.
 */
public interface Queue<T> {
    /**
     * Adds an element to the queue
     * Throws:
     *
     * @param data
     */
    void add(T data);

    /**
     * Removes an element from the queue
     * Throws:
     *  NoSuchElementException - When one tries to remove element from an empty queue
     * @return
     * @throws NoSuchElementException
     */
    T remove() throws NoSuchElementException;

    /**
     * Peeks an element from the queue
     * Throws:
     *  NoSuchElementException - When one tries to peek element from an empty queue
     * @return
     * @throws NoSuchElementException
     */
    T peek() throws NoSuchElementException;

    /**
     * Returns the size of the queue
     * @return
     */
    int size();

}
