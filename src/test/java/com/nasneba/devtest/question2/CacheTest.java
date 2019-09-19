package com.nasneba.devtest.question2;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class CacheTest {

	@Test
	public void testCacheWeight() {
		System.out.println("Testing Cache of cap 3 with different weight");
		Cache c = new Cache(3);
		c.put(1, "first", 10000);
		c.put(2, "second", 1000);
		c.put(3, "third", 10);

		System.out.println("Initial setup");
		System.out.println(c);

		System.out.println("Insert 4, expect 3 will be replaced by 4");
		c.put(4, "fourth", 1);
		assertEquals(c.get("3"), -1);
		assertEquals(c.get(4), "fourth");
		System.out.println(c);

	}

	@Test
	public void testCacheScore() {
		System.out.println("Testing Cache of cap 3 with same weight, different access time");
		// initial setup
		Cache c = new Cache(3);
		c.put(1, "first", 10);
		c.put(2, "second", 10);
		c.put(3, "third", 10);
		System.out.println("Initial setup");
		System.out.println(c);

		// wait 2sec and access 1, 3 to update their score
		int sleepTime = 2000;
		System.out.println(String.format("Wait for %ss... and access 1, 3 to update their score", sleepTime / 1000));
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.get(1);
		c.get(3);
		System.out.println(c);

		// insert 4
		System.out.println("Insert 4, expect 2 will be replaced by 4");
		c.put(4, "fourth", 1);
		assertEquals(c.get(4), "fourth");
		assertEquals(c.get(2), -1);

		System.out.println(c);

	}

	@After
	public void afterTest() {
		System.out.println("=== End of test case ");
	}

	@Before
	public void beforeTest() {
		System.out.print("=== ");
	}

}
