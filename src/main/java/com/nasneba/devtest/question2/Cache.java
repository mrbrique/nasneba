package com.nasneba.devtest.question2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class Cache {

	private int capacity;

	private HashMap<Object, CacheEntry> cacheMap;

	public Cache(int cap) {
		this.capacity = cap;
		cacheMap = new HashMap<Object, CacheEntry>();
	}

	public void put(Object k, Object v, int weight) {
		// if the cache if full
		if (cacheMap.size() >= capacity) {
			// find least score key
			Object leastKey = cacheMap.entrySet().stream().min((o1, o2) -> {
				double diff = o1.getValue().score() - o2.getValue().score();
				if (diff == 0)
					return 0;
				else {
					return (diff <= 0) ? -1 : 1;
				}
			}).get().getKey();
			// remove the entry
			cacheMap.remove(leastKey);
		}

		// insert new entry
		cacheMap.put(k, new CacheEntry(v, weight));
	}

	public Object get(Object k) {
		CacheEntry c = cacheMap.get(k);

		if (c != null) {
			// update last access
			c.refresh();
			return c.getValue();
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		this.cacheMap.forEach((k, v) -> {
			buff.append(String.format("[ %s => %s(%s) ],\n", k, v.getValue(), v.score()));
		});

		buff.deleteCharAt(buff.length() - 2);

		return buff.toString();
	}

	class CacheEntry {

		private int weight;

		// data to be hold
		private Object value;

		private LocalDateTime lastAccess;

		public CacheEntry(Object o, int weight) {
			this.weight = weight;
			this.value = o;
			refresh();
		}

		public void refresh() {
			this.lastAccess = LocalDateTime.now();
		}

		public Object getValue() {
			return value;
		}

		public double score() {
			long ms = ChronoUnit.MICROS.between(lastAccess, LocalDateTime.now());
			ms = Math.max(ms, 2);
			return weight / Math.log(ms);
		}

	}

}
