package org.handsoncoder.leetcode.amazon;

import java.util.HashSet;
import java.util.Set;

import org.handsoncoder.leetcode.easy.TreeNode;

public class TwoSumIVInputIsBST {

	Set<Integer> set = new HashSet<>();
	boolean isFound = false;

	public boolean findTarget(TreeNode root, int k) {
		if (root != null) {
			dfs(root, k);
		}
		return isFound;

	}

	private void dfs(TreeNode root, int k) {
		if (root == null)
			return;
		if (root.left != null) {
			dfs(root.left, k);
		}
		System.out.println(root.val);
		if (set.contains(root.val)) {
			isFound = true;
			return;
		}else {
			set.add(k-root.val);
		}
		if (root.right != null) {
			dfs(root.right, k);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
