package com.basic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeUtil {
    /**
     * 用递归的方式实现对二叉树的前序遍历， 需要通过BinaryTreeUtilTest测试
     *
     * @param root
     * @return
     */
    public static <T> List<T> preOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();
        preOrderVisitOfRecursion(result, root);
        return result;
    }

    private static <T> void preOrderVisitOfRecursion(List<T> result, BinaryTreeNode<T> root) {
        if (root != null) {
            result.add(root.getData());
            preOrderVisitOfRecursion(result, root.getLeft());
            preOrderVisitOfRecursion(result, root.getRight());
        }
    }

    /**
     * 用递归的方式实现对二叉树的中遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> inOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();
        inOrderVisitOfRecursion(result, root);
        return result;
    }

    private static <T> void inOrderVisitOfRecursion(List<T> result, BinaryTreeNode<T> root) {
        if (root != null) {
            inOrderVisitOfRecursion(result, root.getLeft());
            result.add(root.getData());
            inOrderVisitOfRecursion(result, root.getRight());
        }
    }

    /**
     * 用递归的方式实现对二叉树的后遍历
     *
     * @param root
     * @return
     */
    public static <T> List<T> postOrderVisit(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<T>();
        postOrderVisitOfRecursion(result, root);
        return result;
    }

    private static <T> void postOrderVisitOfRecursion(List<T> result, BinaryTreeNode<T> root) {
        if (root != null) {
            postOrderVisitOfRecursion(result, root.getLeft());
            postOrderVisitOfRecursion(result, root.getRight());
            result.add(root.getData());
        }
    }

    /**
     * 用非递归的方式实现对二叉树的前序遍历
     * 访问T->data后，将T入栈，遍历左子树；遍历完左子树返回时，栈顶元素应为T，出栈，再先序遍历T的右子树。
     * @param root
     * @return
     */
    public static <T> List<T> preOrderWithoutRecursion(BinaryTreeNode<T> root) {

        BinaryTreeNode<T> node = root;
        List<T> result = new ArrayList<T>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                result.add(node.getData());
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                node = node.getRight();
            }
        }
        return result;
    }

    /**
     * 用非递归的方式实现对二叉树的中序遍历
     * 先将T入栈，遍历左子树；遍历完左子树返回时，栈顶元素应为T，出栈，访问T->data，再中序遍历T的右子树。
     * @param root
     * @return
     */
    public static <T> List<T> inOrderWithoutRecursion(BinaryTreeNode<T> root) {

        BinaryTreeNode<T> node = root;
        List<T> result = new ArrayList<T>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                node = stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                result.add(node.getData());
                node = node.getRight();
            }
        }
        return result;
    }

}
