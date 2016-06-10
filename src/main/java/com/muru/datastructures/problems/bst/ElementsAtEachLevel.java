package com.muru.datastructures.problems.bst;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msivagna on 6/10/16.
 */
public class ElementsAtEachLevel {
    private BinaryTree<Integer> binaryTree;

    public ElementsAtEachLevel(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    /**
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
