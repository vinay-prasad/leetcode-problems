package org.handsoncoder.leetcode.easy;
// Unsolved
import java.util.Arrays;

public class NextGreaterElement {

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int nums3[] = new int[nums1.length];
		for (int i = 0; i <= nums1.length - 1; i++) {
			for (int j = 0; j <= nums2.length -1; j++) {
				if (nums2[j] > nums1[i]) {
					nums3[i] = nums2[j];
					nums2[j] = -1;
					break;
				} else {
					nums3[i] = -1;
				}
			}
		}
		return nums3;

	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };
		System.out.println(Arrays.toString(NextGreaterElement.nextGreaterElement(nums1, nums2)));

	}
}
