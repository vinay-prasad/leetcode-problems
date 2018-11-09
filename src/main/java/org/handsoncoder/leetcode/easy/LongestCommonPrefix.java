package org.handsoncoder.leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
 * prefix among the input strings. Note:
 * 
 * All given inputs are in lowercase letters a-z.
 **/
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		String commonStr = "";
		if (strs == null || strs.length == 0) {
			return commonStr;
		}
		String firstStr = strs[0];
		String key = "";
		for (int i = 0; i < firstStr.length(); i++) {
			key = key + firstStr.charAt(i);
			for (String str : strs) {
				if (str.length() < key.length() || !(str.substring(0, i + 1).equals(key))) {
					return commonStr;
				}
			}
			commonStr = key;
		}
		return commonStr;
	}

	public static void main(String[] args) {
		System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
		System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[] { "Vinay", "Vijay", "Vinit" }));
		System.out.println(
				LongestCommonPrefix.longestCommonPrefix(new String[] { "Vinay", "Vinayak", "Vinit", "Vivek" }));
		System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[] { "Vinay", "Vinayak", "Vinit" }));

	}

}
