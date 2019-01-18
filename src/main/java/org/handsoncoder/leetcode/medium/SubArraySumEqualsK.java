package org.handsoncoder.leetcode.medium;

/*
 * 560. Subarray Sum Equals K
Medium

1451

35

Favorite

Share
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].*/
import java.util.*;

public class SubArraySumEqualsK {

	 // 62 / 80 test cases passed.
	public int subarraySum(int[] nums, int k) {
		int sum = 0, count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			sum += num;
			if (sum == k) {
				count++;
			} else if (map.containsKey(sum - k)) {
				count++;
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}

		return count;
	}

	public static void main(String[] args) {
		SubArraySumEqualsK testObj = new SubArraySumEqualsK();
		System.out.println(testObj.subarraySum(new int[] { 1, 1, 1 }, 2));

	}

}
