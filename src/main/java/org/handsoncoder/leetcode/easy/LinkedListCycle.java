package org.handsoncoder.leetcode.easy;

import java.util.HashSet;

public class LinkedListCycle {

	public boolean hasCycleV(ListNode head) {
		if (head == null)
			return false;
		ListNode temp = head;
		HashSet<ListNode> set = new HashSet<ListNode>();
		while (temp != null) {
			if (set.contains(temp)) {
				return true;
			}
			set.add(temp);
			temp = temp.next;
		}
		return false;
	}

	// Two pointers
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedListCycle testObj = new LinkedListCycle();
		ListNode head = new ListNode(1);
		head.next = head;
		System.out.println(testObj.hasCycle(head));

	}

}
