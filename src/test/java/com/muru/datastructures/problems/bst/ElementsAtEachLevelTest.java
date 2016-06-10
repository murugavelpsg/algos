package com.muru.datastructures.problems.bst;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class ElementsAtEachLevelTest {
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
    public void mustReturnEmptyListForEmptyBinaryTree() {
        ElementsAtEachLevel elementsAtEachLevel = new ElementsAtEachLevel(emptyBinaryTree);
        assertEquals(elementsAtEachLevel.getElementsInBinaryTreeAtEachLevel().size(), 0);
    }

    @Test
    public void mustReturnAListWithAllElementsAtEachDepth() {
        ElementsAtEachLevel elementsAtEachLevel = new ElementsAtEachLevel(binarySearchTree);
        List<List<Integer>> nodesAtEachLevel = elementsAtEachLevel.getElementsInBinaryTreeAtEachLevel();
        assertEquals(nodesAtEachLevel.size(), binarySearchTree.maxDepth());
        assertEquals(nodesAtEachLevel.get(0).size(), 1);
        assertEquals(nodesAtEachLevel.get(1).size(), 2);
        assertEquals(nodesAtEachLevel.get(2).size(), 3);
        assertEquals(nodesAtEachLevel.get(3).size(), 3);
    }
}