package com.basic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public List<T> levelVisit(){
        List<T> visitResult = new ArrayList<>();
        levelVisit(visitResult);
        return visitResult;
    }

    private void levelVisit(List<T> visitResult) {

        if(root == null) return;
        LinkedList<BinaryTreeNode<T>> queue = new LinkedList<>();
        BinaryTreeNode<T> current;
        queue.offer(root);          // 根节点入队
        while(!queue.isEmpty())
        {
            current = queue.poll();     // 出队队头元素并访问
            visitResult.add(current.data);
            if(current.left != null)    // 如果当前节点的左节点不为空入队
            {
                queue.offer(current.left);
            }
            if(current.right != null)   // 如果当前节点的右节点不为空，把右节点入队
            {
                queue.offer(current.right);
            }
        }
    }

    public boolean isValid(){

        if (root == null) return true;

        List<T> inOrderResult = BinaryTreeUtil.inOrderVisit(root);
        T pre = inOrderResult.get(0);
        inOrderResult.remove(0);
        // 判断中序遍历结果是否有序
        for (T current : inOrderResult) {
            if (pre.compareTo(current) > 0) {
                return false;
            }
            pre = current;
        }
        return true;
    }

    public T getLowestCommonAncestor(T n1, T n2){
        // 找到两个结点的路径
        List<T> path1 = getNodePath(n1);
        if (path1 == null) return null;
        List<T> path2 = getNodePath(n2);
        if (path2 == null) return null;
        for (int i = path1.size() - 1; i >= 0; i--) {
            if (path2.contains(path1.get(i))) return path1.get(i);
        }
        return null;
    }

    /**
     * 获取根结点到目标结点的路径
     * @param targetNode
     * @return
     */
    private List<T> getNodePath(T targetNode) {

        BinaryTreeNode<T> currentNode = root;
        List<T> path = new ArrayList<>();
        while (currentNode != null) {
            if (currentNode.data.compareTo(targetNode) > 0) {
                path.add(currentNode.data);
                currentNode = currentNode.left;
            } else if (currentNode.data.compareTo(targetNode) < 0){
                path.add(currentNode.data);
                currentNode = currentNode.right;
            } else {
                return path;
            }
        }
        return null;
    }


    /**
     * 返回所有满足下列条件的节点的值：  n1 <= n <= n2 , n 为
     * 该二叉查找树中的某一节点
     * @param n1
     * @param n2
     * @return
     */
    public List<T> getNodesBetween(T n1, T n2){
        // 先序遍历结果中从后往前找出在两个数范围的
        List<T> preOrderResult = BinaryTreeUtil.preOrderVisit(root);
        List<T> result = new ArrayList<>();
        for (T data : preOrderResult) {
            if (data.compareTo(n1) >= 0 && data.compareTo(n2) <= 0) {
                result.add(data);
            }
        }
        return result;
    }
}