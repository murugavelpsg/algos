package com.muru.problems.linkedlist;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.linkedlist.List;

import java.util.Stack;

/**
 * Created by msivagna on 6/10/16.
 */
public class CheckIfListIsAPalindrome {
    List<Integer> list;

    public CheckIfListIsAPalindrome(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        this.list = list;
    }

    /**
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
