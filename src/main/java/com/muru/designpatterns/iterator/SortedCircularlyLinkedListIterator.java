package com.muru.designpatterns.iterator;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.linkedlist.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 8/3/16.
 *
 * An iterator for sorted circular linked list implementation in the datastructures package
 */
public class SortedCircularlyLinkedListIterator<T> implements Iterator<T> {
    private List<T> list;
    private Node<T> currentNode;
    private boolean hasIterationStarted;

    public SortedCircularlyLinkedListIterator(List<T> list) {
        this.list = list;
        this.currentNode = list.getHead();
        hasIterationStarted = false;
    }

    public boolean hasNext() {
        if (!hasIterationStarted && list.getHead() == null) {
            return false;
        }
        if (hasIterationStarted && list.getHead() == currentNode) {
            return false;
        }
        return true;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Traversed the whole list once. No more new elements to traverse");
        }
        hasIterationStarted = true;
        T value = (T) currentNode.getData();
        currentNode = currentNode.getNext();
        return value;
    }
}
