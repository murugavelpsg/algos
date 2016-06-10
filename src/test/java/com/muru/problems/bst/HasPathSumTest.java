package com.muru.problems.bst;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;
import com.muru.problems.bst.HasPathSum;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class HasPathSumTest {
    BinaryTree<Integer> pathProblemTree;
    BinaryTree<Integer> emptyBinaryTree;

    @BeforeClass
    public void setup() {
        emptyBinaryTree = new BinarySearchTreeImpl<Integer>();

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
        pathProblemTree = new BinarySearchTreeImpl<Integer>();
        pathProblemTree.insert(8);
        pathProblemTree.insert(4);
        pathProblemTree.insert(10);
        pathProblemTree.insert(2);
        pathProblemTree.insert(9);
        pathProblemTree.insert(12);
        pathProblemTree.insert(1);
        pathProblemTree.insert(3);
        pathProblemTree.insert(13);
    }

    @Test
    public void mustGetTrueForValidSums() {
        HasPathSum hasPathSum = new HasPathSum(pathProblemTree);
        assertEquals(hasPathSum.hasPathSum(15), true);
        assertEquals(hasPathSum.hasPathSum(27), true);
    }

    @Test
    public void mustGetFalseForInvalidSums() {
        HasPathSum hasPathSum = new HasPathSum(pathProblemTree);
        assertEquals(hasPathSum.hasPathSum(1232), false);
        assertEquals(hasPathSum.hasPathSum(23423), false);
    }
}