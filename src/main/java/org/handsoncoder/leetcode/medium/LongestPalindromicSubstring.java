package org.handsoncoder.leetcode.medium;

import java.util.Stack;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		Stack <Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
			}else {
				if (stack.peek()!=c) {
					char c1 = stack.pop();
					char c2 = stack.pop();
					if (c2 ==c) {
						
					}
				} else if (stack.peek()==c) {
					
				} else {
					
				}
			}
		}
		return s;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
