package org.handsoncoder.leetcode.medium;

import java.util.Arrays;

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int num : nums) {
			int bsIndex = Arrays.binarySearch(dp, 0, len, num);
			if (bsIndex < 0) {
				bsIndex = -(bsIndex + 1);
			}
			dp[bsIndex] = num;
			if (bsIndex == len) {
				len++;
			} else {
				len = 0;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
