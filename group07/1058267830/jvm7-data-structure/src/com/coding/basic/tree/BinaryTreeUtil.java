package com.coding.basic.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("all")
public class BinaryTreeUtil {
	/**
	 * 用递归的方式实现对二叉树的前序遍历， 需要通过BinaryTreeUtilTest测试
	 * 
	 * @param root
	 * @return
	 */
	static List<Object> result = new ArrayList<Object>();
	public static <T> List<T> preOrderVisit(BinaryTreeNode<T> root) {
		if(root != null){
			result.add(root.getData());
			preOrderVisit(root.getLeft());
			preOrderVisit(root.getRight());
		}
		return (List<T>) result;
	}

	/**
	 * 用递归的方式实现对二叉树的中遍历
	 * 
	 * @param root
	 * @return
	 */
	static List<Object> result1 = new ArrayList<Object>();
	public static <T> List<T> inOrderVisit(BinaryTreeNode<T> root) {
		if(root != null){
			inOrderVisit(root.getLeft());
			result1.add(root.getData());
			inOrderVisit(root.getRight());
		}
		return (List<T>)result1;
	}

	/**
	 * 用递归的方式实现对二叉树的后遍历
	 * 
	 * @param root
	 * @return
	 */
	static List<Object> result2 = new ArrayList<Object>();
	public static <T> List<T> postOrderVisit(BinaryTreeNode<T> root) {
		if(root != null){
			postOrderVisit(root.getLeft());
			postOrderVisit(root.getRight());
			result2.add(root.getData());
		}
		return (List<T>)result2;
	}
	/**
	 * 用非递归的方式实现对二叉树的前序遍历
	 * @param root
	 * @return
	 */
	static List<Object> result3 = new ArrayList<Object>();
	public static <T> List<T> preOrderWithoutRecursion(BinaryTreeNode<T> root) {
		
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
		stack.push(root);
		while(!stack.isEmpty()){
			BinaryTreeNode node = stack.pop();
			result3.add(node.getData());
			
			if(node.getRight() != null){
				stack.push(node.getRight());
			}
			if(node.getLeft() != null){
				stack.push(node.getLeft());
			}
		}
		
		return (List<T>)result3;
	}
	/**
	 * 用非递归的方式实现对二叉树的中序遍历
	 * @param root
	 * @return
	 */
	static List<Object> result4 = new ArrayList<Object>();
	public static <T> List<T> inOrderWithoutRecursion(BinaryTreeNode<T> root) {
		
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
		while(root != null || !stack.isEmpty()){
			if(root != null){
				stack.push(root);
				root = root.getLeft();
			}else{
				root = stack.pop();;
				result4.add(root.getData());
				root = root.getRight();
			}
			
		}
		
		return (List<T>)result4;
	}
	
}
