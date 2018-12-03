package org.handsoncoder.leetcode.medium;
// revisit
/**
 * 138. Copy List with Random Pointer
Medium
1091
332

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.*/
import java.util.HashMap;

public class CopyListWithRandomPointer {

	 HashMap<RandomListNode, RandomListNode> visitedNodes = new HashMap<RandomListNode, RandomListNode>();

		public RandomListNode copyRandomList(RandomListNode head) {
	        if (head==null) {
	            return null;
	        }
			RandomListNode oldNode = head;
			RandomListNode newNode = new RandomListNode(oldNode.label);
			visitedNodes.put(head, newNode);

			while (oldNode != null) {

				newNode.next = getNodeFromVisitedNodes(oldNode.next);
				newNode.random = getNodeFromVisitedNodes(oldNode.random);
				oldNode = oldNode.next;
				newNode = newNode.next;
			}
			return visitedNodes.get(head);

		}

		private RandomListNode getNodeFromVisitedNodes(RandomListNode node) {
			if (node == null)
				return null;
			if (visitedNodes.get(node) == null) {
				visitedNodes.put(node, new RandomListNode(node.label));
			}
			return visitedNodes.get(node);
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
