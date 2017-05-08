package com.basic.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xudanxia on 2017/4/30.
 */
public class CircleQueueTest {

    @Test
    public void testEnqueue() {

        CircleQueue<Integer> circleQueue = new CircleQueue<>();
        for (int i = 0; i < 10; i++) {
            circleQueue.enQueue(i);
        }
        Assert.assertTrue(!circleQueue.isEmpty());
        Assert.assertEquals(10, circleQueue.size());
    }

    @Test
    public void testDequeue() {

        final int SIZE = 10;
        CircleQueue<Integer> circleQueue = new CircleQueue<>();
        for (int i = 0; i < SIZE; i++) {
            circleQueue.enQueue(i);
        }
        Assert.assertEquals(SIZE, circleQueue.size());
        for (int i = 0; i < SIZE; i++) {
            int result = circleQueue.deQueue();
            Assert.assertEquals(i, result);
            Assert.assertEquals(SIZE - i - 1, circleQueue.size());
        }

    }
}
