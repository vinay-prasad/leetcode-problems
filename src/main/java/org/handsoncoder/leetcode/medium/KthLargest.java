package org.handsoncoder.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
	Queue <Integer> q;
	int capacity;
	
	public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>();
        this.capacity = k;
    }

	public int add(int val) {
		return val;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
