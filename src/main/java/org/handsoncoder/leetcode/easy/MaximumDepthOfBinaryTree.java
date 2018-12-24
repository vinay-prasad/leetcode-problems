package org.handsoncoder.leetcode.easy;

public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		return (root == null) ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
