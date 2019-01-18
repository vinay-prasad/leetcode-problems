package org.handsoncoder.leetcode.medium;

import java.util.*;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---*/

public class BinaryTreeRightSideView {
	List<Integer> res = new ArrayList<>();

	public List<Integer> rightSideView(TreeNode root) {
		if (root != null)
			res.add(root.val);
		bfs(root, 0);
		return res;

	}

	private void bfs(TreeNode root, int i) {
		if (root != null) {
			if (res.size() - 1 < i) {
				res.add(root.val);
			}
			bfs(root.right, i + 1);
			bfs(root.left, i + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
