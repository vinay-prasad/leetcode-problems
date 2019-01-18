package org.handsoncoder.leetcode.easy;

public class ClosestBinarySearchTreeValue {
	double left = 0, right = 0;

	public int closestValue(TreeNode root, double target) {
		inOrderDfs(root, target);
		if (left == 0 ^ right == 0)
			return (int) left | (int) right;
		if (left == 0 && right == 0)
			return 0;
		return (target - left >  right - target) ? (int) right : (int) left;

	}

	private void inOrderDfs(TreeNode root, double target) {
		if (right != 0 && left != 0)
			return;
		if (root == null)
			return;
		if (root.left != null)
			inOrderDfs(root.left, target);
		System.out.println(root.val);
		if ((double) root.val < target){
			System.out.println("Setting "+root.val + " in left " + (double) root.val + " " +target);
			left = root.val;
		}else {
			System.out.println("Setting "+root.val + " in right" + (double) root.val + " " +target);
			right = root.val;
			return;
		} 

		if (root.right != null)
			inOrderDfs(root.right, target);
	}

	public static void main(String[] args) {
		ClosestBinarySearchTreeValue testObj = new ClosestBinarySearchTreeValue();
		TreeNode root = new TreeNode(1500000000);
		root.left = new TreeNode(1400000000);
		int res = testObj.closestValue(root , -1500000000.0);
		System.out.println(res);
	}

}
