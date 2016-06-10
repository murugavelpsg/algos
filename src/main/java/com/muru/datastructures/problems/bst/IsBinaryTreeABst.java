package com.muru.datastructures.problems.bst;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;

/**
 * Created by msivagna on 6/10/16.
 */
public class IsBinaryTreeABst {
    private BinaryTree<Integer> binaryTree;

    public IsBinaryTreeABst(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    /**
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
}
