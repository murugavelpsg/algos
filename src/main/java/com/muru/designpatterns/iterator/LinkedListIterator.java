package com.muru.designpatterns.iterator;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.linkedlist.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 8/3/16.
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private Node currentNode;

    public LinkedListIterator(List<T> list) {
        currentNode = list.getHead();
    }

    public boolean hasNext() {
        if (currentNode == null) {
            return false;
        }
        return true;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("End of the list");
        }
        T value = (T) currentNode.getData();
        currentNode = currentNode.getNext();
        return value;
    }
}
