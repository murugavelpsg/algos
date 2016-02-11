package com.muru.problems;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.BinaryTreeImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by msivagna on 2/10/16.
 */
public class TreePathProblemsTest {

    BinaryTree<Integer> pathProblemTree;
    TreePathProblems treePathProblems;

    @BeforeClass
    public void setup() {
        /**
         * Binary tree
         *              8
         *            /    \
         *           4     10
         *         /      /  \
         *        2     9   12
         *       /  \         \
         *      1   3          13
         */
        pathProblemTree = new BinaryTreeImpl<Integer>();
        pathProblemTree.insert(8);
        pathProblemTree.insert(4);
        pathProblemTree.insert(10);
        pathProblemTree.insert(2);
        pathProblemTree.insert(9);
        pathProblemTree.insert(12);
        pathProblemTree.insert(1);
        pathProblemTree.insert(3);
        pathProblemTree.insert(13);

        treePathProblems = new TreePathProblems(pathProblemTree);
    }

    @Test
    public void mustGetTrueForValidSums() {
        assertEquals(treePathProblems.hasPathSum(15), true);
        assertEquals(treePathProblems.hasPathSum(27), true);
    }

    @Test
    public void mustGetFalseForInvalidSums() {
        assertEquals(treePathProblems.hasPathSum(1232), false);
        assertEquals(treePathProblems.hasPathSum(23423), false);
    }
}