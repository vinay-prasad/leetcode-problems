package org.handsoncoder.leetcode.medium;

/*
 * 	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
 * */
public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, currNode = dummyHead;
		int carry = 0;
		while (p != null || q != null) {

			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = x + y + carry;
			currNode.next = new ListNode(sum % 10);
			carry = sum / 10;
			currNode = currNode.next;

			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}

		}

		if (carry > 0) {
			currNode.next = new ListNode(carry);
		}

		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1, l2);
		System.out.println(result.val + "" + result.next.val + "" + result.next.next.val);

	}

}
