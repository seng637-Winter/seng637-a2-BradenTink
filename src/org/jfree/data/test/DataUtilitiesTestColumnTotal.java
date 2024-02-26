package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.Test;

public class DataUtilitiesTestColumnTotal extends DataUtilities {

	 @Test //to determine if the method can sum up a column of 2 values
	    public void calculateColumnTotalForTwoValues() {
	        // setup Mocking
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);

	        mockingContext.checking(new Expectations() {{
	            oneOf(values).getRowCount();
	            will(returnValue(2)); //Initializing 2 rows
	            oneOf(values).getValue(0, 0);
	            will(returnValue(7.5)); //Setting first value to 7.5
	            oneOf(values).getValue(1, 0);
	            will(returnValue(2.5)); //Setting second value to 2.5
	        }});

	        // exercise
	        double result = DataUtilities.calculateColumnTotal(values, 0);

	        // verify
	        assertEquals(10.0, result, .000000001d);

	}
	 
	 @Test //to determine if the method can sum up a column of 3 values
	    public void calculateColumnTotalForThreeValues() {
	        // setup Mocking
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);

	        mockingContext.checking(new Expectations() {{
	            oneOf(values).getRowCount();
	            will(returnValue(3)); //Initialize 3 rows
	            oneOf(values).getValue(0, 0);
	            will(returnValue(7.5)); //Setting first value to 7.5
	            oneOf(values).getValue(1, 0);
	            will(returnValue(2.5)); //Setting second value to 2.5
	            oneOf(values).getValue(2, 0);
	            will(returnValue(5.0)); //Setting third value to 5.0
	        }});

	        // exercise
	        double result = DataUtilities.calculateColumnTotal(values, 0);

	        // verify
	        assertEquals(15.0, result, .000000001d);

	}
	 
	 @Test //to determine if the method can sum up negative values
	    public void calculateColumnTotalForNegativeValues() {
	        // setup Mocking
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);

	        mockingContext.checking(new Expectations() {{
	            oneOf(values).getRowCount();
	            will(returnValue(2)); //Initialize 2 rows
	            oneOf(values).getValue(0, 0);
	            will(returnValue(-5.0)); //Setting first value to -5.0
	            oneOf(values).getValue(1, 0);
	            will(returnValue(-2.2)); //Setting second value to -2.2
	        }});

	        // exercise
	        double result = DataUtilities.calculateColumnTotal(values, 0);

	        // verify
	        assertEquals(-7.2, result, .000000001d);

	}
	 
	 @Test //to determine if the method can deal with incorrect input as per the javadoc
	    public void calculateColumnTotalForWrongInput() {
	        // setup Mocking
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);

	        mockingContext.checking(new Expectations() {{
	            oneOf(values).getRowCount();
	            will(returnValue(2)); //Initialize 2 rows
	            oneOf(values).getValue(0, 0);
	            will(returnValue(null)); //Setting first value to null (invalid)
	            oneOf(values).getValue(1, 0);
	            will(returnValue(2.5)); //Setting second value to 2.5
	        }});

	        // exercise
	        double result = DataUtilities.calculateColumnTotal(values, 0);

	        // verify return is 0 as per javadoc
	        assertEquals(0, result, .000000001d);

	}

}
