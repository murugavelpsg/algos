package com.muru.datastructures.tree;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 2/8/16.
 */
public class BinaryTreeImplTest {

    private static final int MAX_DEPTH = 9;
    BinaryTree<Integer> binaryTree;
    BinaryTree<Integer> leftBalancedTree;
    BinaryTree<Integer> emptyBinaryTree;
    BinaryTree<Integer> oneElementBinaryTree;

    @BeforeClass
    public void setup() {
        binaryTree = new BinaryTreeImpl<Integer>();
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(4);
        binaryTree.insert(7);
        binaryTree.insert(6);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(5);

        emptyBinaryTree = new BinaryTreeImpl<Integer>();

        leftBalancedTree = new BinaryTreeImpl<Integer>();
        for (int i = MAX_DEPTH; i > 0; i--) {
            leftBalancedTree.insert(i);
        }

        oneElementBinaryTree = new BinaryTreeImpl<Integer>();
        oneElementBinaryTree.insert(1);
    }

    @Test
    public void testIfBinaryTreeIsABinarySearchTree() {
        List<Integer> inorderTravResult = binaryTree.inorderTraversal();;
        LinkedList<Comparable> sortedInorderTravResult = new LinkedList<Comparable>(inorderTravResult);
        Collections.sort(sortedInorderTravResult, null);
        assertEquals(inorderTravResult, sortedInorderTravResult);
    }

    @Test
    public void testIfTheSizeMatches() {
        int actualSize = binaryTree.size();
        assertEquals(actualSize, 8);
    }

    @Test
    public void testIfMaxDepthIsZeroForEmptyTree() {
        assertEquals(emptyBinaryTree.maxDepth(), 0);
    }

    @Test
    public void testIfMaxDepthIsCorrectForLeftBalancedTree() {
        //Build a left balanced binary tree
        assertEquals(leftBalancedTree.maxDepth(), MAX_DEPTH);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void minValueMustFailForEmptyBinaryTree() {
        emptyBinaryTree.minValue();
    }

    @Test
    public void mustGetMaxDepthFromOneElementBinaryTree() {
        assertEquals(oneElementBinaryTree.maxDepth(), 1);
    }

    @Test
    public void mustGetMinValueFromOneElementBinaryTree() {
        assertEquals(oneElementBinaryTree.minValue(), new Integer(1));
    }

    @Test
    public void mustGetMinValueFromAValidBinaryTree() {
        assertEquals(leftBalancedTree.minValue(), new Integer(1));
    }
}