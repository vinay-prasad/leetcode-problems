package org.handsoncoder.leetcode.medium;

public class InOrderSuccessorInBST {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		return inOrderTraversal(root, p.val, true);
	}

	private TreeNode inOrderTraversal(TreeNode root, int val, boolean repeat) {
		if (root == null || !repeat)
			return root;

		if (root.left != null)
			inOrderTraversal(root.left, val, repeat);

		if (root.val == val) {
			repeat = false;
		}

		if (root.right != null)
			inOrderTraversal(root.right, val, repeat);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
