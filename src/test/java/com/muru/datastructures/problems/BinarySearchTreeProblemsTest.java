package com.muru.datastructures.problems;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.Node;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 3/1/16.
 */
public class BinarySearchTreeProblemsTest {
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
    public void mustPassBstTestForABst() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(binarySearchTree);
        assertTrue(binarySearchTreeProblems.isBinaryTreeABst());
    }

    @Test
    public void mustFailBstTestForANonBST() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(binarySearchTree.mirrorTree());
        assertFalse(binarySearchTreeProblems.isBinaryTreeABst());
    }

    @Test
    public void mustFailBstTestForAEmptyBinaryTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(emptyBinaryTree);
        assertFalse(binarySearchTreeProblems.isBinaryTreeABst());
    }

    @Test
    public void mustPassBstTestForAOneElementBst() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(oneElementTree);
        assertTrue(binarySearchTreeProblems.isBinaryTreeABst());
    }

    /*
        START: COMMON ANCESTOR PROBLEM
     */
    @Test
    public void mustSuccessfullyGetCommonAncestor() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(binarySearchTree);
        Node<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(13, 9);
        assertEquals(commonAncestor.getData(), new Integer(10));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailForNullTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(null);
        Node<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(1000, 10001);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailIfOneInputIsNotPresentInTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(binarySearchTree);
        Node<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(1000, 10001);
    }

    @Test
    public void mustSuccessfullyGetCommonAncestorForOneElementTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(oneElementTree);
        Node<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(100, 100);
        assertEquals(commonAncestor.getData(), new Integer(100));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailForEmptyBinaryTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(emptyBinaryTree);
        Node<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(100, 100);
    }
    /*
        END: COMMON ANCESTOR PROBLEM
     */
}