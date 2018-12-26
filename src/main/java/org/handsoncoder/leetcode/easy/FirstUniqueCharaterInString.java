package org.handsoncoder.leetcode.easy;

public class FirstUniqueCharaterInString {
	class Solution {
		public int firstUniqChar(String s) {
			if (s != null && !s.isEmpty()) {

				char[] arr = s.toCharArray();
				int[] charMap = new int[256];

				for (char c : arr) {
					charMap[c]++;
				}

				for (int index = 0; index < s.length(); index++) {
					if (charMap[s.charAt(index)] == 1) {
						return index;
					}
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
