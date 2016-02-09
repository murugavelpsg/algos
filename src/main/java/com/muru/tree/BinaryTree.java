package com.muru.tree;

import java.util.List;

/**
 * Created by msivagna on 2/8/16.
 */
public interface BinaryTree<T extends Comparable<T>> {
    void insert(T data);
    void inorderTraversal(List<T> output);
    void preOrderTraversal(List<T> output);
    void postOrderTraversal(List<T> output);
}
