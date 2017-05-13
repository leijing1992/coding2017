package com.basic.stack;

/**
 * Created by xudanxia on 2017/5/6.
 */

import com.basic.Stack;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 设计一个栈，支持栈的push和pop操作，以及第三种操作findMin, 它返回改数据结构中的最小元素
 * finMin操作最坏的情形下时间复杂度应该是O(1) ， 简单来讲，操作一次就可以得到最小值
 * @author liuxin
 *
 */
public class QuickMinStack {

    private int min = 0;

    private Stack<Integer> stack;

    private List<Integer> list;

    public QuickMinStack() {
        list = new ArrayList<>();
        stack = new Stack<>();
    }
    public void push(int data){
        list.add(data);
        Collections.sort(list);
        stack.push(data);
    }
    public int pop(){
        int data = stack.pop();
        list.remove(new Integer(data));
        return data;
    }
    public int findMin(){
        return list.get(0);
    }
}