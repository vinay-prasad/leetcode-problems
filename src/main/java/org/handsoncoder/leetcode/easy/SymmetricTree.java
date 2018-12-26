package org.handsoncoder.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	private boolean isSymmetric(TreeNode root1, TreeNode root2) {
		Queue<TreeNode> q1 = new LinkedList<>();
		q1.add(root1);
		q1.add(root2);
		while (!q1.isEmpty()) {

			TreeNode r1 = q1.poll();
			TreeNode r2 = q1.poll();
			if (r1 == null && r2 == null)
				continue;
			if (r1 == null ^ r2 == null)
				return false;
			if (r1.val != r2.val)
				return false;

			q1.add(r1.left);
			q1.add(r2.right);
			q1.add(r1.right);
			q1.add(r2.left);
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
