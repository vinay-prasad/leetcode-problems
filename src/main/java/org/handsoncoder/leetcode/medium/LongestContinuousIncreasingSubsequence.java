package org.handsoncoder.leetcode.medium;

public class LongestContinuousIncreasingSubsequence {

	public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		int left = 0, right = 0, max = 0;
		while (right < nums.length - 1) {
			right++;
			if (!(nums[right - 1] < nums[right])) {
				while (left != right) {
					left++;
				}
			}
			max = Math.max(max, 1 + right - left);
		}
		return max;
	}

	public static void main(String[] args) {
		LongestContinuousIncreasingSubsequence testObj = new LongestContinuousIncreasingSubsequence();
		int result = testObj.findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 });
		System.out.println(result);

		result = testObj.findLengthOfLCIS(new int[] { 1, 1, 1, 1 });
		System.out.println(result);

	}

}
