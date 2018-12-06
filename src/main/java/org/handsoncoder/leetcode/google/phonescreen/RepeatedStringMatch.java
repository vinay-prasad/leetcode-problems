package org.handsoncoder.leetcode.google.phonescreen;

/*
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.*/
public class RepeatedStringMatch {

	public int repeatedStringMatch(String A, String B) {

		int counter = 0;
		StringBuffer strBuff = new StringBuffer();

		while (strBuff.toString().length() < B.length()) {
			strBuff.append(A);
			counter++;
		}
		if (strBuff.toString().contains(B))
			return counter;
		if (strBuff.append(A).toString().contains(B))
			return ++counter;
		return -1;
	}

	public static void main(String[] args) {
		String A = "abc";

		String B = "cabcabca";
		RepeatedStringMatch match = new RepeatedStringMatch();
		System.out.println(match.repeatedStringMatch(A, B));
	}

}
