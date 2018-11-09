package org.handsoncoder.leetcode.easy;

import java.util.Stack;

public class RemoveElement {

	public int removeDuplicates(int[] nums) {
		Stack<Integer> numStack = new Stack<Integer>();
		int pointer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (numStack.isEmpty() || (!numStack.isEmpty() && numStack.peek() != nums[i])) {
				numStack.push(nums[i]);
				nums[pointer] = nums[i];
				pointer++;
			} else {
				// do nothing
			}
		}
		return (numStack.size());
	}

	public static void main(String[] args) {
		System.out.println(
				new RemoveElement().removeDuplicates((new int[] { 1,2 })));
		System.out.println(
				new RemoveElement().removeDuplicates((new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 })));

	}

}
