package org.handsoncoder.leetcode.medium;

import java.util.Stack;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		Stack<Integer> stack = new Stack<Integer>();
		return inOrderTraversal(root, stack);

	}

	// 40%
	private boolean inOrderTraversal(TreeNode root, Stack<Integer> stack) {
		if (root == null)
			return true;
		if (!inOrderTraversal(root.left, stack)) {
			return false;
		}
		if (!stack.isEmpty() && stack.peek() >= root.val) {
			return false;
		} else {
			stack.push(root.val);
		}
		return inOrderTraversal(root.right, stack);
	}

	long max = Long.MIN_VALUE;

	// 100%
	public boolean isValidBST2(TreeNode root) {
		return inOrderTraversal(root);
	}

	private boolean inOrderTraversal(TreeNode root) {
		if (root == null)
			return true;
		if (!inOrderTraversal(root.left)) {
			return false;
		}
		if (max >= root.val) {
			return false;
		} else {
			max = root.val;
		}
		return inOrderTraversal(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
