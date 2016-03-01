package com.muru.datastructures.tree;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 2/8/16.
 */
public interface BinaryTree<T extends Comparable<T>> {
    void insert(T data);
    List<T> inorderTraversal();
    List<T> preOrderTraversal();
    List<T> postOrderTraversal();
    int size();
    int maxDepth();
    T minValue() throws NoSuchElementException;
    Node getRoot();
    void setRoot(Node<T> root);
    BinaryTree<T> mirrorTree();
}
