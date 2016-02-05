package com.muru.stack;

import com.muru.common.Node;

/**
 * Created by msivagna on 2/4/16.
 */
public class StackImpl<T extends Comparable<T>> implements Stack {
    Node<T> top;

    public StackImpl() {
        top = null;
    }

    public void push(Object data) {
        Node newNode = new Node(data, top);
        top = newNode;
    }

    public T pop() throws StackUnderflowException {
        if (top == null) {
            throw new StackUnderflowException();
        }
        T data = top.getData();
        top = top.getNext();
        return data;
    }

    public T peek() throws StackUnderflowException {
        if (top == null) {
            throw new StackUnderflowException();
        }
        return top.getData();
    }
}
