package com.muru.problems;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.Node;

/**
 * Created by msivagna on 3/1/16.
 */
public class BinarySearchTreeProblems {
    private BinaryTree<Integer> binaryTree;

    public BinarySearchTreeProblems(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public boolean isBinaryTreeABst() {
        if (binaryTree.getRoot() == null) {
            return false;
        }
        return isBinaryTreeABst(binaryTree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinaryTreeABst(Node<Integer> root,
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
}
