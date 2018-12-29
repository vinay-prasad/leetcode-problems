package org.handsoncoder.leetcode.misc;

public class Recursion {

	static int count = 0;

	public static void rec() {
		count++;
		if (count == 5) {
			count--;
			return;
		}
		System.out.println("starting stack - " + count);
		rec();
		System.out.println("finishing stack - " + count);
		count--;
		return;
	}

	public static void main(String[] args) {
		rec();
	}

}
