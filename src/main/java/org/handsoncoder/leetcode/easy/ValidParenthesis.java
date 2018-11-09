package org.handsoncoder.leetcode.easy;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true*/
public class ValidParenthesis {
	public static boolean isValidV(String s) {
		if (s == null || s.isEmpty())
			return true;
		Stack<Character> pStack = new Stack<Character>();
		Map<Character, Character> pMap = new HashMap<Character, Character>();
		pMap.put('}', '{');
		pMap.put(']', '[');
		pMap.put(')', '(');

		for (char c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(') {
				pStack.push(c);
			} else {
				try {
					char sc = pStack.pop();
					if (sc != pMap.get(c)) {
						return false;
					}
				} catch (EmptyStackException e) {
					return false;
				}
			}
		}
		return pStack.isEmpty();
	}

	public static boolean isValid(String s) {
		if (s == null || s.isEmpty())
			return true;
		Stack<Character> pStack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '{') {
				pStack.push('}');
			} else if (c == '[') {
				pStack.push(']');
			} else if (c == '(') {
				pStack.push(')');
			} else if (pStack.isEmpty() || pStack.pop() != c) {
				return false;
			}
		}
		return pStack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("()[]{}" + ValidParenthesis.isValid("()[]{}{}{"));
		System.out.println("()[]{}" + ValidParenthesis.isValid("()"));
		System.out.println("()[]{}" + ValidParenthesis.isValid("()[]{}"));
		System.out.println("()[]{}" + ValidParenthesis.isValid("([)]"));
		System.out.println("()[]{}" + ValidParenthesis.isValid("{[]}"));
		System.out.println("()[]{}" + ValidParenthesis.isValid(""));
		System.out.println("()[]{}" + ValidParenthesis.isValid(null));
	}
}
