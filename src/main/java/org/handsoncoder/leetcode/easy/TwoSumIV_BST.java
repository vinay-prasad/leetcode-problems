package org.handsoncoder.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumIV_BST {

	// 1 : HashSet
	public boolean findTarget1(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		return find(root, k, set);
	}

	private boolean find(TreeNode root, int k, HashSet<Integer> set) {
		if (root == null)
			return false;
		if (set.contains(k - root.val))
			return true;
		set.add(root.val);
		return find(root.left, k, set) || find(root.right, k, set);
	}
	
	
	// 2 : BST

	public boolean findTarget(TreeNode root, int k) {

		List<Integer> list = new ArrayList<Integer>();
		inOrder(root, list);

		int l = 0;
		int r = list.size()-1;

		while (l < r) {
			int sum = list.get(l) + list.get(r);
			if (sum == k) {
				return true;
			}

			if (sum < k)
				l++;
			if (sum > k)
				r--;
		}
		return  false;
	}

	private void inOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
