package com.basic.stack;

/**
 * 用一个数组实现两个栈
 * 将数组的起始位置看作是第一个栈的栈底，将数组的尾部看作第二个栈的栈底，压栈时，栈顶指针分别向中间移动，直到两栈顶指针相遇，则扩容。
 *
 * @author liuxin
 */
public class TwoStackInOneArray {

    Object[] data = new Object[10];

    private int top1;

    private int top2;

    private int size;

    public TwoStackInOneArray() {
        size = 10;
        top1 = -1;
        top2 = size;
    }

    private void expand() {
        Object[] newData = new Object[size * 2];
        size <<= 2;
        System.arraycopy(data, 0, newData, 0, top1 + 1);
        int newTop2 = newData.length - (data.length - top1);
        System.arraycopy(data, top2, newData, newTop2, data.length - top2);
        top2 = newTop2;
        data = newData;
    }

    /**
     * 向第一个栈中压入元素
     *
     * @param o
     */
    public void push1(Object o) {
        if (top1 + 1 == top2) {
            expand();
        }
        data[++top1] = o;
    }

    /**
     * 从第一个栈中弹出元素
     *
     * @return
     */
    public Object pop1() {
        if (top1 == -1) throw new RuntimeException("Stack1 is empty!");
        return data[top1--];
    }

    /**
     * 获取第一个栈的栈顶元素
     *
     * @return
     */

    public Object peek1() {
        if (top1 == -1) throw new RuntimeException("Stack1 is empty!");

        return data[top1];
    }

    /*
     * 向第二个栈压入元素
     */
    public void push2(Object o) {
        if (top2 - 1 == top1) {
            expand();
        }
        data[--top2] = o;
    }

    /**
     * 从第二个栈弹出元素
     *
     * @return
     */
    public Object pop2() {
        if (top2 == size) throw new RuntimeException("Stack2 is empty!");
        return data[top2++];
    }

    /**
     * 获取第二个栈的栈顶元素
     *
     * @return
     */
    public Object peek2() {
        if (top2 == size) throw new RuntimeException("Stack2 is empty!");
        return data[top2];
    }


}
