package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.jfree.data.Range;

public class RangeConstrainTest {
    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        exampleRange = new Range(-1, 1); //Create the range from -1 to 1
    }

    @Test
    public void testAboveConstrain() { //Any value above 1 should be constrained to 1
        assertEquals("A value above the range should be constrained to 1", 1, exampleRange.constrain(2), 0.000000001d);
    }
    
    @Test
    public void testAtHighConstrain() { //Checking the boundary condition
        assertEquals("A value at the top of the range should give itself", 1, exampleRange.constrain(1), 0.000000001d);
    }
    
    @Test
    public void testBelowConstrain() { //Any value below -1 should be constrained to -1
        assertEquals("A value below the range should be constrained to -1", -1, exampleRange.constrain(-2), 0.000000001d);
    }
    
    @Test
    public void testAtLowConstrain() { //Checking the boundary condition
        assertEquals("A value at the bottom of the range should give itself", -1, exampleRange.constrain(-1), 0.000000001d);
    }
    
    @Test
    public void testInsideConstrain() { //Checking nominal value inside the boundary range
        assertEquals("A value inside the range should give itself", 0, exampleRange.constrain(0), 0.000000001d);
    }
    
    @Test
    public void testDecimalInsideConstrain() { //Checking nominal decimal value inside the boundary range
        assertEquals("A decimal value inside the range should also give itself", 0.5, exampleRange.constrain(0.5), 0.000000001d);
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}

