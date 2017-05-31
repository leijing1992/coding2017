package com.easy.mini.jvm.cmd;

import com.easy.mini.jvm.clz.ClassFile;
import com.easy.mini.jvm.constant.FieldRefInfo;
import com.easy.mini.jvm.engine.ExecutionResult;
import com.easy.mini.jvm.engine.JavaObject;
import com.easy.mini.jvm.engine.StackFrame;

public class GetFieldCmd extends TwoOperandCmd {

	public GetFieldCmd(ClassFile clzFile,String opCode) {
		super(clzFile,opCode);		
	}

	@Override
	public String toString() {
		
		return super.getOperandAsField();
	}

	@Override
	public void execute(StackFrame frame,ExecutionResult result) {
		
		FieldRefInfo fieldRef = (FieldRefInfo)this.getConstantInfo(this.getIndex());
		String fieldName = fieldRef.getFieldName();
		JavaObject jo = frame.getOprandStack().pop();
		JavaObject fieldValue = jo.getFieldValue(fieldName);
		
		frame.getOprandStack().push(fieldValue);
		
		
		
	}
	

}
