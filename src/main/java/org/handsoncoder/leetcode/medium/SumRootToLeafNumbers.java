package org.handsoncoder.leetcode.medium;

/*
 * 
 * 129. Sum Root to Leaf Numbers
Medium

507

23

Favorite

Share
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.*/

public class SumRootToLeafNumbers {

	int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root != null) {
			dfs(root);
		}
		return sum;

	}

	private void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		// if there is a left child. update the left child's value with sum of (10 *
		// root)
		// + left child val
		// and continue dfs to next right child
		if (root.left != null) {
			root.left.val = root.val * 10 + root.left.val;
			dfs(root.left);
		}

		// if there is a right child. update the right child's value with sum of (10 *
		// root) + right child val
		// and continue dfs to next right child
		if (root.right != null) {
			root.right.val = root.val * 10 + root.right.val;
			dfs(root.right);
		}

		// if there are no left and right child then it means its a leaf node
		// leaf node is already populated with its sum so add it to existing sum
		if (root.left == null && root.right == null) {
			sum = sum + root.val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
