package com.coderising.jvm.test;

import javassist.ClassPool;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * (1) Java堆溢出 OutOfMemory
 * (2) 虚拟机栈溢出 StackOverflowError
 * (3) 永久代溢出 OutOfMemory : PermGen space
 */
public class JVMErrorTest {

    private int stackLength = 1;

    private long heapSize = 0;

    @Test
    public void testOutOfMemory() {

        List list = new ArrayList();
        int size = 8096 * 8096;
        try {
            while (true) {
                list.add(new byte[size]);
                heapSize += size;
            }
        } catch (OutOfMemoryError error) {
            Assert.assertEquals("Java heap space", error.getMessage());
            System.out.println("对象大小(Byte): " + heapSize);
        }
    }

    // 反复调用
    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    @Test
    public void testStackOverflowError() {

        try {
            stackLeak();
        } catch (StackOverflowError error) {
            Assert.assertNotNull(error);
            System.out.println("栈深度: " + stackLength);
        }
    }

    @Test
    public void testPermGenOutOfMemory() {

        for (int i = 0; i < 100_000_000; i++) {
            try {
                generate("PermGen space test!" + i);
            } catch (Throwable e) {
                Assert.assertTrue(e instanceof OutOfMemoryError);
                Assert.assertEquals("PermGen space", e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }


}
