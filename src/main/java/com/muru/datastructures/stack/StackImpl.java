package com.muru.datastructures.stack;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.stack.exception.StackUnderflowException;
import com.muru.datastructures.stack.exception.StackOverflowException;

/**
 * Created by msivagna on 2/4/16.
 * Implementation for a bounded buffer stack.
 */
public class StackImpl<T extends Comparable<T>> implements Stack {
    Node<T> top;
    Integer size;
    Integer currentSize;

    public StackImpl(Integer size) {
        top = null;
        this.size = size;
        currentSize = 0;
    }

    public void push (Object data) throws StackOverflowException {
        if (currentSize == size) {
            throw new StackOverflowException();
        }
        Node newNode = new Node(data, top);
        top = newNode;
        currentSize++;
    }

    public T pop() throws StackUnderflowException {
        if (top == null) {
            throw new StackUnderflowException();
        }
        T data = top.getData();
        top = top.getNext();
        currentSize--;
        return data;
    }

    public T peek() throws StackUnderflowException {
        if (top == null) {
            throw new StackUnderflowException();
        }
        return top.getData();
    }
}
