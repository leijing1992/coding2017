package com.basic.tree;

/**
 * Created by xudanxia on 2017/5/15.
 */
public class BinarySearchTree<T extends Comparable> {

    BinaryTreeNode<T> root;

    public BinarySearchTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public T findMin() {
        return findMin(root);
    }

    private T findMin(BinaryTreeNode<T> treeNode) {

        BinaryTreeNode<T> tempRoot = treeNode;
        T rootData = treeNode.data;
        while (tempRoot != null) {
            rootData = tempRoot.data;
            if (tempRoot.left == null) return rootData;
            T leftData = tempRoot.left.data;
            if (rootData.compareTo(leftData) > 0) {
                tempRoot = tempRoot.left;
            } else {
                tempRoot = tempRoot.right;
            }
        }
        return rootData;
    }

    public T findMax() {

        BinaryTreeNode<T> tempRoot = root;
        T rootData = root.data;
        while (tempRoot != null) {
            rootData = tempRoot.data;
            if (tempRoot.left == null) return rootData;
            T leftData = tempRoot.left.data;
            if (rootData.compareTo(leftData) > 0) {
                tempRoot = tempRoot.right;
            } else {
                tempRoot = tempRoot.left;
            }
        }

        return rootData;
    }

    public int height() {
        return maxDepth(root);
    }

    private int maxDepth(BinaryTreeNode<T> treeNode) {

        if (treeNode == null) {
            return 0;
        } else if (treeNode.left == null && treeNode.right == null) {
            return 1;
        } else {
            int maxLeftDepth = maxDepth(treeNode.left);
            int maxRightDepth = maxDepth(treeNode.right);
            return maxLeftDepth > maxRightDepth ? maxLeftDepth + 1 : maxRightDepth + 1;
        }
    }

    public int size() {
        return getSize(root);
    }

    private int getSize(BinaryTreeNode<T> treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return getSize(treeNode.left) + getSize(treeNode.right) + 1;
        }
    }

    public void remove(T e) {
        remove(e, root);
    }

    public BinaryTreeNode<T> remove(T t, BinaryTreeNode<T> node) {

        if (node == null)
            return node;

        int result = t.compareTo(node.data);
        if (result > 0) {
            node.right = remove(t, node.right);
        } else if (result < 0) {
            node.left = remove(t, node.left);
        } else if (node.left != null && node.right != null) {
            node.data = findMin(node.right);
            node.right = remove(node.data, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

}