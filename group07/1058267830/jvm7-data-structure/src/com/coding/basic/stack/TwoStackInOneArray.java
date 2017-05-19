package com.coding.basic.stack;

/**
 * 用一个数组实现两个栈
 * 将数组的起始位置看作是第一个栈的栈底，将数组的尾部看作第二个栈的栈底，压栈时，栈顶指针分别向中间移动，直到两栈顶指针相遇，则扩容。
 * @author liuxin
 *
 */
public class TwoStackInOneArray {
	Object[] data = new Object[10];
	int size1 = 0; // 栈1的长度
	int size2 = 0; // 栈2的长度
	int length = 10; // 数组总长度
	
	/**
	 * 向第一个栈中压入元素
	 * @param o
	 */
	public void push1(Object o){
		ensureLength();
		data[size1++] = o;
		
	}
	private void ensureLength() {
		if(size1 + size2 == length){
			Object[] tmp = new Object[length*2];
			System.arraycopy(data, 0, tmp, 0, size1);
			System.arraycopy(data, length-size2, tmp, length*2-size2, size2);
			length *= 2;
			data = tmp;
		}
	}
	/**
	 * 从第一个栈中弹出元素
	 * @return
	 */
	public Object pop1(){
		if(size1 == 0)
			throw new RuntimeException("stack1 is empty...");
		Object tmp = data[size1-1];
		size1--;
		return tmp;
	}
	
	/**
	 * 获取第一个栈的栈顶元素
	 * @return
	 */
	
	public Object peek1(){
		if(size1 == 0)
			throw new RuntimeException("stack1 is empty...");
		return data[size1-1];
	}
	/*
	 * 向第二个栈压入元素
	 */
	public void push2(Object o){
		ensureLength();
		data[length-size2-1] = o;
		size2++;
	}
	/**
	 * 从第二个栈弹出元素
	 * @return
	 */
	public Object pop2(){
		if(size2 == 0)
			throw new RuntimeException("stack2 is empty...");
		Object tmp = data[length-size2];
		size2--;
		return tmp;
	}
	/**
	 * 获取第二个栈的栈顶元素
	 * @return
	 */
	
	public Object peek2(){
		if(size2 == 0)
			throw new RuntimeException("stack2 is empty...");
		return data[length-size2];
	}
	
}
