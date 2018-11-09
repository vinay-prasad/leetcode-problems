package org.handsoncoder.leetcode.easy;

/***
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * Input: 121 Output: true Example 2:
 * 
 * Input: -121 Output: false Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * 
 * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore
 * it is not a palindrome. Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 */
public class Palindrome {

	public static boolean isPalindromeV(int x) {
		if (x < 0)
			return false;
		char[] arr = new String("" + x).toCharArray();
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			if (!(arr[i] == arr[length - i - 1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 1 = 0 *10 + 1
	 * 12 = 1*10 + 2
	 * 123 = 12*10 + 3
	 * 1234 = 123 * 10 + 4
	 * */
	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int temp = x;
		int rev = 0;
		while (x != 0) {
			rev = (rev * 10) + x % 10;
			x = x / 10;
		}
		return (temp == rev);

	}

	public static void main(String[] args) {
		System.out.println("1234 - " + Palindrome.isPalindrome(1234));
		System.out.println("121 - " + Palindrome.isPalindrome(121));
		System.out.println("-121 - " + Palindrome.isPalindrome(-121));
		System.out.println("10 - " + Palindrome.isPalindrome(10));
	}
}
