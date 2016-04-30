package com.muru.datastructures.linkedlist;

import com.muru.datastructures.common.Node;

import java.util.NoSuchElementException;

/**
 * Created by msivagna on 4/30/16.
 */
public class LinkedList<T extends Comparable<T>> implements List {
    Node<T> head;
    int size = 0;

    public boolean add(Object e) {
        Node<T> temp = head;
        Node<T> newNode = new Node<T>((T) e, null);
        if (head == null) {
            head = newNode;
        } else {
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        size++;
        return true;
    }

    public T remove() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node<T> removedNode = head;
        head = head.getNext();
        size--;
        return removedNode.getData();
    }

    public int size() {
        return size;
    }
}
