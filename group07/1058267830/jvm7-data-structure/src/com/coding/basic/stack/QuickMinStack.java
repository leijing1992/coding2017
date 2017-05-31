package com.coding.basic.stack;

/**
 * 设计一个栈，支持栈的push和pop操作，以及第三种操作findMin, 它返回改数据结构中的最小元素
 * finMin操作最坏的情形下时间复杂度应该是O(1) ， 简单来讲，操作一次就可以得到最小值
 * @author liuxin
 *
 */
public class QuickMinStack {
	IntStack stack = new IntStack();
	public void push(int data){
		stack.push(data);
	}
	public int pop(){
		if(stack.isEmpty())
			throw new RuntimeException("QuickMinStack is empty...");
		return stack.pop();
	}
	public int findMin(){
		return stack.findMinElement();
	}
}
