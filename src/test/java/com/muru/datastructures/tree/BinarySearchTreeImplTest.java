package com.muru.datastructures.tree;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

/**
 * Created by msivagna on 2/8/16.
 */
public class BinarySearchTreeImplTest {
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
    public void testIfBinaryTreeIsABinarySearchTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        List<Integer> inorderTravResult = binaryTree.inorderTraversal();;
        LinkedList<Comparable> sortedInorderTravResult = new LinkedList<Comparable>(inorderTravResult);
        Collections.sort(sortedInorderTravResult, null);
        assertEquals(inorderTravResult, sortedInorderTravResult);
    }

    @Test
    public void testIfTheSizeMatches(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        int actualSize = binaryTree.size();
        assertEquals(actualSize, 14);
    }

    @Test
    public void testIfMaxDepthIsZeroForEmptyTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> emptyBinaryTree = fixture.getEmptyBinaryTree();
        assertEquals(emptyBinaryTree.maxDepth(), 0);
    }

    @Test
    public void testIfMaxDepthIsCorrectForLeftBalancedTree(ITestContext ctx) {
        //Build a left balanced binary tree
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> leftBalancedTree = fixture.getLeftBalancedTree();
        assertEquals(leftBalancedTree.maxDepth(), MAX_DEPTH);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void minValueMustFailForEmptyBinaryTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> emptyBinaryTree = fixture.getEmptyBinaryTree();
        emptyBinaryTree.minValue();
    }

    @Test
    public void mustGetMaxDepthFromOneElementBinaryTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> oneElementBinaryTree = fixture.getOneElementBinaryTree();
        assertEquals(oneElementBinaryTree.maxDepth(), 1);
    }

    @Test
    public void mustGetMinValueFromOneElementBinaryTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> oneElementBinaryTree = fixture.getOneElementBinaryTree();
        assertEquals(oneElementBinaryTree.minValue(), new Integer(1));
    }

    @Test
    public void mustGetMinValueFromAValidBinaryTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> leftBalancedTree = fixture.getLeftBalancedTree();
        assertEquals(leftBalancedTree.minValue(), new Integer(1));
    }

    @Test
    public void mustGetNullRootElementForEmptyTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> emptyBinaryTree = fixture.getEmptyBinaryTree();
        assertEquals(emptyBinaryTree.getRoot(), null);
    }

    @Test
    public void mustGetCorrectRootValueForOneElementTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> oneElementBinaryTree = fixture.getOneElementBinaryTree();
        assertEquals(oneElementBinaryTree.getRoot().getData(), new Integer(1));
    }

    @Test
    public void mirrorNonEmptyTreeTest(ITestContext ctx) {
        /*
            Mirror the tree.
            Do inorder traversal of original tree and the mirrored tree.
            The inorder traversal of both the trees should be mirror of each other.
         */
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        BinaryTree<Integer> mirroredBinaryTree = binaryTree.mirrorTree();
        List<Integer> inOrderTravBinaryTree = binaryTree.inorderTraversal();
        List<Integer> inOrderTravMirrorTree = mirroredBinaryTree.inorderTraversal();
        Collections.reverse(inOrderTravMirrorTree);
        assertEquals(inOrderTravBinaryTree, inOrderTravMirrorTree);
    }

    @Test
    public void mirrorEmptyTreeTest(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> emptyBinaryTree = fixture.getEmptyBinaryTree();
        BinaryTree<Integer> mirroredTree = emptyBinaryTree.mirrorTree();
        assertNull(mirroredTree.getRoot());
    }

    @Test
    public void mustReturnTrueIfTreesAreIdentical(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        assertTrue(binaryTree.isIdentical(binaryTree));
    }

    @Test
    public void mustReturnFalseIfTreesAreNotIdentical(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        BinaryTree<Integer> leftBalancedTree = fixture.getLeftBalancedTree();
        assertFalse(binaryTree.isIdentical(leftBalancedTree));
    }

    @Test
    public void mustReturnFalseIfComparedAgainstAnEmptyTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> emptyBinaryTree = fixture.getEmptyBinaryTree();
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        assertFalse(binaryTree.isIdentical(emptyBinaryTree));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void mustGetExceptionIfTreeIsEmpty(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> emptyBinaryTree = fixture.getEmptyBinaryTree();
        emptyBinaryTree.maxValue();
    }

    @Test
    public void mustGetCorrectMaxValue(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        assertEquals(binaryTree.maxValue(), new Integer(14));
    }

    @Test
    public void mustSuccessfullyFindAnElementInABST(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        assertTrue(binaryTree.hasElement(7));
    }

    @Test
     public void mustReturnFalseWhenElementDoesnotExist(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        assertFalse(binaryTree.hasElement(100));
    }

    @Test
    public void mustReturnFalseForEmptyBinaryTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> emptyBinaryTree = fixture.getEmptyBinaryTree();
        assertFalse(emptyBinaryTree.hasElement(100));
    }

    @Test
    public void mustGetFalseWhenElemIsRemovedFromAnEmptyTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> emptyBinaryTree = fixture.getEmptyBinaryTree();
        assertFalse(emptyBinaryTree.remove(100));
        assertEquals(emptyBinaryTree.size(), 0);
    }

    @Test
    public void mustGetFalseWhenElemToBeRemovedIsNotPresent(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        assertFalse(binaryTree.remove(1000));
        assertEquals(binaryTree.size(), 14);
    }

    @Test
    public void mustGetTrueWhenElemIsRemovedFromAOneElementTree(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> oneElementBinaryTree = fixture.getOneElementBinaryTree();
        assertTrue(oneElementBinaryTree.remove(1));
        assertEquals(oneElementBinaryTree.size(), 0);
    }

    @Test
    public void mustGetTrueWhenElemIsRemovedHasNoChildren(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        Integer elemToBeRemoved = new Integer(1);
        assertTrue(binaryTree.remove(elemToBeRemoved));
        assertEquals(binaryTree.size(), 13);
        List<Integer> sortedList = fixture.getSortedListEquivalentOfBinaryTree();
        sortedList.remove(elemToBeRemoved);
        assertEquals(binaryTree.inorderTraversal(), sortedList);
    }

    @Test
    public void mustGetTrueWhenElemIsRemovedHasOnlyRightChild(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        Integer elemToBeRemoved = new Integer(5);
        assertTrue(binaryTree.remove(elemToBeRemoved));
        assertEquals(binaryTree.size(), 13);
        List<Integer> sortedList = fixture.getSortedListEquivalentOfBinaryTree();
        sortedList.remove(elemToBeRemoved);
        assertEquals(binaryTree.inorderTraversal(), sortedList);
    }

    @Test
    public void mustGetTrueWhenElemIsRemovedHasOnlyLeftChild(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        Integer elemToBeRemoved = new Integer(14);
        assertTrue(binaryTree.remove(elemToBeRemoved));
        assertEquals(binaryTree.size(), 13);
        List<Integer> sortedList = fixture.getSortedListEquivalentOfBinaryTree();
        sortedList.remove(elemToBeRemoved);
        assertEquals(binaryTree.inorderTraversal(), sortedList);
    }

    @Test
    public void mustGetTrueWhenElemIsRemovedHasBothRightAndLeftChildren(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        Integer elemToBeRemoved = new Integer(12);
        assertTrue(binaryTree.remove(elemToBeRemoved));
        assertEquals(binaryTree.size(), 13);
        List<Integer> sortedList = fixture.getSortedListEquivalentOfBinaryTree();
        sortedList.remove(elemToBeRemoved);
        assertEquals(binaryTree.inorderTraversal(), sortedList);
    }

    @Test
    public void mustGetTrueWhenElemToBeRemovedIsRoot(ITestContext ctx) {
        BinarySearchTreeFixture fixture = (BinarySearchTreeFixture) ctx.getAttribute("fixture");
        BinaryTree<Integer> binaryTree = fixture.getBinaryTree();
        Integer elemToBeRemoved = new Integer(8);
        assertTrue(binaryTree.remove(elemToBeRemoved));
        assertEquals(binaryTree.size(), 13);
        List<Integer> sortedList = fixture.getSortedListEquivalentOfBinaryTree();
        sortedList.remove(elemToBeRemoved);
        assertEquals(binaryTree.inorderTraversal(), sortedList);
    }

    private class BinarySearchTreeFixture {
        BinaryTree<Integer> binaryTree;
        BinaryTree<Integer> leftBalancedTree;
        BinaryTree<Integer> emptyBinaryTree;
        BinaryTree<Integer> oneElementBinaryTree;
        List<Integer> sortedListEquivalentOfBinaryTree;

        public BinaryTree<Integer> getBinaryTree() {
            return binaryTree;
        }

        public void setBinaryTree(BinaryTree<Integer> binaryTree) {
            this.binaryTree = binaryTree;
        }

        public BinaryTree<Integer> getLeftBalancedTree() {
            return leftBalancedTree;
        }

        public void setLeftBalancedTree(BinaryTree<Integer> leftBalancedTree) {
            this.leftBalancedTree = leftBalancedTree;
        }

        public BinaryTree<Integer> getEmptyBinaryTree() {
            return emptyBinaryTree;
        }

        public void setEmptyBinaryTree(BinaryTree<Integer> emptyBinaryTree) {
            this.emptyBinaryTree = emptyBinaryTree;
        }

        public BinaryTree<Integer> getOneElementBinaryTree() {
            return oneElementBinaryTree;
        }

        public void setOneElementBinaryTree(BinaryTree<Integer> oneElementBinaryTree) {
            this.oneElementBinaryTree = oneElementBinaryTree;
        }

        public List<Integer> getSortedListEquivalentOfBinaryTree() {
            return sortedListEquivalentOfBinaryTree;
        }

        public void setSortedListEquivalentOfBinaryTree(List<Integer> sortedListEquivalentOfBinaryTree) {
            this.sortedListEquivalentOfBinaryTree = sortedListEquivalentOfBinaryTree;
        }
    }
}