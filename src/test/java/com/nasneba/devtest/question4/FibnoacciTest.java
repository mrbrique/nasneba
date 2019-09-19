package com.nasneba.devtest.question4;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

public class FibnoacciTest {

	@Test
	public void testFibnoacci() {
		Fibonacci f = new Fibonacci();
		int[] nextFib = f.nextFibonacci(new int[] { 1, 22, 9 });

		assertArrayEquals(new int[] { 2, 34, 13 }, nextFib);
		System.out.println(String.format("nextFibonacci([1,22,9]) = %s", Arrays.toString(nextFib)));
	}

}
