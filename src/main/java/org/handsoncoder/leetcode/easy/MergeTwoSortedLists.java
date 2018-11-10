package org.handsoncoder.leetcode.easy;

import org.handsoncoder.leetcode.easy.ListNode;

public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {                        
		if (l1 == null && l2 != null)
			return l2;
		if (l2 == null && l1 != null)
			return l1;
		if (l1 == null && l2 == null)
			return null;
		ListNode temp = new ListNode(-1);
		ListNode mL = temp;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				mL.next = new ListNode(l1.val);
				mL =mL.next;
				l1 = l1.next;
			} else {
				mL.next = new ListNode(l2.val);
				mL =mL.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {

			mL.next = new ListNode(l1.val);
			mL =mL.next;
			l1 = l1.next;

		}
		while (l2 != null) {

			mL.next = new ListNode(l2.val);
			mL =mL.next;
			l2 = l2.next;
		}
		return temp.next;

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);

		System.out.println(mergeTwoLists(l1, l2));
	}

}
