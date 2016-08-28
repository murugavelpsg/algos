package com.muru.datastructures.heap;

/**
 * Created by msivagna on 8/26/16.
 */
public interface Heap<T extends Comparable<T>> {
    /**
     * Add an element to the heap
     * @param element
     * @return
     */
    boolean add(T element);

    /**
     * Remove the max element from the heap
     * @return
     */
    T remove();

    /**
     * Peek the top most element in the heap.
     * Returns null if the heap is empty
     * @return
     */
    T peek();

    /**
     * Check if the element is present in the heap
     * @return
     */
    boolean contains(T element);

    /**
     * Return the size of the heap
     * @return
     */
    int size();
}
