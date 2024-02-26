package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.jfree.data.Range; 
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


public class RangeGetLowerBoundTest {
	private Range exampleRange;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
	}
	
	@Before
	public void setUp() throws Exception{
	}
	
	@Test
	public void testLowerBoundNegative() { //Checking negative value
		exampleRange = new Range(-10, 10);
		assertEquals("Should return lowerbound of range", -10 ,exampleRange.getLowerBound(),0.000000001d);
	}
	
	@Test
	public void testLowerBoundZero() { //Checking zero value
		exampleRange = new Range(0, 10);
		assertEquals("Should return lowerbound of range", 0, exampleRange.getLowerBound(),0.000000001d);
	}
	
	@Test
	public void testLowerBoundPositive() { //Checking positive value
		exampleRange = new Range(1,10);
		assertEquals("Should return lowerbound of range", 1, exampleRange.getLowerBound(),0.000000001d);
	}
	
	@Test
	public void testEqualUpperAndLowerBound() { //Checking if upper and lower bounds are equal
		exampleRange = new Range(2,2);
		assertEquals("Should return lowerbound of range", 2, exampleRange.getLowerBound(),0.000000001d);
	}

	@After
	public void tearDown() throws Exception{
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
	}

}
