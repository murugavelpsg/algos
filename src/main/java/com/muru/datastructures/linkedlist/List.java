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

    /**
     * Checks if the element is present in the linkedlist
     * @param e
     * @return
     */
    boolean contains(T e);

    /**
     * Adds element to the beginning of the list
     * @param e
     * @return
     */
    boolean addAtFirst(T e);

    /**
     * Removes element at the end of the list
     * @return
     */
    T removeAtEnd() throws NoSuchElementException;

    /**
     * Peek the first element in the list.
     * @return
     * @throws NoSuchElementException
     */
    T peek() throws NoSuchElementException;
}
