package com.muru.queue;

import com.muru.common.Node;

import java.util.NoSuchElementException;

/**
 * Created by msivagna on 2/5/16.
 */
public class QueueImpl<T extends Comparable<T>> implements Queue {
    Node<T> start;
    Node<T> end;
    int size;

    public QueueImpl() {
        start = null;
        end = null;
    }

    public void add(Object data) {
        if (start == null && end == null) {
            Node newNode = new Node(data, null);
            start = newNode;
            end = newNode;
        } else {
            Node newNode = new Node(data, null);
            end.setNext(newNode);
            end = newNode;
        }
        size++;
    }

    public T remove() throws NoSuchElementException {
        if (start == null && end == null) {
            throw new NoSuchElementException();
        }
        T data = start.getData();
        if (start.getNext() == null) {
            end = null;
        }
        start = start.getNext();
        size--;
        return data;
    }

    public T peek() throws NoSuchElementException {
        if (start == null && end == null) {
            throw new NoSuchElementException();
        }
        return start.getData();
    }

    public int size() {
        return size;
    }
}
