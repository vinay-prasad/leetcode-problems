package org.handsoncoder.leetcode.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len) {
				len++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		LongestIncreasingSubsequence testObj = new LongestIncreasingSubsequence();
		int res = testObj.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 });
		System.out.println(res);
	}

}
