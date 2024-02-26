package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTestCumulativePercentages extends DataUtilities {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test //to determine if the method can calculate the cumulative percentages for positive values
	public void testCumulativePercentagesPositive() {
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(3));
				allowing(data).getValue(0);
				will(returnValue(5));
				allowing(data).getValue(1);
				will(returnValue(9));
				allowing(data).getValue(2);
				will(returnValue(2));
				allowing(data).getKey(0);
				will(returnValue(0));
				allowing(data).getKey(1);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(0.3125, result.getValue(0));
	    assertEquals(0.875, result.getValue(1));
	    assertEquals(1.0, result.getValue(2));
	}

	@Test //to determine if the method can calculate the cumulative percentages for some negative values
	public void testCumulativePercentagesMixed() {
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(3));
				allowing(data).getValue(0);
				will(returnValue(5));
				allowing(data).getValue(1);
				will(returnValue(-9));
				allowing(data).getValue(2);
				will(returnValue(2));
				allowing(data).getKey(0);
				will(returnValue(0));
				allowing(data).getKey(1);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(-2.5, result.getValue(0));
	    assertEquals(2.0, result.getValue(1));
	    assertEquals(1.0, result.getValue(2));
	}
	
	@Test //to determine if the method can calculate the cumulative percentages for negative values
	public void testCumulativePercentagesNegative() {
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(3));
				allowing(data).getValue(0);
				will(returnValue(-5));
				allowing(data).getValue(1);
				will(returnValue(-9));
				allowing(data).getValue(2);
				will(returnValue(-2));
				allowing(data).getKey(0);
				will(returnValue(0));
				allowing(data).getKey(1);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(0.3125, result.getValue(0));
	    assertEquals(0.875, result.getValue(1));
	    assertEquals(1.0, result.getValue(2));
	}
	
	@Test //to determine if the method can calculate the cumulative percentages for one key/value pair
	public void testCumulativePercentagesOneKV() {
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(1));
				allowing(data).getValue(0);
				will(returnValue(5));
				allowing(data).getKey(0);
				will(returnValue(0));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(1.0, result.getValue(0)); //got infinity
	}
	
	@Test //to determine if the method can calculate the cumulative percentages for all values being zero
	public void testCumulativePercentagesAllZero() {
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(3));
				allowing(data).getValue(0);
				will(returnValue(0));
				allowing(data).getValue(1);
				will(returnValue(0));
				allowing(data).getValue(2);
				will(returnValue(0));
				allowing(data).getKey(0);
				will(returnValue(0));
				allowing(data).getKey(1);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(Double.NaN, result.getValue(0));
		assertEquals(Double.NaN, result.getValue(1));
		assertEquals(Double.NaN, result.getValue(2));
	}
	
	@Test //to determine if the method can calculate the cumulative percentages for some values of zero
	public void testCumulativePercentagesSomeZero() {
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(4));
				allowing(data).getValue(0);
				will(returnValue(0));
				allowing(data).getValue(1);
				will(returnValue(0));
				allowing(data).getValue(2);
				will(returnValue(0));
				allowing(data).getValue(3);
				will(returnValue(1));
				allowing(data).getKey(0);
				will(returnValue(0));
				allowing(data).getKey(1);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
				allowing(data).getKey(3);
				will(returnValue(3));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(0.0, result.getValue(0));
		assertEquals(0.0, result.getValue(1));
		assertEquals(0.0, result.getValue(2));
		assertEquals(1.0, result.getValue(3));
	}
	
	@Test //to determine if the method can calculate the cumulative percentages for a null input
	public void testCumulativePercentagesNull() {
		try {
            // Attempt to call the method with KeyedValues containing a null value
            DataUtilities.getCumulativePercentages(null);
        } catch (IllegalArgumentException e) {
            // Check if the exception message contains the expected message
            assertEquals("Null 'data' argument.", e.getMessage());
        }
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
