package com.basic.queue;

/**
 * 用数组实现循环队列
 *
 * @param <E>
 * @author liuxin
 */
public class CircleQueue<E> {

    private final static int DEFAULT_SIZE = 10;

    //用数组来保存循环队列的元素
    private Object[] elementData = new Object[DEFAULT_SIZE];

    private int MAX_SIZE;

    public CircleQueue() {
        // 最后一个位置留空
        this.MAX_SIZE = DEFAULT_SIZE + 1;
    }

    public CircleQueue(int size) {
        this.MAX_SIZE = size + 1;
    }

    //队头
    private int front = 0;
    //队尾
    private int rear = 0;

    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return Math.abs(rear - front);
    }

    public void enQueue(E data) {
        if (isFull()) throw new RuntimeException("队列已满!");
        elementData[rear] = data;
        rear = (rear + 1) % MAX_SIZE;
    }

    public E deQueue() {
        if (isEmpty()) throw new RuntimeException("队列为空!");
        Object result = elementData[front];
        front = (front + 1) % MAX_SIZE;
        return (E) result;
    }

    private boolean isFull() {
        return (rear + 1) % MAX_SIZE == front;
    }
}
