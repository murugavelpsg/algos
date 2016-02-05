package com.muru.stack;

/**
 * Created by msivagna on 2/4/16.
 */
public interface Stack<T> {
    void push(T data);

    T pop() throws StackUnderflowException;

    T peek() throws StackUnderflowException;
}
