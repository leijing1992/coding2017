package com.basic.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xudanxia on 2017/5/6.
 */
public class QuickMinStackTest {

    @Test
    public void test() {

        QuickMinStack stack = new QuickMinStack();
        stack.push(3);
        stack.push(5);
        stack.push(23);
        stack.push(1);

        Assert.assertEquals(1, stack.findMin());
        stack.pop();
        Assert.assertEquals(3, stack.findMin());

    }
}
