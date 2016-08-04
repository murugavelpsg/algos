package com.muru.datastructures.stack;

import com.muru.datastructures.stack.exception.StackOverflowException;
import com.muru.datastructures.stack.exception.StackUnderflowException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 2/4/16.
 */
public class StackImplTest {
    private class StackImplTestFixture {
        private Stack<Integer> stack;
        private Stack<Integer> emptyStack;

        public Stack<Integer> getStack() {
            return stack;
        }

        public void setStack(Stack<Integer> stack) {
            this.stack = stack;
        }

        public Stack<Integer> getEmptyStack() {
            return emptyStack;
        }

        public void setEmptyStack(Stack<Integer> emptyStack) {
            this.emptyStack = emptyStack;
        }
    }

    @BeforeMethod
    public void setUp(ITestContext ctx) throws StackOverflowException {
        Stack<Integer> stack = new StackImpl<Integer>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Stack<Integer> emptyStack = new StackImpl<Integer>(0);

        StackImplTestFixture fixture = new StackImplTestFixture();
        fixture.setStack(stack);
        fixture.setEmptyStack(emptyStack);
        ctx.setAttribute("fixture", fixture);
    }

    @Test(expectedExceptions = StackUnderflowException.class)
    public void mustFailForPoppingEmptyStack(ITestContext ctx) throws StackUnderflowException {
        StackImplTestFixture fixture = (StackImplTestFixture) ctx.getAttribute("fixture");
        Stack<Integer> emptyStack = fixture.getEmptyStack();
        emptyStack.pop();
    }

    @Test
    public void mustPopDataFromANonEmptyStack(ITestContext ctx) throws StackUnderflowException {
        StackImplTestFixture fixture = (StackImplTestFixture) ctx.getAttribute("fixture");
        Stack<Integer> stack = fixture.getStack();
        Integer peekedData = stack.peek();
        Integer data = stack.pop();
        assertEquals(data, peekedData);
    }

    @Test(expectedExceptions = StackUnderflowException.class)
    public void mustFailForPeekingEmptyStack(ITestContext ctx) throws StackUnderflowException {
        StackImplTestFixture fixture = (StackImplTestFixture) ctx.getAttribute("fixture");
        Stack<Integer> emptyStack = fixture.getEmptyStack();
        emptyStack.peek();
    }

    @Test
    public void mustPeekDataFromANonEmptyStack(ITestContext ctx) throws StackUnderflowException, StackOverflowException {
        Stack<Integer> peekStack = new StackImpl(5);
        Integer actualData = new Integer(1);
        peekStack.push(actualData);
        Integer peekedData = peekStack.peek();
        assertEquals(peekedData, actualData);
    }

    @Test
    public void mustSuccessfullyPushToStack(ITestContext ctx) throws StackUnderflowException, StackOverflowException {
        StackImplTestFixture fixture = (StackImplTestFixture) ctx.getAttribute("fixture");
        Stack<Integer> stack = fixture.getStack();
        Integer data = new Integer(4);
        stack.push(4);
        assertEquals(stack.peek(), data);
    }

    @Test
    public void mustSuccessfullyGetStackSize(ITestContext ctx) throws StackUnderflowException, StackOverflowException {
        StackImplTestFixture fixture = (StackImplTestFixture) ctx.getAttribute("fixture");
        Stack<Integer> stack = fixture.getStack();
        assertEquals(stack.size(), 3);
        stack.push(4);
        stack.push(10);
        assertEquals(stack.size(), 5);
        stack.pop();
        stack.pop();
        assertEquals(stack.size(), 3);
    }

    @Test(expectedExceptions = StackOverflowException.class)
    public void mustFailWhenElementsMoreThanSizeIsAdded(ITestContext ctx) throws StackOverflowException {
        StackImplTestFixture fixture = (StackImplTestFixture) ctx.getAttribute("fixture");
        Stack<Integer> stack = fixture.getStack();
        stack.push(4);
        stack.push(5);
        stack.push(6);
    }
}