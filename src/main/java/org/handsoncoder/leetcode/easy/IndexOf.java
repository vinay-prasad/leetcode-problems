package org.handsoncoder.leetcode.easy;

public class IndexOf {

	public int strStr(String haystack, String needle) {
		if (needle.isEmpty() || needle.equals(haystack)) return 0;
		for (int i=0; i < haystack.length()-needle.length()+1;i++) {
			if (haystack.substring(i, i+needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		System.out.println(new IndexOf().strStr("mississippi", "pi"));
		System.out.println(new IndexOf().strStr("needles", "needle"));
		System.out.println(new IndexOf().strStr("haystack", "needle"));
		System.out.println(new IndexOf().strStr("haystack", "hay"));
		System.out.println(new IndexOf().strStr("haystack", "sta"));
		System.out.println(new IndexOf().strStr("haystack", ""));
	}

}
