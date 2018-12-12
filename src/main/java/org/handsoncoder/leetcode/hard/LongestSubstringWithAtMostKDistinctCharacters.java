package org.handsoncoder.leetcode.hard;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {

		int left = 0, right = 0, maxLength = 0, distinctChars = 0;
		int charMap[] = new int[256];
		while (right < s.length()) {
			char c = s.charAt(right);
			charMap[c]++;
			if (charMap[c] == 1) {
				distinctChars++;
			}
			if (distinctChars <= k) {
				maxLength = Math.max(maxLength, right - left + 1);
			} else {
				while (distinctChars != k) {
					char cL = s.charAt(left);
					charMap[cL]--;
					if (charMap[cL] == 0) {
						distinctChars--;
					}
					left++;
				}
			}
			right++;
		}

		return maxLength;

	}

	public static void main(String[] args) {
		String s = "aabbbcccccddddd";
		int k = 2;
		LongestSubstringWithAtMostKDistinctCharacters testObj = new LongestSubstringWithAtMostKDistinctCharacters();
		System.out.println(testObj.lengthOfLongestSubstringKDistinct(s, k));

	}
}
