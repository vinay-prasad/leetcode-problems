package org.handsoncoder.leetcode.medium;

import java.util.*;

public class KthSmallestElement {
	int k = 0, count =0, result = 0;

	public int kthSmallest1(TreeNode root, int k) {
		this.k = k;
		List<Integer> list = new ArrayList<>();
		inorder1(root, list);
		return list.get(k - 1);
	}

	private void inorder1(TreeNode node, List<Integer> list) {
		if (node != null) {
			if (list.size() == k)
				return;
			if (node.left != null)
				inorder1(node.left, list);
			list.add(node.val);
			if (node.right != null)
				inorder1(node.right, list);
		}
	}


	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		inorder(root);
		return result;
	}

	private void inorder(TreeNode node) {
		if (node != null) {
			if (node.left != null)
				inorder(node.left);
			if (++count == k){
                result = node.val;
                return;
            }				
			if (node.right != null)
				inorder(node.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
