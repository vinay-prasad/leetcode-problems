package org.handsoncoder.leetcode.easy;

// Pat your back
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
		long rev = 0;
		long num = x;
		if (num < 0) {
			sign = -1;
			num = num * (sign);
		}

		while (num != 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}

		if (rev > Integer.MAX_VALUE)
			return 0;
		return (sign) * new Long(rev).intValue();
	}

	public static void main(String[] args) {
		System.out.println(reverse(-1234));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(reverse(2147483647));
		System.out.println(reverse(-2147483648));
		// System.out.println(reverse(Integer.parseInt("9646324351")));
	}
}
