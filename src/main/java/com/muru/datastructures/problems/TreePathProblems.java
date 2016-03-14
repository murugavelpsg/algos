package com.muru.datastructures.problems;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msivagna on 2/10/16.
 */
public class TreePathProblems {
    private BinaryTree<Integer> binaryTree;

    public TreePathProblems(BinaryTree<Integer> binaryTree) {
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

    /**
     * Get all the paths in a given binary tree from root
     * @return
     */
    public List<List<Integer>> getPaths() {
        List<List<Integer>> pathList = new ArrayList<List<Integer>>();
        List<Integer> currentPath = new ArrayList<Integer>();
        getPaths(binaryTree.getRoot(), pathList, currentPath);
        return pathList;
    }

    private void getPaths(Node root, List<List<Integer>> pathList, List<Integer> currentPath) {
        //Base condition
        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            currentPath = new ArrayList<Integer>(currentPath);
            currentPath.add((Integer)root.getData());
            pathList.add(currentPath);
            return;
        }
        //Recursion
        currentPath = new ArrayList<Integer>(currentPath);
        currentPath.add((Integer)root.getData());
        getPaths(root.getLeft(), pathList, currentPath);
        getPaths(root.getRight(), pathList, currentPath);
    }

    public void setBinaryTree(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }
}
