package com.muru.datastructures.stack;

import com.muru.datastructures.stack.exception.StackOverflowException;
import com.muru.datastructures.stack.exception.StackUnderflowException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by msivagna on 8/3/16.
 *
 * How would you design a stack which, in addition to push and pop,
 * also has a function peekMinimum which returns the minimum element?
 * Push, pop and peekMinimum all operate in O(1) time.
 */
public class MinStack<T extends Comparable<T>> extends StackImpl<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinStack.class);
    private Stack<T> minStack;
    public MinStack(Integer size) {
        super(size);
        minStack = new StackImpl<T>(size);
    }

    @Override
    public void push(Object elemToBeInserted) throws StackOverflowException {
        try {
            if (super.size() == 0) {
                minStack.push((T)elemToBeInserted);
            } else {
                if (((Comparable)elemToBeInserted).compareTo(minStack.peek()) <= 0) {
                    minStack.push((T)elemToBeInserted);
                }
            }
            super.push(elemToBeInserted);
        }
        catch (StackUnderflowException e) {
            LOGGER.error("Got exception = ", e);
            //Should never get exception
            assert false;
        }
    }

    @Override
    public T pop() throws StackUnderflowException {
        T elemPopped = super.pop();
        if (elemPopped.compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }
        return elemPopped;
    }

    public Comparable peekMinimum() throws StackUnderflowException {
        return minStack.peek();
    }
}
