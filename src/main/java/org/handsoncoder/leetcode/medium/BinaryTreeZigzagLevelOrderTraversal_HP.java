package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_HP {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		int level = 0;
		travel(root, level, result);
		return result;
	}

	private void travel(TreeNode node, int level, List<List<Integer>> result) {
		if (node == null)
			return;
		if (result.size() <= level) {
			result.add(new ArrayList<Integer>());
		}
		if (level % 2 == 0) {
			result.get(level).add(node.val);
		} else {
			result.get(level).add(0, node.val);
		}
		if (node.left != null)
			travel(node.left, level + 1, result);
		if (node.right != null)
			travel(node.right, level + 1, result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
