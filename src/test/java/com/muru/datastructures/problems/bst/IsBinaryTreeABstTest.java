package com.muru.datastructures.problems.bst;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 6/10/16.
 */
public class IsBinaryTreeABstTest {

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
        IsBinaryTreeABst isBinaryTreeABst = new IsBinaryTreeABst(binarySearchTree);
        assertTrue(isBinaryTreeABst.isBinaryTreeABst());
    }

    @Test
    public void mustFailBstTestForANonBST() {
        IsBinaryTreeABst isBinaryTreeABst = new IsBinaryTreeABst(binarySearchTree.mirrorTree());
        assertFalse(isBinaryTreeABst.isBinaryTreeABst());
    }

    @Test
    public void mustFailBstTestForAEmptyBinaryTree() {
        IsBinaryTreeABst isBinaryTreeABst = new IsBinaryTreeABst(emptyBinaryTree);
        assertFalse(isBinaryTreeABst.isBinaryTreeABst());
    }

    @Test
    public void mustPassBstTestForAOneElementBst() {
        IsBinaryTreeABst isBinaryTreeABst = new IsBinaryTreeABst(oneElementTree);
        assertTrue(isBinaryTreeABst.isBinaryTreeABst());
    }

}