package org.handsoncoder.leetcode.hard;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindMissingPositive {
	 public int findKthLargest(int[] nums, int k) {
	        Queue <Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
	            public int compare(Integer o1, Integer o2){
	                return o1.compareTo(o2);
	            }
	        });
	            
	            for (int num : nums) {
	                queue.add(num);
	                if (queue.size() > k) {
	                    queue.poll();
	                }
	            }
	        return queue.poll();
	    }
	public int firstMissingPositive(int[] nums) {
		int min = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (num > 0) {
				set.add(num);
				min = Math.min(min, num);
			}
		}
		if (min > 1)
			return 1;
		for (int i = 1; i <= (nums.length+1); i++) {
			if (!set.contains(i))
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
