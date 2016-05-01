package com.muru.datastructures.problems;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
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

    /*
        START: Problem - 1 tests
     */
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
        End: Problem - 1 tests
     */

    /*
        START: PROBLEM 2 : COMMON ANCESTOR PROBLEM
     */
    @Test
    public void mustSuccessfullyGetCommonAncestor() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(binarySearchTree);
        TreeNode<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(13, 9);
        assertEquals(commonAncestor.getData(), new Integer(10));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailForNullTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(null);
        TreeNode<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(1000, 10001);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailIfOneInputIsNotPresentInTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(binarySearchTree);
        TreeNode<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(1000, 10001);
    }

    @Test
    public void mustSuccessfullyGetCommonAncestorForOneElementTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(oneElementTree);
        TreeNode<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(100, 100);
        assertEquals(commonAncestor.getData(), new Integer(100));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustFailForEmptyBinaryTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(emptyBinaryTree);
        TreeNode<Integer> commonAncestor = binarySearchTreeProblems.findFirstCommonAncestor(100, 100);
    }
    /*
        END: PROBLEM 2 : COMMON ANCESTOR PROBLEM
     */

    /*
        START: Problem - 3 tests
     */
    @Test
    public void mustReturnEmptyListForEmptyBinaryTree() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(emptyBinaryTree);
        assertEquals(binarySearchTreeProblems.getElementsInBinaryTreeAtEachLevel().size(), 0);
    }

    @Test
    public void mustReturnAListWithAllElementsAtEachDepth() {
        BinarySearchTreeProblems binarySearchTreeProblems = new BinarySearchTreeProblems(binarySearchTree);
        List<List<Integer>> nodesAtEachLevel = binarySearchTreeProblems.getElementsInBinaryTreeAtEachLevel();
        assertEquals(nodesAtEachLevel.size(), binarySearchTree.maxDepth());
        assertEquals(nodesAtEachLevel.get(0).size(), 1);
        assertEquals(nodesAtEachLevel.get(1).size(), 2);
        assertEquals(nodesAtEachLevel.get(2).size(), 3);
        assertEquals(nodesAtEachLevel.get(3).size(), 3);
    }
    /*
        END: Problem - 3 tests
     */
}