package com.muru.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 2/8/16.
 */
public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree {
    Node<T> root;
    public void insert(Comparable data) {
        root = insertHelper(root, data);
    }

    public List<T> inorderTraversal() {
        List<T> output = new ArrayList<T>();
        inorderTraversalHelper(root, output);
        return output;
    }

    public List<T>  preOrderTraversal() {
        List<T> output = new ArrayList<T>();
        preOrderTraversalHelper(root, output);
        return output;
    }

    public List<T>  postOrderTraversal() {
        List<T> output = new ArrayList<T>();
        postOrderTraversalHelper(root, output);
        return output;
    }

    public int size() {
        return sizeHelper(root);
    }

    public int maxDepth() {
        return maxDepthHelper(root);
    }

    public T minValue() throws NoSuchElementException {
        if (root == null) {
            throw new NoSuchElementException();
        }

        Node<T> temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    public Node getRoot() {
        return root;
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

    private void inorderTraversalHelper(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, output);
        output.add(root.data);
        inorderTraversalHelper(root.right, output);
    }

    private void preOrderTraversalHelper(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        output.add(root.data);
        preOrderTraversalHelper(root.left, output);
        preOrderTraversalHelper(root.right, output);
    }

    private void postOrderTraversalHelper(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        postOrderTraversalHelper(root.left, output);
        postOrderTraversalHelper(root.right, output);
        output.add(root.data);
    }

    private int sizeHelper(Node<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + sizeHelper(root.left) + sizeHelper(root.right);
    }

    private int maxDepthHelper(Node<T> root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepthHelper(root.left);
        int rightDepth = maxDepthHelper(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
