package com.kitchensink.test.simple;

import junit.framework.TestCase;

public class CalculatorTests extends TestCase {
	
	protected Calculator calculator = null;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		calculator = new Calculator();
	}
	
	public void testAdd() {
		assertEquals(3, calculator.add(1, 2));
	}
	
	public void testSubtract() {
		assertEquals(5, calculator.subtract(8, 3));
	}
	
	public void testMultiply() {
		assertEquals(10, calculator.multiply(2, 5));
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		calculator = null;
	}
	
}
