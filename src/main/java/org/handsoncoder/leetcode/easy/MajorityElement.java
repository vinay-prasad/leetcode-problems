package org.handsoncoder.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

// #3
/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than n/2 times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] Output: 3 Example 2:
 * 
 * Input: [2,2,1,1,1,2,2] Output: 2 *
 */
public class MajorityElement {
	
	// Traditional
	public static int majorityElement1(int[] nums) {
		HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		int majElement = 0;
		int majCount = 0;
		for (int n : nums) {
			if (numsMap.get(n) == null) {
				numsMap.put(n, 1);
				if (majElement == 0) {
					majElement = n;
					majCount = 1;
				}
			} else {
				int count = numsMap.get(n);
				numsMap.put(n, ++count);
				if (count > majCount) {
					majElement = n;
					majCount = count;
				}
			}
		}
		return majElement;
	}
	// Best
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2}));
		System.out.println(majorityElement(new int[] {3,2,3}));
		System.out.println(majorityElement(new int[] {3,3,4}));
		System.out.println(majorityElement1(new int[] {2,2,1,1,1,2,2}));
		System.out.println(majorityElement1(new int[] {3,2,3}));
		System.out.println(majorityElement1(new int[] {3,3,4}));
	}
}
