package org.handsoncoder.leetcode.easy;

public class FirstUniqueCharater {
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0 || s.isEmpty()) {
			return -1;
		}
		int[] charMap = new int[256];
		for (char c : s.toCharArray()) {
			charMap[c]++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (charMap[s.charAt(i)] == 1) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueCharater testObj = new FirstUniqueCharater();
		System.out.println(testObj.firstUniqChar("cc"));
	}

}
