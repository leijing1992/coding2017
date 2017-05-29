package com.basic.tree;

import java.io.File;

public class FileList {

	public static void list(File f) {

		if (f == null) {
			return;
		}
		if (f.isDirectory()) {
			// 递归执行
			File[] files = f.listFiles();
			if (files != null) {
				for (File file : files) {
					list(file);
				}
			}

		} else {
			System.out.println(f.getName());
		}
	}

	
}
