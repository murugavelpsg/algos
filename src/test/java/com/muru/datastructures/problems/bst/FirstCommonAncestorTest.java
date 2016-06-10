package com.muru.datastructures.problems.bst;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class FirstCommonAncestorTest {
    BinaryTree<Integer> binarySearchTree;
    BinaryTree<Integer> emptyBinaryTree;
    BinaryTree<Integer> oneElementTree;

    @BeforeClass
    public void setup() {
        emptyBinaryTree = new BinarySearchTreeImpl<Integer>();

        oneElementTree = new BinarySearchTreeImpl<Integer>();
        oneElementTree.insert(100);

        /**
         * Binary tree
         *              8
         *            /    \
         *           4     10
         *         /      /  \
         *        2     9    12
         *       /  \         \
         *      1   3          13
         */
        binarySearchTree = new BinarySearchTreeImpl<Integer>();
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(10);
        binarySearchTree.insert(2);
        binarySearchTree.insert(9);
        binarySearchTree.insert(12);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(13);
        binarySearchTree.insert(Integer.MIN_VALUE);
        binarySearchTree.insert(Integer.MAX_VALUE);
    }

    @Test
    public void mustSuccessfullyGetCommonAncestor() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor(binarySearchTree);
        TreeNode<Integer> commonAncestor = firstCommonAncestor.findFirstCommonAncestor(13, 9);
        assertEquals(commonAncestor.getData(), new Integer(10));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailForNullTree() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor(null);
        TreeNode<Integer> commonAncestor = firstCommonAncestor.findFirstCommonAncestor(1000, 10001);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailIfOneInputIsNotPresentInTree() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor(binarySearchTree);
        TreeNode<Integer> commonAncestor = firstCommonAncestor.findFirstCommonAncestor(1000, 10001);
    }

    @Test
    public void mustSuccessfullyGetCommonAncestorForOneElementTree() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor(oneElementTree);
        TreeNode<Integer> commonAncestor = firstCommonAncestor.findFirstCommonAncestor(100, 100);
        assertEquals(commonAncestor.getData(), new Integer(100));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailForEmptyBinaryTree() {
        FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor(emptyBinaryTree);
        TreeNode<Integer> commonAncestor = firstCommonAncestor.findFirstCommonAncestor(100, 100);
    }
}