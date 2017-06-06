package com.louisly.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LYLRUPageFrameTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAccess() {
		LYLRUPageFrame frame = new LYLRUPageFrame(3);
		frame.access(3);
		frame.access(5);
		frame.access(3);
		System.out.println(frame.toString());
		assertEquals("3,5", frame.toString());
		frame.access(5);
		System.out.println(frame.toString());
		assertEquals("5,3", frame.toString());
		frame.access(1);
		System.out.println(frame.toString());
		assertEquals("1,5,3", frame.toString());
		frame.access(4);
		System.out.println(frame.toString());
		assertEquals("4,1,5", frame.toString());
	}
}
