package org.handsoncoder.leetcode.easy;

/**
 *
 * Microsoft | 6
 * 
 * Apple | 4
 * 
 * eBay | 2
 * 
 * Amazon | 2
 * 
 * Facebook | 2
 * 
 * Adobe | 2
 * 
 * GoDaddy | 2
 * 
 * Bloomberg | 2
 * 
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example 1:
 * 
 * Input: "hello" Output: "olleh" Example 2:
 * 
 * Input: "A man, a plan, a canal: Panama" Output: "amanaP :lanac a ,nalp a ,nam
 * A"
 *
 */
public class ReverseString {

	// Bad
	public static String reverseString2(String s) {
		if (s.isEmpty()) return s; 
		StringBuffer strBuff = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--) {
			strBuff.append(s.charAt(i));
		}
		return strBuff.toString();

	}
	// Best
	public static String reverseString(String s) {
		if (s.isEmpty()) return s;
		char[] sArr = s.toCharArray();

		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			char temp = sArr[i];
			sArr[i] = sArr[j];
			sArr[j] = temp;
		}
		return new String(sArr);
	}

	public static void main(String[] args) {
		System.out.println("Hello - " + reverseString("Hello"));
		System.out.println("Hello - " + reverseString2("Hello"));
	}

}
