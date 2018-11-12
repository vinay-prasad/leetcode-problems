package org.handsoncoder.leetcode.easy;

// #2
/**
 * 206. Reverse Linked List
 * 
 * 
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 *
 */
public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode tempNext = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tempNext;

		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(4);

		ListNode result = ReverseLinkedList.reverseList(head);
		System.out.println(result.val + "" + result.next.val + "" + result.next.next.val);

	}

}
