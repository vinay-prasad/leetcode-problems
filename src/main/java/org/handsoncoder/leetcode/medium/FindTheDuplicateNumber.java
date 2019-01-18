package org.handsoncoder.leetcode.medium;

public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int[] numMap = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (++numMap[nums[i]] > 1) {
				return nums[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindTheDuplicateNumber testObj = new FindTheDuplicateNumber();
		int result = testObj.findDuplicate(new int[] { 1, 1 });
		System.out.println(result);
	}

}
