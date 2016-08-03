package com.muru.datastructures.linkedlist;

import com.muru.datastructures.common.Node;
import com.muru.designpatterns.iterator.SortedCircularlyLinkedListIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 5/30/16.
 */
public class SortedCircularlyLinkedList<T extends Comparable<T>> implements List {
    Node<T> head = null;
    int size = 0;

    public boolean add(Object e) {
        Node<T> currentNode = head;
        Node<T> newNode = new Node<T>((T) e, null);
        if (head == null) {
            head = newNode;
            newNode.setNext(newNode);
        } else {
            //Insert into a one element list
            if (currentNode.equals(currentNode.getNext())) {
                if (currentNode.getData().compareTo((T)e) > 0) {
                    head = newNode;
                }
                currentNode.setNext(newNode);
                newNode.setNext(currentNode);
            } else {
                //Insert element in the begining of the list
                if (currentNode.getData().compareTo((T)e) > 0) {
                    newNode.setNext(head);
                    //Set the last node in the circular list to the new head
                    Node<T> tmpNode = head;
                    while (!tmpNode.getNext().equals(head)) {
                        tmpNode = tmpNode.getNext();
                    }
                    head = newNode;
                    tmpNode.setNext(newNode);
                } else {
                    Node<T> nextNode = currentNode.getNext();
                    while (nextNode != head) {
                        //Insert into middle of the list
                        if (currentNode.getData().compareTo((T)e) <= 0 && nextNode.getData().compareTo((T)e) > 0) {
                            newNode.setNext(currentNode.getNext());
                            currentNode.setNext(newNode);
                            size++;
                            return true;
                        }
                        currentNode = currentNode.getNext();
                        nextNode = nextNode.getNext();
                    }
                    //Reached the end of the list. So the element should be inserted at the end of the list
                    newNode.setNext(currentNode.getNext());
                    currentNode.setNext(newNode);
                }
            }
        }
        size++;
        return true;
    }

    public Object remove() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException();
        }

        Node<T> currentNode = head;
        Object elemRemoved;
        if (currentNode.equals(currentNode.getNext())) {
            elemRemoved = currentNode.getData();
            currentNode.setNext(null);
            head = null;
        } else {
            elemRemoved = currentNode.getData();
            Node<T> tmpNode = head;
            //Find the node at the end of the list which points to the head
            //And set next node to current head
            while (!tmpNode.getNext().equals(head)) {
                tmpNode = tmpNode.getNext();
            }
            head = currentNode.getNext();
            tmpNode.setNext(currentNode.getNext());
        }
        size--;
        return elemRemoved;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object e) {
        Node<T> currentNode = head;
        if (head == null) {
            return false;
        }

        do {
            if (currentNode.getData().equals(e)) {
                return true;
            }
            currentNode = currentNode.getNext();
        } while(currentNode != head);

        return false;
    }

    public boolean addAtFirst(Object e) {
        throw new UnsupportedOperationException("addAtFirst operation is not supported");
    }

    public Object removeAtEnd() throws NoSuchElementException {
        throw new UnsupportedOperationException("removeAtEnd operation is not supported");
    }

    public Object peek() throws NoSuchElementException {
        throw new UnsupportedOperationException("peek operation is not supported");
    }

    public Node getHead() {
        return head;
    }

    public boolean removeLastOccurence(Object e) {
        throw new UnsupportedOperationException("removeLastOccurence is not supported");
    }

    public Object peekLast() {
        throw new UnsupportedOperationException("peekLast is not supported");
    }

    public boolean remove(Object e) {
        throw new UnsupportedOperationException("removing a particular element is not supported");
    }

    public void setHead(Node node) {
        this.head = node;
    }

    public Iterator iterator() {
        return new SortedCircularlyLinkedListIterator(this);
    }
}
