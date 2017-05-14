package com.easy.mini.jvm.loader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.coderising.common.core.AppUtils;
import com.easy.mini.jvm.clz.ClassFile;



public class ClassFileLoader {

	private List<String> clzPaths = new ArrayList<String>();
	
	//region 方式一：手写方式
	public byte[] readBinaryCode2(String className) throws Exception {
		String filePath = clzPaths.get(0)+AppUtils.packageName2Path(className)+".class";
		File file=new File(filePath);
		InputStream is=new FileInputStream(file);
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		byte[] buff=new byte[1024];
		int len=0;
		while((len=is.read(buff, 0, buff.length))>0){
			baos.write(buff, 0, len);
		}
		return baos.toByteArray();	
	}
	//endregion
	
	//region 方式二：使用common-io的方式
	public byte[] readBinaryCode(String className){
		className = className.replace('.', File.separatorChar)+".class";
		for(String path:this.clzPaths){
			String clzFileName=path+File.separatorChar+className;
			byte[] codes=loadClassFile(clzFileName);
			if(codes!=null){
				return codes;
			}
		}
		return null;
	}
	
	private byte[] loadClassFile(String clzFileName){
		File f=new File(clzFileName);
		try{
			return IOUtils.toByteArray(new FileInputStream(f));
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	//endregion
	
	public void addClassPath(String path) {
		if(this.clzPaths.contains(path)){
			return;
		}
		this.clzPaths.add(path);
	}
	
	public String getClassPath2(){
		StringBuilder sb=new StringBuilder();
		for (String path : clzPaths) {
			sb.append(path+";");
		}
		String sPath =sb.toString();
		return sPath.substring(0, sPath.length()-1);
	}
	
	public String getClassPath(){
		return StringUtils.join(this.clzPaths,";");
	}
	
	public ClassFile loadClass(String className){
		byte[] codes=this.readBinaryCode(className);
		ClassFileParser parser = new ClassFileParser();
		return parser.parse(codes);
	}

}
