package com.muru.problems.linkedlist;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.linkedlist.List;

import java.util.NoSuchElementException;

/**
 * Created by msivagna on 6/10/16.
 */
public class KthToLastElement {
    List<Integer> list;

    public KthToLastElement(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        this.list = list;
    }

    /**
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
}
