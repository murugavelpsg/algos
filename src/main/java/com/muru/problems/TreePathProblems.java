package com.muru.problems;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.Node;

/**
 * Created by msivagna on 2/10/16.
 */
public class TreePathProblems {
    private BinaryTree<Integer> binaryTree;

    public TreePathProblems(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public boolean hasPathSum(Integer sum) {
        return hasPathSum(binaryTree.getRoot(), sum);
    }

    private boolean hasPathSum(Node root, Integer sum) {
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
