package org.handsoncoder.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {

	public int[] intersect1(int[] nums1, int[] nums2) {
		if (nums1.length < 1 || nums2.length < 1) {
			return new int[0];
		}
		ArrayList<Integer> iList = new ArrayList<>();
		HashMap<Integer, Integer> nums1Map = new HashMap<>();
		HashMap<Integer, Integer> nums2Map = new HashMap<>();

		for (int i : nums1) {
			int val = nums1Map.containsKey(i) ? nums1Map.get(i) : 0;
			nums1Map.put(i, ++val);
		}

		for (int i : nums2) {
			int val = nums2Map.containsKey(i) ? nums2Map.get(i) : 0;
			nums2Map.put(i, ++val);
			if (nums1Map.containsKey(i) && nums1Map.get(i) >= nums2Map.get(i)) {
				iList.add(i);
			}
		}

		int[] result = new int[iList.size()];
		for (int i = 0; i < iList.size(); i++) {
			result[i] = iList.get(i);
		}
		return result;

	}

	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length < 1 || nums2.length < 1) {
			return new int[0];
		}
		int[] result = new int[Math.min(nums1.length, nums2.length)];

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i1 = 0, i2 = 0, resultLen = 0;
		while (i1 < nums1.length && i2 < nums2.length) {
			if (nums1[i1] == nums2[i2]) {
				result[resultLen] = nums1[i1];
				i1++;
				i2++;
				resultLen++;
			} else if (nums1[i1] > nums2[i2]) {
				i2++;
			} else {
				i1++;
			}
		}
		return Arrays.copyOf(result, resultLen);

	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };

		IntersectionOfTwoArraysII testObj = new IntersectionOfTwoArraysII();
		System.out.println(Arrays.toString(testObj.intersect(nums1, nums2)));
	}

}
