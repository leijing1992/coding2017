package com.easy.mini.jvm.cmd;

import com.easy.mini.jvm.clz.ClassFile;
import com.easy.mini.jvm.engine.ExecutionResult;
import com.easy.mini.jvm.engine.Heap;
import com.easy.mini.jvm.engine.JavaObject;
import com.easy.mini.jvm.engine.StackFrame;

public class BiPushCmd extends OneOperandCmd {

	public BiPushCmd(ClassFile clzFile,String opCode) {
		super(clzFile,opCode);
		
	}

	@Override
	public String toString() {
	
		return this.getOffset()+":"+ this.getOpCode()+" " + this.getReadableCodeText() + " " + this.getOperand();
	}
	public void execute(StackFrame frame,ExecutionResult result){
		int value = this.getOperand();
		JavaObject jo = Heap.getInstance().newInt(value);
		frame.getOprandStack().push(jo);
		
	}
	

}
