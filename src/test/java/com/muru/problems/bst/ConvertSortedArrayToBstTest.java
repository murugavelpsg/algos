package com.muru.problems.bst;

import com.muru.datastructures.tree.BinaryTree;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 8/1/16.
 */
public class ConvertSortedArrayToBstTest {
    @Test
    public void mustGetEmptyBinaryTreeIfInputIsNull() {
        Integer[] input = null;
        ConvertSortedArrayToBst<Integer> convertSortedArrayToBst = new ConvertSortedArrayToBst<Integer>();
        BinaryTree<Integer> binarySearchTree = convertSortedArrayToBst.convertToBst(input);
        assertEquals(binarySearchTree.size(), 0);
    }

    @Test
    public void mustGetEmptyBinaryTreeIfArrayIsEmpty() {
        Integer[] input = {};
        ConvertSortedArrayToBst<Integer> convertSortedArrayToBst = new ConvertSortedArrayToBst<Integer>();
        BinaryTree<Integer> binarySearchTree = convertSortedArrayToBst.convertToBst(input);
        assertEquals(binarySearchTree.size(), 0);
    }

    @Test
    public void mustGetOneElementBinaryTreeIfArrayHasOneElement() {
        Integer[] input = {1};
        ConvertSortedArrayToBst<Integer> convertSortedArrayToBst = new ConvertSortedArrayToBst<Integer>();
        BinaryTree<Integer> binarySearchTree = convertSortedArrayToBst.convertToBst(input);
        assertEquals(binarySearchTree.size(), 1);
    }

    @Test
    public void mustGetABstIfTheArrayHasMultipleElements() {
        Integer[] input = {1, 2, 3, 4, 5, 6, 7};
        ConvertSortedArrayToBst<Integer> convertSortedArrayToBst = new ConvertSortedArrayToBst<Integer>();
        BinaryTree<Integer> binaryTree = convertSortedArrayToBst.convertToBst(input);
        assertEquals(binaryTree.size(), 7);
        Integer[] inorderTraversalArr = new Integer[input.length];
        inorderTraversalArr = binaryTree.inorderTraversal().toArray(inorderTraversalArr);
        assertEquals(inorderTraversalArr, input);
    }
}