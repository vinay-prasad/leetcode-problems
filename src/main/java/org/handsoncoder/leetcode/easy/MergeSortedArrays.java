package org.handsoncoder.leetcode.easy;

import java.util.Arrays;

// Pat your back
public class MergeSortedArrays {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else if (nums1[i] < nums2[j]) {
				nums1[k--] = nums2[j--];
			} else if (nums1[i] == nums2[j]) {
				nums1[k--] = nums1[i--];
				nums1[k--] = nums2[j--];
			}
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}

	public static void main(String[] args) {
		/*
		 * nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
		 */

		int[] nums1 = new int[6];
		nums1[0] = 1;
		nums1[1] = 2;
		nums1[2] = 3;
		int[] nums2 = new int[] { 2, 5, 6 };

		System.out.println(nums1.length + " " + nums2.length);

		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));

		nums1 = new int[2];
		nums1[0] = 1;
		nums2 = new int[] { 2 };

		System.out.println(nums1.length + " " + nums2.length);

		merge(nums1, 1, nums2, 1);
		System.out.println(Arrays.toString(nums1));
	}

}
