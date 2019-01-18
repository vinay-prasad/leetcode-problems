package org.handsoncoder.leetcode.hard;

import java.util.*;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length < k) {
			return null;
		}
		int result[] = new int[nums.length - k + 1];
		int ptr = 0;
		Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for (int i = 0; i < k; i++) {
			q.add(nums[i]);
		}
		result[ptr++] = q.poll();
		for (int i = k; i < nums.length; i++) {
			q.add(nums[i]);
			result[ptr++] = q.poll();
		}
		return result;

	}

	public static void main(String[] args) {
		SlidingWindowMaximum testObj = new SlidingWindowMaximum();
		int[] res = testObj.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
		System.out.println(Arrays.toString(res));

	}

}
