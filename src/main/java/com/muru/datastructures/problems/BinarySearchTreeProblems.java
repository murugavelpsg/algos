package com.muru.datastructures.problems;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 3/1/16.
 */
public class BinarySearchTreeProblems {
    private BinaryTree<Integer> binaryTree;

    public BinarySearchTreeProblems(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    /**
     * Problem - 1
     * Check if a binary tree is a binary search tree
     * @return
     */
    public boolean isBinaryTreeABst() {
        if (binaryTree.getRoot() == null) {
            return false;
        }
        return isBinaryTreeABst(binaryTree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinaryTreeABst(TreeNode<Integer> root,
                                     Integer minValue, Integer maxValue) {
        if (root == null) {
            return true;
        }

        if (!(root.getData().compareTo(minValue) >= 0 && root.getData().compareTo(maxValue) <= 0)) {
            return false;
        }

        return isBinaryTreeABst(root.getLeft(), minValue, root.getData()) &&
                isBinaryTreeABst(root.getRight(), root.getData(), maxValue);
    }

    /**
     * Problem - 2
     * Find the common ancestor in a given binary search tree. The below implementation
     * works even if the binary tree is not a binary search tree
     * @param elem1
     * @param elem2
     * @return
     */
    public TreeNode<Integer> findFirstCommonAncestor(Integer elem1, Integer elem2) {
        if (binaryTree == null || binaryTree.getRoot() == null) {
            throw new NoSuchElementException();
        }

        if (!(binaryTree.hasElement(elem1) && binaryTree.hasElement(elem2))) {
            throw new NoSuchElementException();
        }
        return findFirstCommonAncestor(binaryTree.getRoot(), elem1, elem2);
    }

    private TreeNode<Integer> findFirstCommonAncestor(TreeNode<Integer> root, Integer elem1, Integer elem2) {
        //If both the elements are on the left, recurse left
        //If both the elements are on the right recurse right
        //If both the elements are on different side then the current node is the common ancestor
        if (root == null) {
            throw new NoSuchElementException();
        }

        if (root.getData().equals(elem1) || root.getData().equals(elem2)) {
            return root;
        }

        boolean isElem1InLeftSubtree = isElemInSubtree(root.getLeft(), elem1);
        boolean isElem2InLeftSubtree = isElemInSubtree(root.getLeft(), elem2);

        if (isElem1InLeftSubtree != isElem2InLeftSubtree) {
            return root;
        }

        if (isElem1InLeftSubtree == true && isElem2InLeftSubtree == true) {
            return findFirstCommonAncestor(root.getLeft(), elem1, elem2);
        } else {
            return findFirstCommonAncestor(root.getRight(), elem1, elem2);
        }
    }

    private boolean isElemInSubtree(TreeNode<Integer> root, Integer elem) {
        if (root == null) {
            return false;
        }

        if (root.getData().equals(elem)) {
            return true;
        }

        return isElemInSubtree(root.getLeft(), elem) || isElemInSubtree(root.getRight(), elem);
    }

    /**
     * Problem - 3
     * Given a binary tree, design an algorithm which creates a linked list of all the noes at each depth
     * For eg, if you have a tree with depth D, you will have D linked lists
     * @return
     */
    public List<List<Integer>> getElementsInBinaryTreeAtEachLevel() {
        List<List<Integer>> nodesAtEachLevel = new ArrayList<List<Integer>>();
        getElementsInBinaryTreeAtEachLevel(binaryTree.getRoot(), nodesAtEachLevel, 0);
        return nodesAtEachLevel;
    }

    private void getElementsInBinaryTreeAtEachLevel(TreeNode<Integer> root, List<List<Integer>> nodesAtEachLevel, int level) {
        if (root == null) {
            return;
        }

        if (nodesAtEachLevel.size() > level) {
            nodesAtEachLevel.get(level).add(root.getData());
        } else {
            List<Integer> listAtLevel = new ArrayList<Integer>();
            listAtLevel.add(root.getData());
            nodesAtEachLevel.add(level, listAtLevel);
        }

        getElementsInBinaryTreeAtEachLevel(root.getLeft(), nodesAtEachLevel, level+1);
        getElementsInBinaryTreeAtEachLevel(root.getRight(), nodesAtEachLevel, level+1);
    }
}
