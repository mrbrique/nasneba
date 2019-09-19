package com.nasneba.devtest.question4;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Fibonacci {

	private TreeSet<Integer> fibonacci;

	private static final List<Integer> DEFAULT_FIBONACCI_SDEQUENCE = Arrays.asList(1, 2);

	public Fibonacci() {
		fibonacci = new TreeSet<Integer>(DEFAULT_FIBONACCI_SDEQUENCE);
	}

	public int[] nextFibonacci(int[] in) {
		int[] ret = new int[in.length];

		for (int i = 0; i < in.length; i++) {
			int q = in[i];
			Integer higher = fibonacci.higher(q);

			if (higher == null) {
				buildFibonacci(q);
				ret[i] = fibonacci.higher(q);
			} else {
				ret[i] = higher;
			}
		}

		return ret;
	}

	private void buildFibonacci(int target) {
		if (fibonacci.higher(target) == null) {
			int last = fibonacci.last();
			fibonacci.add(last + fibonacci.lower(last));
			buildFibonacci(target);
		}

	}

}
