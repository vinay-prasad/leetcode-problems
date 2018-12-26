package org.handsoncoder.leetcode.medium;

import java.util.Arrays;

public class ReverseWordsInString {
	public void reverseWords(char[] str) {
		int start = 0;
		int end = str.length - 1;

		reverse(str, start, end);

		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				end = i - 1;
				reverse(str, start, end);
				start = end+2;
			}
		}

		reverse(str, start, str.length - 1);

	}

	private void reverse(char[] str, int start, int end) {
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}		
	}

	public static void main(String[] args) {
		char[] str = { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
		ReverseWordsInString testObj = new ReverseWordsInString();
		testObj.reverseWords(str);
		System.out.println(Arrays.toString(str));
	}
}
