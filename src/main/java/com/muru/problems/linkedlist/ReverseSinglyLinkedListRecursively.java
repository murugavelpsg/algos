package com.muru.problems.linkedlist;

import com.muru.datastructures.common.Node;
import com.muru.datastructures.linkedlist.List;

/**
 * Created by msivagna on 7/29/16.
 * Reverse a singly linked list recursively
 */
public class ReverseSinglyLinkedListRecursively<T> {
    public void reverse(List<T> list) {
        if (list == null) {
            return;
        }
        Node<T> newHead = recursiveReverseHelper(list.getHead());
        list.setHead(newHead);
    }

    private Node<T> recursiveReverseHelper(Node<T> node) {
        if (node == null) {
            return null;
        }

        if (node.getNext() == null) {
            return node;
        }

        Node retval = recursiveReverseHelper(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return retval;
    }
}
