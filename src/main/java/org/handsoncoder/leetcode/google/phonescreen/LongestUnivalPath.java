package org.handsoncoder.leetcode.google.phonescreen;

public class LongestUnivalPath {
	int max = Integer.MIN_VALUE;

	public int longestUnivaluePath(TreeNode root) {
		if (root == null)
			return 0;
		postorder(root);
		return max;
	}

	private int postorder(TreeNode node) {
		if (node == null)
			return 0;
		int left = postorder(node.left);
		int right = postorder(node.right);
		if (node.left != null && node.left.val == node.val)
			left++;
		else
			left = 0;

		if (node.right != null && node.right.val == node.val)
			right++;
		else
			right = 0;

		max = Math.max(max, (left + right));
		return Math.max(left, right);
	}
	
	public static void main(String[] args) {
		LongestUnivalPath testObj = new LongestUnivalPath();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		
		int result = testObj.longestUnivaluePath(root );
		System.out.println(result);
		
		
	}
	
}
