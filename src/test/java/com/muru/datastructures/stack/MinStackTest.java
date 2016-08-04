package com.muru.datastructures.stack;

import com.muru.datastructures.stack.exception.StackOverflowException;
import com.muru.datastructures.stack.exception.StackUnderflowException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 8/3/16.
 */
public class MinStackTest {

    @Test(expectedExceptions = StackUnderflowException.class)
    public void mustGetNullAsMinimumWhenStackIsEmpty() throws StackUnderflowException {
        MinStack minStack = new MinStack(10);
        assertEquals(minStack.peekMinimum(), null);
    }

    @Test
    public void mustGetTheCorrectMinimumWhenStackIsNotEmpty()
            throws StackOverflowException, StackUnderflowException {
        MinStack minStack = new MinStack(10);
        minStack.push(10);
        minStack.push(9);
        minStack.push(8);
        assertEquals(minStack.peekMinimum(), new Integer(8));
        minStack.push(12);
        assertEquals(minStack.peekMinimum(), new Integer(8));
        minStack.push(1);
        minStack.push(2);
        minStack.push(4);
        assertEquals(minStack.peekMinimum(), new Integer(1));
        minStack.pop();
        assertEquals(minStack.peekMinimum(), new Integer(1));
        minStack.pop();
        minStack.pop();
        assertEquals(minStack.peekMinimum(), new Integer(8));
        minStack.pop();
        minStack.pop();
        minStack.pop();
        assertEquals(minStack.peekMinimum(), new Integer(10));
        minStack.pop();
    }

    @Test
    public void mustGetTheCorrectMinimumWhenSameElementIsPushedMultipleTimes()
            throws StackOverflowException, StackUnderflowException {
        MinStack minStack = new MinStack(10);
        minStack.push(10);
        minStack.push(10);
        minStack.push(10);
        minStack.push(10);
        assertEquals(minStack.peekMinimum(), new Integer(10));
        minStack.push(10);
        assertEquals(minStack.peekMinimum(), new Integer(10));
        minStack.push(10);
        assertEquals(minStack.peekMinimum(), new Integer(10));
        minStack.push(10);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        assertEquals(minStack.peekMinimum(), new Integer(10));
        minStack.pop();
        minStack.pop();
        assertEquals(minStack.peekMinimum(), new Integer(10));
        minStack.pop();
        assertEquals(minStack.peekMinimum(), new Integer(10));
        minStack.pop();
    }
}