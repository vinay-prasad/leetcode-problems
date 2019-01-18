package org.handsoncoder.leetcode.google.phonescreen;

import java.util.Arrays;

public class Practice {

	public boolean isPalindrome(String s) {
		char[] sArr = s.toCharArray();
		int left = 0, right = sArr.length - 1;

		while (left < right) {
			if (!isCharacter(sArr[left]))
				left++;
			else if (!isCharacter(sArr[right]))
				right--;
			else if (Character.toLowerCase(sArr[left]) != Character.toLowerCase(sArr[right]))
				return false;
			else {
				left++;
				right--;
			}
		}
		return true;
	}

	private boolean isCharacter(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}

	// [0,1,0,3,12]
	public void moveZeroes(int[] nums) {
		int pivot = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[pivot++] = nums[i];
			else
				count++;
		}

		for (int i = nums.length - count; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
	
	// 0,0,1,1,1,2,2,3,3,4
	public int removeDuplicates(int[] nums) {
		
		return 0;

	}

	public static void main(String[] args) {
		Practice testObj = new Practice();
		// System.out.println(testObj.isPalindrome("A man, a plan, a canal: Panama"));
		// System.out.println(testObj.isPalindrome("0P"));
		// int [] nums = new int[] {0,1,0,3,12};
		// testObj.moveZeroes(nums);
		// System.out.println(Arrays.toString(nums));
		// nums = new int[] {0,1};
		// testObj.moveZeroes(nums);
		// System.out.println(Arrays.toString(nums));

	}

}
