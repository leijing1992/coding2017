package com.basic.tree;

import org.junit.Test;

import java.io.File;

/**
 * Created by xudanxia on 2017/5/10.
 */
public class FileListTest {

    @Test
    public void testList() {

        File file = new File("/Users/xudanxia/Documents/xdx/data-structure");
        FileList.list(file);
    }

}
