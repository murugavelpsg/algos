package com.muru.problems.linkedlist;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.linkedlist.List;

/**
 * Created by msivagna on 7/28/16.
 */
public class ReverseSinglyLinkedListIteratively {
    public void reverse(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        Node<Integer> previous = null;
        Node<Integer> current = list.getHead();
        Node<Integer> next = current.getNext();
        while (current != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            next = (current == null) ? null : current.getNext();
        }
        list.setHead(previous);
    }
}
