package org.handsoncoder.leetcode.medium;

public class LongestParenthesisSubstring {
	public int longestValidParentheses(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int left, right, max;
		left = right = max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				max = Math.max(max, left * 2);
			} else if (right > left) {
				left = right = 0;
			}
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				max = Math.max(max, left * 2);
			} else if (left > right) {
				left = right = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
