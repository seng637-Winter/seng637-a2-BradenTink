package org.jfree.data;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.jfree.data.DataUtilities;

import org.junit.Test;

public class DataUtilitiesTestNumberArray2D extends DataUtilities {

	@Test
	public void testCreateNumberArray2D() {
		double[][] input = {{1.0, 2.0, 3.0}, {4.0,5.0,6.0}};
		Number[][] expected = {{1.0, 2.0, 3.0}, {4.0,5.0,6.0}};
		Number[][] result = DataUtilities.createNumberArray2D(input);
		
		System.out.println(Arrays.deepToString(expected));
		System.out.println(Arrays.deepToString(result));
		assertArrayEquals("The 2D Number array should match the input 2D array", expected, result);
		
	}

	@Test
	public void testCreateNumberArrayEmpty2D() {
		double[][] input = {{}, {}};
		Number[][] expected = {{}, {}};
		Number[][] result = DataUtilities.createNumberArray2D(input);
		
		System.out.println(Arrays.deepToString(expected));
		System.out.println(Arrays.deepToString(result));
		assertArrayEquals("The Balnk Number array should match the input array", expected, result);
		
	}
	@Test
	public void testCreateNumberArraySecondColumnEmpty() {
		double[][] input = {{1.0, 2.0, 3.0}, {}};
		Number[][] expected = {{1.0, 2.0, 3.0}, {}};
		Number[][] result = DataUtilities.createNumberArray2D(input);
		
		System.out.println(Arrays.deepToString(expected));
		System.out.println(Arrays.deepToString(result));
		assertArrayEquals("The 2D array with the second column missing should match the input array", expected, result);
		
	}
	@Test
	public void testCreateNumberArrayFirstColumnEmpty() {
		double[][] input = {{}, {4.0, 5.0, 6.0}};
		Number[][] expected = {{}, {4.0, 5.0, 6.0}};
		Number[][] result = DataUtilities.createNumberArray2D(input);
		
		System.out.println(Arrays.deepToString(expected));
		System.out.println(Arrays.deepToString(result));
		assertArrayEquals("The 2D array with the first row missing should match the input array", expected, result);
		
	}
	@Test
	public void testCreateIrregularShapeArray2D() {
		double[][] input = {{1.0, 2.0}, {4.0,5.0,6.0,7.0}};
		Number[][] expected = {{1.0, 2.0}, {4.0,5.0,6.0,7.0}};
		Number[][] result = DataUtilities.createNumberArray2D(input);
		
		System.out.println(Arrays.deepToString(expected));
		System.out.println(Arrays.deepToString(result));
		assertArrayEquals("The 2D missed shape array should match the input array", expected, result);
		
	}
}
