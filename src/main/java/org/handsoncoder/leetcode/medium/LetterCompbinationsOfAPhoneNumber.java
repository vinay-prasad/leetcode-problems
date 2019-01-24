package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCompbinationsOfAPhoneNumber {
	String[] chars = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return list;
		}
		backtrack(list, digits, new StringBuffer(), 0);
		return list;
	}

	private void backtrack(List<String> list, String digits, StringBuffer sb, int start) {
		if (sb.length() == digits.length()) {
			list.add(sb.toString());
		} else {
			// Remember to subtract '0'
			String str = chars[digits.charAt(start) - '0'];
			for (char c : str.toCharArray()) {
				sb.append(c);
				// Remember to do start +1 for distinct
				backtrack(list, digits, sb, start + 1);
				// Remember there is not sb.remove(), use setLength()
				sb.setLength(sb.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		LetterCompbinationsOfAPhoneNumber testObj = new LetterCompbinationsOfAPhoneNumber();
		System.out.println(testObj.letterCombinations("23"));

	}

}
