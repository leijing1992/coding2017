package com.easy.mini.jvm.cmd;

import com.easy.mini.jvm.clz.ClassFile;
import com.easy.mini.jvm.constant.ClassInfo;
import com.easy.mini.jvm.constant.FieldRefInfo;
import com.easy.mini.jvm.constant.NameAndTypeInfo;
import com.easy.mini.jvm.engine.ExecutionResult;
import com.easy.mini.jvm.engine.JavaObject;
import com.easy.mini.jvm.engine.StackFrame;

public class PutFieldCmd extends TwoOperandCmd {

	public PutFieldCmd(ClassFile clzFile,String opCode) {
		super(clzFile,opCode);		
	}

	@Override
	public String toString() {
		
		return super.getOperandAsField();
	}
	@Override
	public void execute(StackFrame frame,ExecutionResult result) {	
		
		FieldRefInfo fieldRef = (FieldRefInfo)this.getConstantInfo(this.getIndex());
		
		ClassInfo clzInfo = (ClassInfo)this.getConstantInfo(fieldRef.getClassInfoIndex());
		NameAndTypeInfo nameTypeInfo = (NameAndTypeInfo)this.getConstantInfo(fieldRef.getNameAndTypeIndex());
		// for example : name
		String fieldName = nameTypeInfo.getName();
		// for example : Ljava/lang/String : 注意：我们不再检查类型
		String fieldType = nameTypeInfo.getTypeInfo();
		
		JavaObject fieldValue = frame.getOprandStack().pop();
		JavaObject objectRef = frame.getOprandStack().pop();
		
		objectRef.setFieldValue(fieldName, fieldValue);
		
	}



}
