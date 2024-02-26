package org.jfree.data.test;

import org.jfree.data.Values2D;
import org.jfree.data.DataUtilities;

import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataUtilitiesTestRowTotal {
	private Mockery context;
	
	@Before
	public void setUp() {
		context = new Mockery();
	}
	
	@Test
	public void testCalculateRowTotalWithValidData() {
		final Values2D values = context.mock(Values2D.class);
		context.checking(new Expectations() {{
			// Setup 2 rows
			oneOf(values).getRowCount(); will(returnValue(1));
			
			// Setup 3 columns
			oneOf(values).getColumnCount(); will(returnValue(3));
			
            // Setup expectations for the values in row 0
            oneOf(values).getValue(0, 0); will(returnValue(1.0));
            oneOf(values).getValue(0, 1); will(returnValue(2.0));
            oneOf(values).getValue(0, 2); will(returnValue(3.0));
			
			}});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("The row total should be 6.0", 6.0, result, 0.00001d);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCalculateRowTotalWithNullData() {
	    DataUtilities.calculateRowTotal(null, 0);
	}
	
	@Test
	public void testCalculateRowWithInvalidRow() {
	    final Values2D values = context.mock(Values2D.class);
	    context.checking(new Expectations() {{
	        // Setup 1 row
	        oneOf(values).getRowCount(); will(returnValue(1));
	        
			// Setup column
			oneOf(values).getColumnCount();
	    }});

	    double result = DataUtilities.calculateRowTotal(values, 1);
	    assertEquals("The row total should be 0.0 for an invalid row", 0.0, result, 0.00001d);
	}
}
