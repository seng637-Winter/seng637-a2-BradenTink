package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.jfree.data.Range; 
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class RangeGetUpperBoundTest {
	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testUpperBoundNegative() { //Checking negative value
		exampleRange = new Range(-20, -10);
		assertEquals("Should return upperbound of range", -10 ,exampleRange.getUpperBound(),0.000000001d);
	}
	
	@Test
	public void testUpperBoundZero() { //Checking zero value
		exampleRange = new Range(-10, 0);
		assertEquals("Should return upperbound of range", 0, exampleRange.getUpperBound(),0.000000001d);
	}
	
	@Test
	public void testUpperBoundPositive() { //Checking positive value
		exampleRange = new Range(1, 10);
		assertEquals("Should return upperbound of range", 10, exampleRange.getUpperBound(),0.000000001d);
	}
	
	@Test
	public void testEqualUpperAndLowerBound() { //Checking if upper and lower bounds are equal
		exampleRange = new Range(2, 2);
		assertEquals("Should return upperbound of range", 2, exampleRange.getUpperBound(),0.000000001d);
	}

	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
