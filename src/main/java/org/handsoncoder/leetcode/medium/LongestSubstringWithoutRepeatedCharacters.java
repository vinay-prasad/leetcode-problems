package org.handsoncoder.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters {

	/*
	 * Example 1:
	 * 
	 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
	 * of 3. Example 2:
	 * 
	 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
	 * 1. Example 3:
	 * 
	 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
	 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
	 * not a substring.
	 */

	public static int lengthOfLongestSubstring(String s) {

		char[] sArr = s.toCharArray();
		int lastKnownLongest = 0;
		int currentLongest = 0;
		Set<Character> hashSet = new HashSet<Character>();
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < sArr.length; i++) {
			if (hashSet.add(sArr[i])) {
				currentLongest++;
				hashMap.put(sArr[i], i);
			} else {
				if (currentLongest > lastKnownLongest) {
					lastKnownLongest = currentLongest;
				}
				i = hashMap.get(sArr[i]);
				hashSet.clear();
				currentLongest = 0;
			}
		}
		if (currentLongest > lastKnownLongest) {
			lastKnownLongest = currentLongest;
		}
		return lastKnownLongest;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("dvdf"));

	}

}
