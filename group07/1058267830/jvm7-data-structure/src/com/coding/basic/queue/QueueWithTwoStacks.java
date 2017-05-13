package com.coding.basic.queue;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 * @author liuxin
 *
 * @param <E>
 */
public class QueueWithTwoStacks<E> {
	private Stack<E> stack1;    
    private Stack<E> stack2;    

    
    public QueueWithTwoStacks() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }

    public boolean isEmpty() { 
        return stack1.size() == 0;
    }


    
    public int size() {
        return stack1.size();   
    }



    public void enQueue(E item) {
        stack1.push(item);
    }

    public E deQueue() {
        while(!stack1.isEmpty()){
        	E tmp = stack1.pop();
        	stack2.push(tmp);
        }
        E res = stack2.pop();
        while(!stack2.isEmpty()){
        	E tmp = stack2.pop();
        	stack1.push(tmp);
        }
        return res;
    }


 }

