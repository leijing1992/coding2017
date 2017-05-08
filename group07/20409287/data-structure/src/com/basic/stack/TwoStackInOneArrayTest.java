package com.basic.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xudanxia on 2017/5/6.
 */
public class TwoStackInOneArrayTest {

    @Test
    public void test() {

        TwoStackInOneArray stack = new TwoStackInOneArray();
        for (int i = 0; i < 30; i++) {
            stack.push1(i);
            Assert.assertEquals(i, stack.peek1());
            stack.push2(i);
            Assert.assertEquals(i, stack.peek2());
        }
        for (int i = 0; i < 30; i++) {
            Assert.assertEquals(30 - i - 1, stack.pop1());
        }
        for (int i = 0; i < 30; i++) {
            Assert.assertEquals(30 - i - 1, stack.pop2());
        }

    }

}
