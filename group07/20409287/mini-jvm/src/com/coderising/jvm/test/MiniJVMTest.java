package com.coderising.jvm.test;

import com.coderising.jvm.engine.MiniJVM;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MiniJVMTest {
	
	static final String PATH = "/Users/xudanxia/Documents/xdx/out/production/xdx/";
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() throws Exception{
		String[] classPaths = {PATH};
		MiniJVM jvm = new MiniJVM();
		jvm.run(classPaths, "com.coderising.jvm.test.HourlyEmployee");
		
	}

}
