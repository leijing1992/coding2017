package miniJVM.cmd;


import miniJVM.clz.ClassFile;
import miniJVM.constant.ConstantPool;

public class PutFieldCmd extends TwoOperandCmd {

	public PutFieldCmd(ClassFile clzFile, String opCode) {
		super(clzFile,opCode);		
	}

	@Override
	public String toString(ConstantPool pool) {
		
		return super.getOperandAsField(pool);
	}


}
