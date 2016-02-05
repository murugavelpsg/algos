package com.muru.stack;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 2/4/16.
 */
public class StackImplTest {
    private Stack<Integer> stack;
    private Stack<Integer> emptyStack;

    @BeforeTest
    public void setUp() {
        stack = new StackImpl<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        emptyStack = new StackImpl<Integer>();
    }

    @Test(expectedExceptions = StackUnderflowException.class)
    public void mustFailForPoppingEmptyStack() throws StackUnderflowException {
        emptyStack.pop();
    }

    @Test
    public void mustPopDataFromANonEmptyStack() throws StackUnderflowException {
        Integer peekedData = stack.peek();
        Integer data = stack.pop();
        assertEquals(data, peekedData);
    }

    @Test(expectedExceptions = StackUnderflowException.class)
    public void mustFailForPeekingEmptyStack() throws StackUnderflowException {
        emptyStack.peek();
    }

    @Test
    public void mustPeekDataFromANonEmptyStack() throws StackUnderflowException {
        Integer data = stack.peek();
        assertEquals(data, new Integer(3));
    }

    @Test
    public void mustSuccessfullyPushToStack() throws StackUnderflowException {
        Integer data = new Integer(4);
        stack.push(4);
        assertEquals(stack.peek(), data);
    }
}