package org.handsoncoder.leetcode.medium;

/**
 * 19. Remove Nth Node From End of List Medium 1359 105 Favorite Share Given a
 * linked list, remove the n-th node from the end of list and return its head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd1(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode dummy = head;
		ListNode fp = dummy;
		ListNode sp = dummy;

		int spCount = 1;
		int fpCount = 1;
		while (sp.next != null) {
			if (spCount > n) {
				sp = sp.next;
				fp = fp.next;
				spCount++;
				fpCount++;
			} else {
				sp = sp.next;
				spCount++;
			}
		}
		if (fpCount == 1 && spCount == 1 || (spCount - fpCount < n)) {
			return dummy.next;
		} else {
			fp.next = fp.next.next;
			return dummy;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode fp = head;
		ListNode sp = head;
		int fpCount = 1, spCount = 1;
		while (sp.next != null) {
			if (spCount - fpCount >= n) {
				sp = sp.next;
				fp = fp.next;
				fpCount++;
				spCount++;
			} else {
				sp = sp.next;
				spCount++;
			}
		}
		if (spCount == n) {
			return head.next;
		} else {
			fp.next = fp.next.next;
			return head;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
