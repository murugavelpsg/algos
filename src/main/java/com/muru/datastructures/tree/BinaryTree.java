package com.muru.datastructures.tree;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 2/8/16.
 */
public interface BinaryTree<T extends Comparable<T>> {
    Node<T> getRoot();
    void setRoot(Node<T> root);
    void insert(T data);
    List<T> inorderTraversal();
    List<T> preOrderTraversal();
    List<T> postOrderTraversal();
    int size();
    int maxDepth();
    T minValue() throws NoSuchElementException;
    T maxValue() throws NoSuchElementException;
    BinaryTree<T> mirrorTree();
    boolean isIdentical(BinaryTree<T> inTree);
}
