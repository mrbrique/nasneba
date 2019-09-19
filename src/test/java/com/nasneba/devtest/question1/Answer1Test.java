package com.nasneba.devtest.question1;

import static com.nasneba.devtest.question1.Answer1.isSubset;

import static org.junit.Assert.*;
import org.junit.Test;

public class Answer1Test {

	@Test
	public void testIsSubset() {

		boolean isSubset = false;

		isSubset = isSubset(new char[] { 'A', 'B', 'C', 'D', 'E' }, new char[] { 'A', 'E', 'D' });
		assertTrue(isSubset);
		System.out.println(String.format("isSubset([A,B,C,D,E], [A,E,D]) = %s", isSubset));

		isSubset = isSubset(new char[] { 'A', 'B', 'C', 'D', 'E' }, new char[] { 'A', 'D', 'Z' });
		assertFalse(isSubset);
		System.out.println(String.format("isSubset([A,B,C,D,E], [A,D,Z]) = %s", isSubset));

		isSubset = isSubset(new char[] { 'A', 'E', 'D' }, new char[] { 'A', 'A', 'E', 'D' });
		assertTrue(isSubset);
		System.out.println(String.format("isSubset([A,D,E], [A,A,D,E]) = %s", isSubset));
	}

}
