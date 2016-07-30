package com.muru.datastructures.tree;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 2/8/16.
 */
public interface BinaryTree<T extends Comparable<T>> {
    /**
     * Fetches the root of the tree
     * @return
     */
    TreeNode<T> getRoot();

    /**
     * Sets the root of the tree
     * @param root
     */
    void setRoot(TreeNode<T> root);

    /**
     * Inserts an element into the tree
     * @param data
     */
    void insert(T data);

    /**
     * Returns the result of inorder traversal as a list
     * @return
     */
    List<T> inorderTraversal();

    /**
     * Returns the result of preorder traversal as a list
     * @return
     */
    List<T> preOrderTraversal();

    /**
     * Returns the result of post traversal as a list
     * @return
     */
    List<T> postOrderTraversal();

    /**
     * Returns the size of the tree
     * @return
     */
    int size();

    /**
     * Returns the maximum depth of the tree
     * @return
     */
    int maxDepth();

    /**
     * Returns true if the element is present in the three
     * @param data
     * @return
     */
    boolean hasElement(T data);

    /**
     * Returns the minimum element in the tree
     * @return
     * @throws NoSuchElementException
     */
    T minValue() throws NoSuchElementException;

    /**
     * Returns the maximum element in the three
     * @return
     * @throws NoSuchElementException
     */
    T maxValue() throws NoSuchElementException;

    /**
     * Mirror the tree and return a new Binary tree
     * @return
     */
    BinaryTree<T> mirrorTree();

    /**
     * Checks if the given tree is identical to the input tree
     * @param inTree
     * @return
     */
    boolean isIdentical(BinaryTree<T> inTree);

    /**
     * Remove element from the tree
     * @param value
     * @return
     */
    boolean remove(T value);
}
