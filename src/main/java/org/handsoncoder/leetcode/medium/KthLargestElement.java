package org.handsoncoder.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		KthLargestElement testObj = new KthLargestElement();
		int result = testObj.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
		System.out.println(result);

		result = testObj.findKthSmallest(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
		System.out.println(result);

	}

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> largeK = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});

		for (int el : nums) {
			largeK.add(el);
			if (largeK.size() > k) {
				largeK.poll();
			}
		}

		return largeK.poll();
	}

	public int findKthSmallest(int[] nums, int k) {
		PriorityQueue<Integer> largeK = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for (int el : nums) {
			largeK.add(el);
			if (largeK.size() > k) {
				largeK.poll();
			}
		}

		return largeK.poll();
	}
}
