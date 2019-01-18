package org.handsoncoder.leetcode.medium;

import java.util.*;

public class ContinuousSubarraySum {

	// 41 / 75 test cases passed.
	public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			sum += num;
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (sum == k && i > 0) {
				return true;
			} else if (map.containsKey(sum - k) && (i - map.get(sum - k)) > 1) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		ContinuousSubarraySum testObj = new ContinuousSubarraySum();
		System.out.println(testObj.checkSubarraySum(new int[] { 23, 2, 3, 6, 7 }, 6));

	}

}
