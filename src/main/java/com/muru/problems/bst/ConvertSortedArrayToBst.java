package com.muru.problems.bst;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;

/**
 * Created by msivagna on 8/1/16.
 * Given a sorted array . Write a program to create balanced BST from the sorted array.
 */
public class ConvertSortedArrayToBst<T extends Comparable<T>> {
    public BinaryTree<T> convertToBst(T[] input) {
        BinaryTree<T> binaryTree = new BinarySearchTreeImpl<T>();
        if (input != null && input.length != 0) {
            convertToBst(input, 0, input.length-1, binaryTree);
        }
        return binaryTree;
    }

    private void convertToBst(T[] input, int start, int end, BinaryTree<T> binaryTree) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;
        binaryTree.insert(input[mid]);
        convertToBst(input, start, mid - 1, binaryTree);
        convertToBst(input, mid + 1, end, binaryTree);
    }
}
