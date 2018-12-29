package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		return null;

	}

	private void inorder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inorder(node.left, list);
		}
		list.add(node.val);
		if (node.right != null) {
			inorder(node.right, list);
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postorder(root, list);
		return null;

	}

	private void postorder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			postorder(node.left, list);
		}
		if (node.right != null) {
			postorder(node.right, list);
		}
		list.add(node.val);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		preorder(root, list);
		return null;

	}

	private void preorder(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		list.add(node.val);
		if (node.left != null) {
			preorder(node.left, list);
		}
		if (node.right != null) {
			preorder(node.right, list);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
