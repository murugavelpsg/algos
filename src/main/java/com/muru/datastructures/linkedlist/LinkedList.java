package com.muru.datastructures.linkedlist;

import com.muru.datastructures.common.Node;

import java.util.NoSuchElementException;

/**
 * Created by msivagna on 4/30/16.
 */
public class LinkedList<T extends Comparable<T>> implements List {
    public static final String LIST_IS_EMPTY = "List is empty";
    Node<T> head;
    int size = 0;

    public boolean add(Object e) {
        Node<T> temp = head;
        Node<T> newNode = new Node<T>((T) e, null);
        if (temp == null) {
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
            throw new NoSuchElementException(LIST_IS_EMPTY);
        }
        Node<T> removedNode = head;
        head = head.getNext();
        size--;
        return removedNode.getData();
    }

    public int size() {
        return size;
    }

    public boolean contains(Object e) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getData().equals(e)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public boolean addAtFirst(Object e) {
        Node<T> newNode = new Node<T>((T) e, null);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return true;
    }

    public T removeAtEnd() throws NoSuchElementException {
        T nodeValue;
        if (head == null) {
            throw new NoSuchElementException(LIST_IS_EMPTY);
        }

        if (head.getNext() == null) {
            nodeValue = head.getData();
            head = null;
            size--;
            return nodeValue;
        } else {
            Node<T> prevNode = head;
            Node<T> currentNode = head.getNext();
            while (currentNode.getNext() != null) {
                prevNode = currentNode;
                currentNode = currentNode.getNext();
            }
            nodeValue = currentNode.getData();
            prevNode.setNext(null);
            size--;
            return nodeValue;
        }
    }

    public T peek() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException(LIST_IS_EMPTY);
        }
        return head.getData();
    }

    public Node getHead() {
        return head;
    }
}
