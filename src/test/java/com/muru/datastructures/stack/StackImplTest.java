package com.muru.datastructures.stack;

import com.muru.datastructures.stack.exception.StackUnderflowException;
import com.muru.datastructures.stack.exception.StackOverflowException;
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
    public void setUp() throws StackOverflowException {
        stack = new StackImpl<Integer>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        emptyStack = new StackImpl<Integer>(0);
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
    public void mustPeekDataFromANonEmptyStack() throws StackUnderflowException, StackOverflowException {
        Stack<Integer> peekStack = new StackImpl(5);
        Integer actualData = new Integer(1);
        peekStack.push(actualData);
        Integer peekedData = peekStack.peek();
        assertEquals(peekedData, actualData);
    }

    @Test
    public void mustSuccessfullyPushToStack() throws StackUnderflowException, StackOverflowException {
        Integer data = new Integer(4);
        stack.push(4);
        assertEquals(stack.peek(), data);
    }

    @Test(expectedExceptions = StackOverflowException.class)
    public void mustFailWhenElementsMoreThanSizeIsAdded() throws StackOverflowException {
        stack.push(4);
        stack.push(5);
        stack.push(6);
    }
}