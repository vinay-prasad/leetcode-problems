package org.handsoncoder.leetcode.medium;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int index = 0;
		while (index < strs[0].length()) {
			char c;
			c = strs[0].charAt(index);
			
			boolean flag = false;
			for (String str : strs) {
				if (!((str.length() > index) &&(str.charAt(index) == c))) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
			index++;
		}
		return strs[0].substring(0, index);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
