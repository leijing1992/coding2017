package com.basic.queue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 *
 * @param <E>
 * @author liuxin
 */
public class QueueWithTwoStacks<E> {

    private Stack<E> dataStack;

    private Stack<E> tempStack;

    public QueueWithTwoStacks() {
        dataStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    public int size() {
        return dataStack.size();
    }

    public void enQueue(E item) {

        while (!dataStack.isEmpty()) {
            tempStack.push(dataStack.pop());
        }
        dataStack.push(item);
        while (!tempStack.isEmpty()) {
            dataStack.push(tempStack.pop());
        }
    }

    public E deQueue() {
        if (isEmpty()) throw new EmptyStackException();
        return dataStack.pop();
    }

}

