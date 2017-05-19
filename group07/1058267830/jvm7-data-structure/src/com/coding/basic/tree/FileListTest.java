package com.coding.basic.tree;

import org.junit.Test;

public class FileListTest {

	@Test
	public void test() {
		String prePath = "F:\\";
		String filePath = "";
		FileList fileList = new FileList();
		fileList.list(prePath, filePath);
	}

}
