package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesTestNumberArray {

    @Test
    public void testCreateNumberArrayWithValidInput() {
        double[] inputData = {1.0, 2.0, 3.0, 4.0};
        Number[] expected = {1.0, 2.0, 3.0, 4.0};
        Number[] actual = DataUtilities.createNumberArray(inputData);
        assertArrayEquals("The Number array should match the input double array", expected, actual);
    }

    @Test
    public void testCreateNumberArrayWithEmptyInput() {
        double[] inputData = {};
        Number[] expected = {};
        Number[] actual = DataUtilities.createNumberArray(inputData);
        assertArrayEquals("The Number array should be empty for an empty input double array", expected, actual);
    }
    
    @Test
    public void testCreateNumberArrayWithNullInput() {
    DataUtilities.createNumberArray(null);
    } 

    @Test
    public void testCreateNumberArrayWithNegativeValues() {
        double[] inputData = {-1.0, -2.0, -3.0};
        Number[] expected = {-1.0, -2.0, -3.0};
        Number[] actual = DataUtilities.createNumberArray(inputData);
        assertArrayEquals("The Number array should correctly represent negative values", expected, actual);
    }

}
