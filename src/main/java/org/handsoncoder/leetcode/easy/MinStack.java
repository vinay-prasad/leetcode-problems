package org.handsoncoder.leetcode.easy;

// Pat your back
/**
 * @author 3694805
 *
 */
class MinStack {
	int min = Integer.MAX_VALUE;
	Node head;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			next = null;
			this.data = data;
		}
	}

	public MinStack() {

	}

	public void push(int x) {
		if (x < min) {
			min = x;
		}
		Node node = new Node(min);
		node.next = new Node(x);

		if (this.head == null || head.next == null) {
			head = node;
		} else {
			Node temp = head;
			head = node;
			head.next.next = temp;
		}
	}

	public void pop() {
		if (this.head == null) {
			// Do nothing
		} else {
			Node currHead = head.next;
			if (currHead.next != null) {
				head = currHead.next;
				min = head.data;
			} else {
				head = null;
				this.min = Integer.MAX_VALUE;
			}
		}
	}

	public int top() {
		return head != null ? head.next.data : null;

	}

	public int getMin() {
		return min;

	}

	public static void main(String[] args) {
		/**
		 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
		 * [[],[-2],[0],[-3],[],[],[],[]]
		 */
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
}
