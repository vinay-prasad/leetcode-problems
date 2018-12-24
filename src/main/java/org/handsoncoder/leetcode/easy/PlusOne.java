package org.handsoncoder.leetcode.easy;

import java.util.Arrays;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int newDigits[] = new int[digits.length + 1];
		int carry = 1;
		for (int i = (digits.length - 1); i >= 0; i--) {
			int temp = digits[i] + carry;
			carry = temp / 10;
			if (temp >= 10) {
				temp = temp % 10;
			}
			newDigits[i + 1] = temp;
		}

		if (carry == 1) {
			newDigits[0] = carry;
			return newDigits;
		} else {
			return Arrays.copyOfRange(newDigits, 1, newDigits.length);
		}
	}

	public static void main(String[] args) {
		PlusOne testObj = new PlusOne();
		int [] results = testObj.plusOne(new int[] {9,0,9});
		System.out.println(Arrays.toString(results));

	}

}
