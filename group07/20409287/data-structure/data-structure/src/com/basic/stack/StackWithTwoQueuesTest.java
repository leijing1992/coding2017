package com.basic.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xudanxia on 2017/5/6.
 */
public class StackWithTwoQueuesTest {

    @Test
    public void test() {

        StackWithTwoQueues<String> stack = new StackWithTwoQueues<>();
        stack.push("java");
        stack.push("C++");
        stack.push("python");
        Assert.assertEquals("python", stack.pop());
        Assert.assertEquals("C++", stack.pop());
        Assert.assertEquals("java", stack.pop());
    }
}
