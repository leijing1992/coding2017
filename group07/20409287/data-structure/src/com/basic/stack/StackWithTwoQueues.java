package com.basic.stack;


import com.basic.queue.Queue;

public class StackWithTwoQueues<E> {
	
    private Queue<E> queue1;

    private Queue<E> queue2;

    public StackWithTwoQueues() {
        queue1 = new Queue<>();
        queue2 = new Queue<>();
    }

    public void push(E data) {
        if (queue1.isEmpty()) {
            queue2.enQueue(data);
        } else {
            queue1.enQueue(data);
        }
    }

    public E pop() {
        if (queue1.isEmpty()) {
            return trans(queue2, queue1);
        } else {
            return trans(queue1, queue2);
        }
    }

    private E trans(Queue<E> notEmptyQueue, Queue<E> emptyQueue) {
        while (notEmptyQueue.size() != 1) {
            emptyQueue.enQueue(notEmptyQueue.deQueue());
        }
        return notEmptyQueue.deQueue();
    }
    
}
