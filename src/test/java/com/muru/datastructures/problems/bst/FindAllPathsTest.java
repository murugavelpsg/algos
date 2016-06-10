package com.muru.datastructures.problems.bst;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 6/10/16.
 */
public class FindAllPathsTest {
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
    public void mustBeSuccessfulForAllPaths() {
        FindAllPaths findAllPaths = new FindAllPaths(pathProblemTree);
        assertEquals(findAllPaths.getPaths().size(), 4);
    }

    @Test
    public void mustBeZeroPathForEmptyBinaryTree() {
        FindAllPaths findAllPaths = new FindAllPaths(emptyBinaryTree);
        assertEquals(findAllPaths.getPaths().size(), 0);
    }
}