package com.muru.problems.bst;

import com.muru.datastructures.tree.BinarySearchTreeImpl;
import com.muru.datastructures.tree.BinaryTree;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by msivagna on 8/1/16.
 */
public class CheckIfTwoNodesAreCousinsTest {
    private static final int MAX_DEPTH = 9;

    @BeforeMethod
    public void setup(ITestContext ctx) {
        BinarySearchTreeFixture fixture = new BinarySearchTreeFixture();
        /*
            The binary tree below is composed of elements between 1 and 14
         */

        /**
         * Binary tree structure
         *                                  8
         *                      2                        12
         *                 1         4              10          14
         *                       3       5       9      11    13
         *                                  7
         *                               6
         *
         */

        BinaryTree<Integer> binaryTree = new BinarySearchTreeImpl<Integer>();
        binaryTree.insert(8);
        binaryTree.insert(2);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(7);
        binaryTree.insert(6);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(12);
        binaryTree.insert(10);
        binaryTree.insert(9);
        binaryTree.insert(11);
        binaryTree.insert(14);
        binaryTree.insert(13);

        List<Integer> sortedListEquivalentOfBinaryTree = new ArrayList<Integer>();
        for (int i = 1; i <= 14; i++) {
            sortedListEquivalentOfBinaryTree.add(i);
        }

        BinaryTree<Integer> emptyBinaryTree = new BinarySearchTreeImpl<Integer>();

        BinaryTree<Integer> leftBalancedTree = new BinarySearchTreeImpl<Integer>();
        for (int i = MAX_DEPTH; i > 0; i--) {
            leftBalancedTree.insert(i);
        }

        BinaryTree<Integer> oneElementBinaryTree = new BinarySearchTreeImpl<Integer>();
        oneElementBinaryTree.insert(1);

        fixture.setBinaryTree(binaryTree);
        fixture.setEmptyBinaryTree(emptyBinaryTree);
        fixture.setLeftBalancedTree(leftBalancedTree);
        fixture.setOneElementBinaryTree(oneElementBinaryTree);
        fixture.setSortedListEquivalentOfBinaryTree(sortedListEquivalentOfBinaryTree);
        ctx.setAttribute("fixture", fixture);
    }

    @Test
    public void mustGetFalseWhenTheBinaryTreeIsEmpty(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertFalse(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getEmptyBinaryTree(), 1, 3));
    }

    @Test
    public void mustGetFalseForAOneElementBinaryTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertFalse(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getOneElementBinaryTree(), 1, 3));
    }

    @Test
    public void mustGetFalseForALeftBalancedBinaryTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertFalse(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getLeftBalancedTree(), 1, 3));
    }

    @Test
    public void mustGetFalseForIfTwoElementsAreInDifferentLevel(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertFalse(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getBinaryTree(), 1, 3));
    }

    @Test
    public void mustGetFalseForIfTwoElementsAreInSameLevelAndBelongToSameParents(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertFalse(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getBinaryTree(), 1, 4));
    }

    @Test
    public void mustGetTrueForIfTwoElementsAreInSameLevelAndBelongToDifferentParents(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertTrue(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getBinaryTree(), 10, 4));
    }

    @Test
    public void mustGetFalseForIfOneOfTheElementIsRoot(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertFalse(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getBinaryTree(), 8, 4));
    }

    @Test
    public void mustGetFalseForIfTwoElementsAreSame(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertFalse(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getBinaryTree(), 8, 8));
    }

    @Test
    public void mustGetFalseForIfOneElementsIsNotPresent(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        CheckIfTwoNodesAreCousins checkIfTwoNodesAreCousins = new CheckIfTwoNodesAreCousins();
        assertFalse(checkIfTwoNodesAreCousins.areCousinNodes(fixture.getBinaryTree(), 1, 1000));
    }
}