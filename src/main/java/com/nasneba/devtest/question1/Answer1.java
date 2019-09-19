package com.nasneba.devtest.question1;

public class Answer1 {

	private static final char UPPERCASE_A = 'A';

	public static boolean isSubset(char[] original, char[] subset) {
		boolean[] bucket = new boolean[26];

		for (char c : original) {
			bucket[Character.toUpperCase(c) - UPPERCASE_A] = true;
		}

		for (char c : subset) {
			if (!bucket[Character.toUpperCase(c) - UPPERCASE_A]) {
				return false;
			}
		}

		return true;

	}

}
