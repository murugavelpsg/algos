package com.muru.datastructures.problems.bst;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;

/**
 * Created by msivagna on 6/10/16.
 */
public class HasPathSum {
    private BinaryTree<Integer> binaryTree;

    public HasPathSum(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    /**
     * Find if a path with the given sum exists in a binary tree
     * @param sum
     * @return
     */
    public boolean hasPathSum(Integer sum) {
        return hasPathSum(binaryTree.getRoot(), sum);
    }

    private boolean hasPathSum(TreeNode root, Integer sum) {
        if (root == null) {
            if (new Integer(0).equals(sum)) {
                return true;
            } else {
                return false;
            }
        }
        sum = sum - (Integer)root.getData();
        return hasPathSum(root.getLeft(), sum) || hasPathSum(root.getRight(), sum);
    }
}
