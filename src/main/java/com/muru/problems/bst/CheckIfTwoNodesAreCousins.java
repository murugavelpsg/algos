package com.muru.problems.bst;

import com.muru.datastructures.tree.BinaryTree;
import com.muru.datastructures.tree.TreeNode;

/**
 * Created by msivagna on 8/1/16.
 * Given the binary Tree and the two nodes say ‘p’ and ‘q’, determine whether the two nodes
 * are cousins of each other or not.
 * What are cousin nodes ?
 *      Two nodes are said to be cousins of each other if they are at same level of the Binary Tree
 *      and have different parents.
 */
public class CheckIfTwoNodesAreCousins<T extends Comparable<T>> {
    public boolean areCousinNodes(BinaryTree<T> tree, T value1, T value2) {
        if (tree.size() <= 1) {
            return false;
        }

        LevelAndParentInfo levelAndParentInfo1 = getLevelOfTheNode(tree.getRoot(), value1, 0, null);
        LevelAndParentInfo levelAndParentInfo2 = getLevelOfTheNode(tree.getRoot(), value2, 0, null);

        if (levelAndParentInfo1 != null && levelAndParentInfo2 != null &&
                (levelAndParentInfo1.getLevel() == levelAndParentInfo2.getLevel()) &&
                (levelAndParentInfo1.getParent() != levelAndParentInfo2.getParent())) {
            return true;
        }

        return false;
    }

    /**
     * Returns level if the node is found
     * If not returns -1
     * @param root
     * @param value
     * @param level
     * @return
     */
    private LevelAndParentInfo getLevelOfTheNode(TreeNode<T> root, T value, int level, TreeNode<T> parent) {
        if (root == null) {
            return null;
        }

        if (root.getData().compareTo(value) == 0) {
            return new LevelAndParentInfo(level, parent);
        }

        LevelAndParentInfo leftLevelAndParentInfo = getLevelOfTheNode(root.getLeft(), value, level + 1, root);
        LevelAndParentInfo rightLevelAndParentInfo = getLevelOfTheNode(root.getRight(), value, level + 1, root);

        return ((leftLevelAndParentInfo == null) ? rightLevelAndParentInfo : leftLevelAndParentInfo);
    }

    private class LevelAndParentInfo {
        int level;
        TreeNode<T> parent;

        public LevelAndParentInfo(int level, TreeNode<T> parent) {
            this.level = level;
            this.parent = parent;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public TreeNode<T> getParent() {
            return parent;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }
    }
}
