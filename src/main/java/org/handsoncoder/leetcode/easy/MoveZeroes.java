package org.handsoncoder.leetcode.easy;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int pivot = 0;
		int �ount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[pivot] = nums[i];
				pivot++;
			} else {
				�ount++;
			}
		}

		for (int i = 1, j = (nums.length - 1); i >= �ount; i++, j--) {
			nums[j] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
