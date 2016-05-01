package com.muru.datastructures.problems;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.linkedlist.List;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by msivagna on 4/30/16.
 */
public class LinkedListProblems {
    List<Integer> list;

    public LinkedListProblems(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        this.list = list;
    }

    /**
     * Problem - 1
     * Find kth to last element in the linkedlist
     * @return
     * @throws NoSuchElementException
     */
    public Integer findKthToLastElement(int k) throws NoSuchElementException {
        Node<Integer> head = list.getHead();
        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head.getNext() == null && k > 1) {
            throw new NoSuchElementException();
        }

        Node<Integer> current = head;
        Node<Integer> runner = head;
        int count = 0;
        //First traverse the list k-1 times
        while (count < k) {
            if (runner == null) {
                throw new NoSuchElementException();
            }
            runner = runner.getNext();
            count++;
        }
        //Then traverse the list till the end
        //Start the current as well
        while (runner != null) {
            runner = runner.getNext();
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Problem - 2
     * Check if given list is a palindrome
     * @return
     */
    public boolean checkIfListIsAPalindrome() {
        Node<Integer> head = list.getHead();
        Stack stack = new Stack();

        if (head == null) {
            return false;
        }

        if (head.getNext() == null) {
            return true;
        }

        Node<Integer> slowRunner = head;
        Node<Integer> fastRunner = head;

        while (fastRunner != null && fastRunner.getNext() != null) {
            stack.push(slowRunner.getData());
            slowRunner = slowRunner.getNext();
            fastRunner = fastRunner.getNext().getNext();
        }
        //Odd sized list. Skip one slowRunner node
        if (fastRunner != null) {
            slowRunner = slowRunner.getNext();
        }

        while (slowRunner != null) {
            Integer topOfStack = (Integer) stack.pop();
            if (!slowRunner.getData().equals(topOfStack)) {
                return false;
            }
            slowRunner = slowRunner.getNext();
        }
        return true;
    }
}
