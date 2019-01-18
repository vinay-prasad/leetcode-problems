package org.handsoncoder.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {
	 public boolean isSubtree(TreeNode s, TreeNode t) {
			List<Integer> sList = new ArrayList<>();
			List<Integer> tList = new ArrayList<>();
			dfs(s, sList);
			dfs(t, tList);
			int sPtr = 0;
			int tPtr = 0;

			while (sPtr < sList.size() && tPtr < tList.size()) {
				if (sList.get(sPtr) != tList.get(tPtr)) {
					if (tPtr != 0) {
						tPtr = 0;
					} else {
						sPtr++;
					}
				} else if (sList.get(sPtr) == tList.get(tPtr)) {
					sPtr++;
					tPtr++;
				}
			}
			return (tPtr == tList.size());
		}

		private void dfs(TreeNode root, List<Integer> list) {
			if (root != null) {
				if (root.left != null) {
					dfs(root.left, list);
				}
				list.add(root.val);

				if (root.right != null) {
					dfs(root.right, list);
				}
			}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
