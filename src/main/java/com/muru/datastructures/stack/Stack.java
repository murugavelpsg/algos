package com.muru.datastructures.stack;

import com.muru.datastructures.stack.exception.StackOverflowException;
import com.muru.datastructures.stack.exception.StackUnderflowException;

/**
 * Created by msivagna on 2/4/16.
 */
public interface Stack<T> {
    /**
     * Method that pushes the element into the stack.
     * When one tries to push more elements than the size of the stack
     * then the method throws StackOverflowException
     * @param data
     * @throws StackOverflowException
     */
    void push(T data) throws StackOverflowException;

    /**
     * Method that pops an element from the stack
     * When one tries to pop from an empty stack then the method throws
     * StackUnderflowException
     * @return
     * @throws StackUnderflowException
     */
    T pop() throws StackUnderflowException;

    /**
     * Method that peeks an element from the top of the stack
     * When one tries to peek from an empty stack then the method throws
     * StackUnderflowException
     * @return
     * @throws StackUnderflowException
     */
    T peek() throws StackUnderflowException;

    /**
     * Return the current size of the stack
     * @return
     */
    int size();
}
