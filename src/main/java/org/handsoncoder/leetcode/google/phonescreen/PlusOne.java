package org.handsoncoder.leetcode.google.phonescreen;

import java.util.Arrays;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int plusOne[] = new int[digits.length + 1];
		int carry = 1;
		for (int i = (digits.length - 1); i >= 0; i--) {
			int temp = (digits[i] + carry);
			carry = temp / 10;
			plusOne[i + 1] = temp % 10;
		}
		plusOne[0] = carry;
		return (carry == 0) ? Arrays.copyOfRange(plusOne, 1, plusOne.length) : plusOne;
	}

	public static void main(String[] args) {
		PlusOne testObj = new PlusOne();
		int[] result = testObj.plusOne(new int[] {1,2,3});
		System.out.println(Arrays.toString(result));
		
		result = testObj.plusOne(new int[] {9,1,9});
		System.out.println(Arrays.toString(result));
				

	}

}
