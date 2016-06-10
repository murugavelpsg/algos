package com.muru.problems.bst;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;

import java.util.NoSuchElementException;

/**
 * Created by msivagna on 6/10/16.
 */
public class FirstCommonAncestor {
    private BinaryTree<Integer> binaryTree;

    public FirstCommonAncestor(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    /**
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
}
