package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		return bfs(root, list);

	}

	class Pair {
		TreeNode node;
		int level;

		public Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}

	}

	private List<List<Integer>> bfs(TreeNode root, List<List<Integer>> list) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			List<Integer> subList;
			Pair p = q.poll();

			if (p == null)
				break;

			if (!(list.size() > p.level)) {
				subList = new ArrayList<>();
				list.add(subList);
			} else {
				subList = list.get(p.level);
			}
			subList.add(p.node.val);
			if (p.node.left != null)
				q.add(new Pair(p.node.left, (p.level + 1)));
			if (p.node.right != null)
				q.add(new Pair(p.node.right, (p.level + 1)));
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
