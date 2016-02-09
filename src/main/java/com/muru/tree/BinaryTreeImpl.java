package com.muru.tree;

import java.util.List;

/**
 * Created by msivagna on 2/8/16.
 */
public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree {
    Node<T> root;
    public void insert(Comparable data) {
        root = insertHelper(root, data);
    }

    private Node<T> insertHelper(Node<T> root, Comparable<T> data) {
        if (root == null) {
            return new Node(data, null, null);
        }
        if (data.compareTo(root.data) <= 0) {
            root.left = insertHelper(root.left, data);
        } else {
            root.right = insertHelper(root.right, data);
        }
        return root;
    }

    public void inorderTraversal(List output) {
        inorderTraversalHelper(root, output);
    }

    private void inorderTraversalHelper(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, output);
        output.add(root.data);
        inorderTraversalHelper(root.right, output);
    }

    public void preOrderTraversal(List output) {
        preOrderTraversalHelper(root, output);
    }

    private void preOrderTraversalHelper(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        output.add(root.data);
        inorderTraversalHelper(root.left, output);
        inorderTraversalHelper(root.right, output);
    }

    public void postOrderTraversal(List output) {
        postOrderTraversalHelper(root, output);
    }

    private void postOrderTraversalHelper(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, output);
        inorderTraversalHelper(root.right, output);
        output.add(root.data);
    }
}
