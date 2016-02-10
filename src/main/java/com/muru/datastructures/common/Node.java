package com.muru.datastructures.common;

/**
 * Created by msivagna on 2/4/16.
 */
public class Node<T> {
    T data;
    Node next;

    public Node() {
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
