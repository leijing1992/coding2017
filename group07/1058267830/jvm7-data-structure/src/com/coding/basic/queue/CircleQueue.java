package com.coding.basic.queue;

/**
 * 用数组实现循环队列
 * @author liuxin
 *
 * @param <E>
 */
public class CircleQueue <E> {
	
	private final static int DEFAULT_SIZE = 10;
	
	//用数组来保存循环队列的元素
	private Object[] elementData;
	
	private int size = 0;
	
	//队头
	private int front = 0;  
	//队尾  
	private int rear = 0;
	
	public CircleQueue() {
		this.size = 0;
		this.elementData = new Object[DEFAULT_SIZE];
	}

	public boolean isEmpty() {
		return this.size == 0;
    }

    public int size() {
        return this.size;
    }
    

    public void enQueue(E data) {
        if(size == 0){
        	this.elementData[0] = data;
        	this.size++;
        	front = rear = 0;
        }
        if(this.size == DEFAULT_SIZE){
        	this.elementData[front] = data;
        	rear = front;
        	front++;
        }
        if(this.size < DEFAULT_SIZE){
        	this.elementData[size] = data;
        	rear++;
        	size++;
        }
    }

    public E deQueue() {
    	
    	if(size == 0){
    		throw new RuntimeException("error:queue is empty,can not delete...");
    	}
    	if(size == 1){
    		E tmp = (E)this.elementData[0];
    		this.elementData = new Object[DEFAULT_SIZE];
    		size--;
    		front = rear = 0;
    		return tmp;
    	}
    	
    	// 已经满过了
    	if(rear < front){
    		E tmp = (E)elementData[rear];
    		if(rear == 0){
    			rear = DEFAULT_SIZE -1;
    		}else{
    			rear--;
    		}
    		size--;
    		return tmp;
    	}
    	
    	// 刚好满或者未满
    	E tmp = (E)elementData[rear];
    	rear--;
    	size--;
    	return tmp;
    	
    }
}
