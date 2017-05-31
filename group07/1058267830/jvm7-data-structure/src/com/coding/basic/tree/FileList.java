package com.coding.basic.tree;
/**
 * 给定一个目录，递归的列出下面所有的子目录和文件
 */

import java.io.File;

import org.apache.commons.lang3.StringUtils;

public class FileList {
	
	
	public void list(String prePath, String filePath) {
		File f = null;
		if(StringUtils.isBlank(prePath) && StringUtils.isBlank(filePath))
			throw new RuntimeException("路径不可以全为空...");
		if(StringUtils.isBlank(prePath)){
			f = new File(filePath);
		}else if(StringUtils.isBlank(filePath)){
			f = new File(prePath);
		}else{
			f = new File(prePath + File.separator + filePath);
		}
		if(!f.exists()){
			throw new RuntimeException("路径不存在");
		}
		System.out.println(f.getName());  //输出该目录或文件的名字
		if(f.isDirectory()){
			String[] files = f.list();
			if(files != null){
				for(int i=0; i<files.length; i++){
					list(f.getPath(), files[i]);
				}
			}
		}
		
	}
	
	

	
}
