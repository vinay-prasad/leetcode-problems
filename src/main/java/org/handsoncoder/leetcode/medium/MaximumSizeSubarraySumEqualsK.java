package org.handsoncoder.leetcode.medium;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			// get the current sum including num[i]
			sum = sum + nums[i];

			// found the desired sum
			if (sum == k)
				max = i + 1;
			// already a sum exists in map
			else if (map.containsKey(sum - k))
				max = Math.max(max, i - map.get(sum - k));

			// this is an independent if block and need to run if the sum is not in the map
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumSizeSubarraySumEqualsK testObj = new MaximumSizeSubarraySumEqualsK();
		int result = testObj.maxSubArrayLen(new int[] { 1, -1, 5, -2, 3, -3 }, 3);
		System.out.println(result);

		result = testObj.maxSubArrayLen(new int[] { 1, 0, -1 }, 1);
		System.out.println(result);
		result = testObj.maxSubArrayLen(new int[] { 1, 1, 0 }, 1);
		System.out.println(result);
	}

}
