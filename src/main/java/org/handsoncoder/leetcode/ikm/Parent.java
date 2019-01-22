package org.handsoncoder.leetcode.ikm;

public class Parent {
	protected static int count = 0;

	public Parent() {
		count++;
	}

	static int getCount() {
		return count;
	}
}

