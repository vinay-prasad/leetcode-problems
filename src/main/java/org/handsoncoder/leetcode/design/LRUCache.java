package org.handsoncoder.leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class LRUCache {

	HashMap<Integer, Integer> cache;
	Queue<Integer> queue;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>(capacity);
		this.queue = new PriorityQueue<Integer>();
	}

	public int get(int key) {
		if (this.cache.get(key)!=null) {
			
		}
		return this.cache.get(key);
	}

	public void put(int key, int value) {
		
		if (this.cache.size() == this.capacity) {
			this.cache.remove(queue.remove());
		}
		this.cache.put(key, value);
		this.queue.add(key);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
