package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarrTreeZigzagLevelOrderTraversal {
	class MyTreeNode {

		TreeNode node;
		int level;

		public MyTreeNode(TreeNode node, int level) {
			super();
			this.node = node;
			this.level = level;
		}

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<MyTreeNode> stack = new Stack<>();
		Queue<MyTreeNode> queue = new LinkedList<>();
		queue.add(new MyTreeNode(root, 0));

		while (!queue.isEmpty()) {
			MyTreeNode node = queue.poll();
			if (node != null) {
				if (node.level % 2 == 0) {
					while (!stack.isEmpty()) {
						MyTreeNode temp = stack.pop();
						if (result.size() <= temp.level) {
							result.add(new ArrayList<Integer>());
						}
						result.get(temp.level).add(temp.node.val);
					}
					if (result.size() <= node.level) {
						result.add(new ArrayList<Integer>());
					}
					result.get(node.level).add(node.node.val);
				} else {
					stack.add(node);
					if (queue.isEmpty() && !stack.isEmpty()) {
						while (!stack.isEmpty()) {
							MyTreeNode temp = stack.pop();
							if (result.size() <= temp.level) {
								result.add(new ArrayList<Integer>());
							}
							result.get(temp.level).add(temp.node.val);
						}
					}
				}

				if (node.node.left != null) {
					queue.add(new MyTreeNode(node.node.left, (node.level + 1)));
				}
				if (node.node.right != null) {
					queue.add(new MyTreeNode(node.node.right, (node.level + 1)));
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		BinarrTreeZigzagLevelOrderTraversal testObj = new BinarrTreeZigzagLevelOrderTraversal();
		List<List<Integer>> result = testObj.zigzagLevelOrder(root);
		System.out.println(result);

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		result = testObj.zigzagLevelOrder(root);
		System.out.println(result);
	}

}
