package com.muru.datastructures.linkedlist;

import com.muru.datastructures.common.Node;

import java.util.NoSuchElementException;

/**
 * Created by msivagna on 4/30/16.
 */
public interface List<T> extends Iterable<T> {
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

    /**
     * Returns the root of the linkedlist
     * @return
     */
    Node<T> getHead();

    /**
     * Removes the last occurence from the list when traversing the node from head to tail
     * Returns true if the element is successfully removed else false when the element is not found
     * @param e
     * @return
     */
    boolean removeLastOccurence(T e);

    /**
     * Retrieves, but does not remove, the last element of this list,
     * or returns null if this list is empty.
     * @return
     */
    T peekLast();

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * If this list does not contain the element, it is unchanged.
     * Returns true if the element is present.
     * @param e
     * @return
     */
    boolean remove(T e);

    /**
     * Set the value for head of the list
     * @param node
     */
    void setHead(Node<T> node);
}
