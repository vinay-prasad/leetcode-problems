package org.handsoncoder.leetcode.easy;

public class ReverseInteger {

	/*
	 * Example 1: Input: 123 Output: 321 Example 2:
	 * 
	 * Input: -123 Output: -321 Example 3:
	 * 
	 * Input: 120 Output: 21
	 */
	public static int reverse(int x) {
		int sign = 1;
		if (x < 0) {
			sign = -1;
			x = x * (sign);
		}
		if (x > Integer.MAX_VALUE) {
			return 0;
		}
		char[] charArr = (x + "").toCharArray();
		StringBuffer revStringBuff = new StringBuffer();
		for (int i = (charArr.length - 1); i >= 0; i--) {
			revStringBuff.append(charArr[i]);
		}
		return (sign) * Integer.parseInt(revStringBuff.toString());
	}

	public static void main(String[] args) {
		System.out.println(reverse(-1234));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(reverse(Integer.parseInt("9646324351")));
	}
}
