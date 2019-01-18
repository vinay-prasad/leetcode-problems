package org.handsoncoder.leetcode.medium;

import java.util.Stack;

public class DecodeString {

	public String decodeString1(String s) {
		Stack<Integer> count = new Stack<>();
		Stack<String> result = new Stack<>();
		int i = 0;
		result.push("");
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				int start = i;
				while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
					i++;
				count.push(Integer.parseInt(s.substring(start, i + 1)));
			} else if (ch == '[') {
				result.push("");
			} else if (ch == ']') {
				String str = result.pop();
				StringBuilder sb = new StringBuilder();
				int times = count.pop();
				for (int j = 0; j < times; j += 1) {
					sb.append(str);
				}
				result.push(result.pop() + sb.toString());
			} else {
				result.push(result.pop() + ch);
			}
			i += 1;
		}
		return result.pop();
	}

	public String decodeString(String s) {

		// stores the count of sub-string 2[ab]
		Stack<Integer> count = new Stack<>();
		// temporary place to store partial result
		Stack<String> result = new Stack<>();
		result.push("");
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			// if char is integer

			if (Character.isDigit(c)) {
				int j = i + 1;
				while (Character.isDigit(s.charAt(j))) {
					j++;
				}
				count.push(Integer.parseInt(s.substring(i, j)));
				i = (j - 1);
			}
			// if char is '['
			else if (c == '[') {
				result.push("");
			}
			// if char is ']'
			else if (c == ']') {
				StringBuffer strBuff = new StringBuffer();
				String str = result.pop();
				int times = count.pop();
				for (int k = 0; k < times; k++) {
					strBuff.append(str);
				}
				result.push(result.pop() + strBuff.toString());
			}
			// if char is substring between [ab]
			else {
				result.push(result.pop() + c);
			}
			i++;
		}
		return result.pop();
	}

	public static void main(String[] args) {
		String str = "33[a]2[bc]";
		DecodeString testObj = new DecodeString();
		String result = testObj.decodeString(str);
		System.out.println(result);

		str = "3[a2[c]]";
		result = testObj.decodeString(str);
		System.out.println(result);

	}

}
