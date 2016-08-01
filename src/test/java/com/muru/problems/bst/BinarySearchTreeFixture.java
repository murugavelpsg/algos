package com.muru.problems.bst;

import com.muru.datastructures.tree.BinaryTree;

import java.util.List;

/**
 * Created by msivagna on 8/1/16.
 */
public class BinarySearchTreeFixture {
    BinaryTree<Integer> binaryTree;
    BinaryTree<Integer> leftBalancedTree;
    BinaryTree<Integer> emptyBinaryTree;
    BinaryTree<Integer> oneElementBinaryTree;
    List<Integer> sortedListEquivalentOfBinaryTree;

    public BinaryTree<Integer> getBinaryTree() {
        return binaryTree;
    }

    public void setBinaryTree(BinaryTree<Integer> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public BinaryTree<Integer> getLeftBalancedTree() {
        return leftBalancedTree;
    }

    public void setLeftBalancedTree(BinaryTree<Integer> leftBalancedTree) {
        this.leftBalancedTree = leftBalancedTree;
    }

    public BinaryTree<Integer> getEmptyBinaryTree() {
        return emptyBinaryTree;
    }

    public void setEmptyBinaryTree(BinaryTree<Integer> emptyBinaryTree) {
        this.emptyBinaryTree = emptyBinaryTree;
    }

    public BinaryTree<Integer> getOneElementBinaryTree() {
        return oneElementBinaryTree;
    }

    public void setOneElementBinaryTree(BinaryTree<Integer> oneElementBinaryTree) {
        this.oneElementBinaryTree = oneElementBinaryTree;
    }

    public List<Integer> getSortedListEquivalentOfBinaryTree() {
        return sortedListEquivalentOfBinaryTree;
    }

    public void setSortedListEquivalentOfBinaryTree(List<Integer> sortedListEquivalentOfBinaryTree) {
        this.sortedListEquivalentOfBinaryTree = sortedListEquivalentOfBinaryTree;
    }
}