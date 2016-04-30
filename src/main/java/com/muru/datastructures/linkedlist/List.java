package com.muru.datastructures.linkedlist;

import java.util.NoSuchElementException;

/**
 * Created by msivagna on 4/30/16.
 */
public interface List<T> {
    /**
     * Adds an element to the end of the list
     * @param e
     * @return
     */
    boolean add(T e);

    /**
     * Removes the first element from the list
     * @return
     * @throws NoSuchElementException
     */
    T remove() throws NoSuchElementException;

    /**
     * Returns the size of the linked list
     * @return
     */
    int size();
}
