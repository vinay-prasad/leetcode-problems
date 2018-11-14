package org.handsoncoder.leetcode.easy;

import java.util.Stack;

// Pat your back
/**
 * @author 3694805
 *
 */
class MinStack2 {
	int min = Integer.MAX_VALUE;
	Stack<Integer> head = new Stack<Integer>();

	public MinStack2() {

	}

	public void push(int x) {
		if (x < min) {
			min = x;
		}
		this.head.push(x);
		this.head.push(min);
	}

	public void pop() {
		if (!this.head.isEmpty()) {
			this.head.pop();
			this.head.pop();
			if (!this.head.isEmpty()) {
				min = this.head.peek();
			} else {
				min = Integer.MAX_VALUE;
			}
		}
	}

	public int top() {
		if (!this.head.isEmpty()) {
			int min = head.pop();
			int data = head.peek();
			head.push(min);
			return data;
		}else {
			return 0;
		}
	}

	public int getMin() {
		return min;

	}

	public static void main(String[] args) {
		/**
		 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
		 * [[],[-2],[0],[-3],[],[],[],[]]
		 */
		MinStack2 obj = new MinStack2();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
}
