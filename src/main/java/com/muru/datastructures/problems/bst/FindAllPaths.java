package com.muru.datastructures.problems.bst;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msivagna on 6/10/16.
 */
public class FindAllPaths {
    private BinaryTree<Integer> binaryTree;

    public FindAllPaths(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
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

    private void getPaths(TreeNode root, List<List<Integer>> pathList, List<Integer> currentPath) {
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
}
