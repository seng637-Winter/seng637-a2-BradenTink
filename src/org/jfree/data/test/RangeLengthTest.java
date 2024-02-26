package org.jfree.data.test;

import static org.junit.Assert.*; 

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.jfree.data.Range; 
import org.junit.*;

public class RangeLengthTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    

    @Before
    public void setUp() throws Exception { exampleRange = new Range(0, 10);
    }
    
    @Test 
    public void testValidRange() {
    	exampleRange = new Range(0, 10);
    	assertEquals("Should give a valid range ", 10, exampleRange.getLength(),0.000000001d);
    }
    @Test 
    public void testFloatingPointRange() {
    	exampleRange = new Range(2.5, 7.5);
    	assertEquals("Range test given between decimals", 5, exampleRange.getLength(),0.000000001d);
    }
    @Test 
    public void testZeroLengthRange() {
    	exampleRange = new Range(5, 5);
    	assertEquals("Shuld return a range of zero", 0, exampleRange.getLength(),0.000000001d);
    }
    
    @Test 
    public void testNegativeStartRange() {
    	exampleRange = new Range(-2, 0);
    	assertEquals("Given a negative calue should retrun a valid range", 2, exampleRange.getLength(),0.000000001d);
    }
    
    @Test 
    public void testLargeValueRange() {
    	exampleRange = new Range(0, 10000000);
    	assertEquals("Should return a value given a very rlarge range", 10000000, exampleRange.getLength(),0.000000001d);
    	
    }
    @Test 
    public void testBoundaryRange() {
    	exampleRange = new Range(0, 1);
    	assertEquals("Shoudl return the Smallest possible valid range", 1, exampleRange.getLength(),0.000000001d);
    	
    }
    @Test 
    public void testRandomRange() {
    	exampleRange = new Range(3, 18);
    	assertEquals("Should return the correct range of a random input of values", 15, exampleRange.getLength(),0.000000001d);
    	
    }

	@After
	public void tearDown() throws Exception{
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
	}

}