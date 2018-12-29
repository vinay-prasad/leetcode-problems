package org.handsoncoder.leetcode.medium;

import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		KthLargestElement testObj = new KthLargestElement();
		int result = testObj.findKthLargest(new int[] {3,2,1,5,6,4}, 4);
		System.out.println(result);

		
		 PriorityQueue<Integer> numbers = new PriorityQueue<>();

	        // Add items to a Priority Queue (ENQUEUE)
	        numbers.add(750);
	        numbers.add(500);
	        numbers.add(900);
	        numbers.add(100);

	        // Remove items from the Priority Queue (DEQUEUE)
	        while (!numbers.isEmpty()) {
	            System.out.println(numbers.remove());
	        }
	}

	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);

        for(int el : nums) {
            largeK.add(el);
            if (largeK.size() > k) {
                largeK.poll();
            }
        }

        return largeK.poll();
    }
}
