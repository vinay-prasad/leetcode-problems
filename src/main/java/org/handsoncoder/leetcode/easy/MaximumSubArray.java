package org.handsoncoder.leetcode.easy;

public class MaximumSubArray {
	public int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int meh = A[0], msf = A[0];
		for (int i = 1; i < A.length; i++) {
			meh = Math.max(meh + A[i], A[i]);
			msf = Math.max(msf, meh);
		}
		return msf;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
