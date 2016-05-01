package com.muru.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by msivagna on 2/8/16.
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinaryTree {
    TreeNode<T> root;

    public void insert(Comparable data) {
        root = insert(root, data);
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

    public boolean hasElement(Comparable data) {
        return hasElement(root, data);
    }

    private boolean hasElement(TreeNode<T> root, Comparable<T> data) {
        if (root == null) {
            return false;
        }

        if (root.getData().equals(data)) {
            return true;
        }

        return hasElement(root.getLeft(), data) || hasElement(root.getRight(), data);
    }

    public T minValue() throws NoSuchElementException {
        if (root == null) {
            throw new NoSuchElementException();
        }

        TreeNode<T> temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp.data;
    }

    public T maxValue() throws NoSuchElementException {
        if (root == null) {
            throw new NoSuchElementException();
        }

        TreeNode<T> temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp.data;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public BinaryTree mirrorTree() {
        BinaryTree<T> mirrorTree = new BinarySearchTreeImpl<T>();
        mirrorTree.setRoot(mirrorTree(this.root));
        return mirrorTree;
    }

    public boolean isIdentical(BinaryTree inTree) {
        return isIdentical(this.root, inTree.getRoot());
    }

    private boolean isIdentical(TreeNode<T> root1, TreeNode<T> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if (!root1.getData().equals(root2.getData())) {
            return false;
        }

        return isIdentical(root1.getLeft(), root2.getLeft()) && isIdentical(root1.getRight(), root2.getRight());
    }

    private TreeNode<T> mirrorTree(TreeNode<T> root) {
        if (root == null) {
            return null;
        }
        TreeNode<T> newTreeNode = new TreeNode<T>(root.getData());
        newTreeNode.setRight(mirrorTree(root.getLeft()));
        newTreeNode.setLeft(mirrorTree(root.getRight()));
        return newTreeNode;
    }

    private TreeNode<T> insert(TreeNode<T> root, Comparable<T> data) {
        if (root == null) {
            return new TreeNode(data, null, null);
        }
        if (data.compareTo(root.data) <= 0) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    private void inorderTraversal(TreeNode<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, output);
        output.add(root.data);
        inorderTraversal(root.right, output);
    }

    private void preOrderTraversal(TreeNode<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        output.add(root.data);
        preOrderTraversal(root.left, output);
        preOrderTraversal(root.right, output);
    }

    private void postOrderTraversal(TreeNode<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left, output);
        postOrderTraversal(root.right, output);
        output.add(root.data);
    }

    private int size(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }

    private int maxDepth(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
