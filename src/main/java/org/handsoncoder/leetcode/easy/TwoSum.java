package org.handsoncoder.leetcode.easy;

import java.util.Arrays;

/**
 * @author vinay
 * 
 *         Given nums = [2, 7, 11, 15], target = 9,
 * 
 *         Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
			for (int i = 0; i < nums.length; i++) {
				for (int ii = 0; ii < nums.length; ii++) {
					if (i != ii && (nums[i] + nums[ii] == target)) {
						return new int[] { i, ii };
					}
				}
			}
			return nums;

	}

	public static void main(String[] args) {
		int[] result = new TwoSum().twoSum(new int[] { 2, 7, 11, 15, 19 }, 21);

		System.out.println(Arrays.toString(result));

	}

}
