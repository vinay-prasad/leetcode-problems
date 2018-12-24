package org.handsoncoder.leetcode.easy;

import java.util.Arrays;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		k%=nums.length;
		reverse(nums, 0, (nums.length -1));
		reverse(nums, 0, (k-1));
		reverse(nums, k, (nums.length -1));
    }
	
	public void reverse (int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right --;
		}
	}

	public static void main(String[] args) {
		RotateArray testObj = new RotateArray();
		int[] nums = new int[] {1,2,3,4,5,6,7};
		testObj.rotate(nums , 3);
		System.out.println(Arrays.toString(nums));
		
		nums = new int[] {1,2,3,4,5,6,7};
		testObj.rotate(nums , 7);
		System.out.println(Arrays.toString(nums));
	}

}
