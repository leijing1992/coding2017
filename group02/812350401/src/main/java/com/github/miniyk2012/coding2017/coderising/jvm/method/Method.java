package com.github.miniyk2012.coding2017.coderising.jvm.method;


import com.github.miniyk2012.coding2017.coderising.jvm.attr.AttributeInfo;
import com.github.miniyk2012.coding2017.coderising.jvm.attr.CodeAttr;
import com.github.miniyk2012.coding2017.coderising.jvm.clz.ClassFile;
import com.github.miniyk2012.coding2017.coderising.jvm.constant.ConstantPool;
import com.github.miniyk2012.coding2017.coderising.jvm.constant.UTF8Info;
import com.github.miniyk2012.coding2017.coderising.jvm.loader.ByteCodeIterator;

public class Method {

	private int accessFlag;
	private int nameIndex;
	private int descriptorIndex;
	
	private CodeAttr codeAttr;
	
	private ClassFile clzFile;
	
	
	public ClassFile getClzFile() {
		return clzFile;
	}

	public int getNameIndex() {
		return nameIndex;
	}
	public int getDescriptorIndex() {
		return descriptorIndex;
	}
	
	public CodeAttr getCodeAttr() {
		return codeAttr;
	}

	public void setCodeAttr(CodeAttr code) {
		this.codeAttr = code;
	}

	public Method(ClassFile clzFile,int accessFlag, int nameIndex, int descriptorIndex) {
		this.clzFile = clzFile;
		this.accessFlag = accessFlag;
		this.nameIndex = nameIndex;
		this.descriptorIndex = descriptorIndex;
	}


	
	public String toString() {
		
		ConstantPool pool = this.clzFile.getConstantPool();
		StringBuilder buffer = new StringBuilder();
		
		// String name = ((UTF8Info)pool.getConstantInfo(this.nameIndex)).getValue();
		String name = pool.getUTF8String(nameIndex);
		// String desc = ((UTF8Info)pool.getConstantInfo(this.descriptorIndex)).getValue();
		String desc = pool.getUTF8String(descriptorIndex);
		buffer.append(name).append(":").append(desc).append("\n");
		
		buffer.append(this.codeAttr.toString(pool));
		
		return buffer.toString();
	}
	
	public static Method parse_V2(ClassFile clzFile, ByteCodeIterator iter){
		int accessFlag = iter.nextU2toInt();
		int nameIndex = iter.nextU2toInt();
		int descIndex = iter.nextU2toInt();
		int attribCount = iter.nextU2toInt();
		
		
		Method m = new Method(clzFile, accessFlag, nameIndex, descIndex);
		
		for( int j=1; j<= attribCount; j++) {
            int attrNameIndex = iter.nextU2toInt();
			String attrName = clzFile.getConstantPool().getUTF8String(attrNameIndex);
			iter.skip(-2);

			if (AttributeInfo.CODE.equalsIgnoreCase(attrName)) {
				CodeAttr codeAttr = CodeAttr.parse(clzFile, iter);
				m.setCodeAttr(codeAttr);
			} else {
				throw new RuntimeException("only CODE attribute is implemented , please implement the " + attrName);
			}

		}
		return m ;
	}
	public static Method parse(ClassFile clzFile, ByteCodeIterator iter){
		int accessFlag = iter.nextU2toInt();
		int nameIndex = iter.nextU2toInt();
		int descriptorIndex = iter.nextU2toInt();
		int attributeCount = iter.nextU2toInt();

		Method method = new Method(clzFile, accessFlag, nameIndex, descriptorIndex);
		for (int i=0; i<attributeCount; i++) {
			int attributeNameIndex = iter.nextU2toInt();
			String attributeName = clzFile.getConstantPool().getUTF8String(attributeNameIndex);
            iter.skip(-2);  // 把游标指向属性开头位置
			if (AttributeInfo.CODE.equalsIgnoreCase(attributeName)) {
				CodeAttr codeAttr = CodeAttr.parse(clzFile, iter);
				method.setCodeAttr(codeAttr);
			} else {
				throw new RuntimeException("only CODE attribute is implemented , please implement the " + attributeName);
			}

		}
		return method;
	}

}
