package org.handsoncoder.leetcode.misc;

import java.util.Arrays;

public class LIS {
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
		LIS testObj = new LIS();
		int result = testObj.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 });
		System.out.println(result);
		
		System.out.println("80 should be put at location " + Arrays.binarySearch(new int[] {3,4,5,7,9}, 0, 5, 80));
		System.out.println("1 should be put at location " + Arrays.binarySearch(new int[] {3,4,5,7,9}, 0, 5, 1));
		System.out.println("2 should be put at location " + Arrays.binarySearch(new int[] {3,4,5,7,9}, 0, 5, 2));
		System.out.println("6 should be put at location " + Arrays.binarySearch(new int[] {3,4,5,7,9}, 0, 5, 6));
		System.out.println("8 should be put at location " + Arrays.binarySearch(new int[] {3,4,5,7,9}, 0, 5, 8));
		System.out.println("3 is found at index " + Arrays.binarySearch(new int[] {3,4,5,7,9}, 0, 5, 3));
		
	}
}
