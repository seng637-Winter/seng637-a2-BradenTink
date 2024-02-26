package org.jfree.data.test;

import org.jfree.data.Range;

public class Sandbox {
    public static void main(String[] args) {
    	Range myRange = new Range(-1, 1);
    	Range myShiftedRange = Range.shift(myRange, 2);
    	System.out.println("test = " + myRange.hashCode());
    }
}
