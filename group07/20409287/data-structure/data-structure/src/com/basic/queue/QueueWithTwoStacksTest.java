package com.basic.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xudanxia on 2017/4/30.
 */
public class QueueWithTwoStacksTest {

    @Test
    public void testEnqueue() {

        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<>();
        Assert.assertTrue(queue.isEmpty());
        queue.enQueue("我");
        queue.enQueue("是");
        queue.enQueue("谁");
        Assert.assertEquals(3, queue.size());
        Assert.assertEquals("我", queue.deQueue());
        Assert.assertEquals("是", queue.deQueue());
        Assert.assertEquals("谁", queue.deQueue());
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeue() {

        QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<>();
        Assert.assertTrue(queue.isEmpty());
        queue.enQueue("C++");
        queue.enQueue("JAVA");
        queue.enQueue("Python");
        Assert.assertEquals("C++", queue.deQueue());
        Assert.assertEquals("JAVA", queue.deQueue());
        Assert.assertEquals("Python", queue.deQueue());
        Assert.assertTrue(queue.isEmpty());
    }
}
