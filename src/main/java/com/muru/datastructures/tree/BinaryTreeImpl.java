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
        inorderTraversal(root, output);
        return output;
    }

    public List<T>  preOrderTraversal() {
        List<T> output = new ArrayList<T>();
        preOrderTraversal(root, output);
        return output;
    }

    public List<T>  postOrderTraversal() {
        List<T> output = new ArrayList<T>();
        postOrderTraversal(root, output);
        return output;
    }

    public int size() {
        return size(root);
    }

    public int maxDepth() {
        return maxDepth(root);
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

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree mirrorTree() {
        BinaryTree<T> mirrorTree = new BinaryTreeImpl<T>();
        mirrorTree.setRoot(mirrorTree(this.root));
        return mirrorTree;
    }

    public boolean isIdentical(BinaryTree inTree) {
        return isIdentical(this.root, inTree.getRoot());
    }

    private boolean isIdentical(Node<T> root1, Node<T> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if (!root1.getData().equals(root2.getData())) {
            return false;
        }

        if (!isIdentical(root1.getLeft(), root2.getLeft()) ||
                !isIdentical(root1.getRight(), root2.getRight())) {
            return false;
        }

        return true;
    }

    private Node<T> mirrorTree(Node<T> root) {
        if (root == null) {
            return null;
        }
        Node<T> newNode = new Node<T>(root.getData());
        newNode.setRight(mirrorTree(root.getLeft()));
        newNode.setLeft(mirrorTree(root.getRight()));
        return newNode;
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

    private void inorderTraversal(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, output);
        output.add(root.data);
        inorderTraversal(root.right, output);
    }

    private void preOrderTraversal(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        output.add(root.data);
        preOrderTraversal(root.left, output);
        preOrderTraversal(root.right, output);
    }

    private void postOrderTraversal(Node<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left, output);
        postOrderTraversal(root.right, output);
        output.add(root.data);
    }

    private int size(Node<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }

    private int maxDepth(Node<T> root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
