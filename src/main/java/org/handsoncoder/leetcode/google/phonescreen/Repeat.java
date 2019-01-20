package org.handsoncoder.leetcode.google.phonescreen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Repeat {

	/*
	 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
	 * largest sum = 6.
	 */
	public int maxSubArray(int[] nums) {
		// remember to set leh and lsf to nums[0]
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int leh = nums[0], lsf = nums[0];
		for (int i = 1; i < nums.length; i++) {
			leh = Math.max(leh + nums[i], nums[i]);
			lsf = Math.max(lsf, leh);
		}
		return lsf;
	}

	/*
	 * Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest increasing
	 * subsequence is [2,3,7,101], therefore the length is 4.
	 */
	public static int lengthOfLIS(int[] nums) {
		// Remember the signature of Arrays.binarySearch() method
		// make bsIndex positive only when it is negative
		int[] arr = new int[nums.length];
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			int bsIndex = Arrays.binarySearch(arr, 0, len, nums[i]);
			if (bsIndex < 0) {
				bsIndex = -(bsIndex + 1);
			}
			arr[bsIndex] = nums[i];
			if (len == bsIndex) {
				len++;
			}
		}
		return len;
	}

	/*
	 * Input: nums = [1, -1, 5, -2, 3], k = 3 Output: 4 Explanation: The subarray
	 * [1, -1, 5, -2] sums to 3 and is the longest.
	 */
	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				max = Math.max(max, (i + 1));
			} else if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}
		}
		return k;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLIS(new int[] { 2, 2 }));

	}

}
