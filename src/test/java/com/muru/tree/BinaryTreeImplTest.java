package com.muru.tree;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 2/8/16.
 */
public class BinaryTreeImplTest {

    BinaryTree<Integer> binaryTree;

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
    }

    @Test
    public void testIfBinaryTreeIsABinarySearchTree() {
        List<Integer> inorderTravResult = new ArrayList<Integer>();
        binaryTree.inorderTraversal(inorderTravResult);
        LinkedList<Comparable> sortedInorderTravResult = new LinkedList<Comparable>(inorderTravResult);
        Collections.sort(sortedInorderTravResult, null);
        assertEquals(inorderTravResult, sortedInorderTravResult);
    }
}