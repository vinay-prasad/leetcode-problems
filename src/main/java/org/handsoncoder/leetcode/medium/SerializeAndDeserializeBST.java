package org.handsoncoder.leetcode.medium;

public class SerializeAndDeserializeBST {
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		preorder(root, sb);
		return sb.toString();
	}

	private void preorder(TreeNode root, StringBuffer sb) {
		if (root != null) {
			sb.append(root.val + " ");
			preorder(root.left, sb);
			preorder(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data ==null || data.length() ==0) {
			return null;
		}
		String[] sArr = data.split(" ");
		int[] arr = new int[sArr.length];
		for (int i = 0; i < sArr.length; i++) {
			arr[i] = Integer.parseInt(sArr[i]);
		}

		return helper(arr, 0, arr.length - 1);

	}

	public TreeNode helper(int[] arr, int low, int high) {
		if (low >= 0 && low <= high) {
			TreeNode node = new TreeNode(arr[low]);
			int div = getDiv(arr, node.val, low + 1, high);
			node.left = helper(arr, low + 1, div - 1);
			node.right = helper(arr, div, high);
			return node;
		} else {
			return null;
		}

	}

	private int getDiv(int[] arr, int val, int low, int high) {
		int i;
		for (i = low; i <= high; i++) {
			if (val < arr[i]) {
				break;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBST testObj = new SerializeAndDeserializeBST();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		//root.right = new TreeNode(3);
		String ser = testObj.serialize(root);
		System.out.println(ser);
		TreeNode res = testObj.deserialize(ser);
		ser = testObj.serialize(res);
		System.out.println(ser);
		
	}

}
