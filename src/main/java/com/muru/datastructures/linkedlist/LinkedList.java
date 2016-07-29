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

    public boolean removeLastOccurence(Object e) {
        Node<T> prevToLastOccurence = null;
        Node<T> lastOccurence = null;
        Node<T> prevNode = null;
        Node<T> currentNode = head;
        //Find the last occurence by traversing the entire list
        while (currentNode != null) {
            if (currentNode.getData().equals((T)e)) {
                lastOccurence = currentNode;
                prevToLastOccurence = prevNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (lastOccurence != null) {
            if (prevToLastOccurence == null) {
                //If the last occurence is the first element
                head = lastOccurence.getNext();
            } else {
                //last occurence might be in the middle or the end
                prevToLastOccurence.setNext(lastOccurence.getNext());
            }
            lastOccurence.setNext(null);
            size--;
            return true;
        }
        return false;
    }

    public Object peekLast() {
        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public boolean remove(Object e) {
        boolean found = false;
        if (head == null) {
            return found;
        }
        Node<T> prevNode = null;
        Node<T> currentNode = head;
        while(currentNode != null) {
            if (currentNode.getData().equals(e)) {
                found = true;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (found) {
            if (currentNode == head) {
                head = currentNode.getNext();
            } else {
                prevNode.setNext(currentNode.getNext());
            }
            size--;
            currentNode.setNext(null);
        }
        return found;
    }

    public void setHead(Node node) {
        this.head = node;
    }
}
