package com.coding.basic.stack;

import com.coding.basic.queue.Queue;



/**
 * 用两个队列实现一个栈
 * @author Administrator
 *
 */
public class StackWithTwoQueues {
	Queue<Integer> queue1 = new Queue<Integer>();
	Queue<Integer> queue2 = new Queue<Integer>();
	
 
    public void push(int data) {       
    	queue1.enQueue(data);
    }

    public int pop() {
    	if(queue1.size() == 0)
    		throw new RuntimeException("the stack is empty, can not pop...");
       while(queue1.size() != 1){
    	   int tmp = queue1.deQueue();
    	   queue2.enQueue(tmp);
       }
       int result = queue1.deQueue();
       while(!queue2.isEmpty()){
    	   int tmp = queue2.deQueue();
    	   queue1.enQueue(tmp);
       }
       return result;
    }

    
}
