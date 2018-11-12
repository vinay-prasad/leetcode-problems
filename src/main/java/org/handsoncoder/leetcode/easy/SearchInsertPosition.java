package org.handsoncoder.leetcode.easy;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		return binarySearch(nums, nums.length / 2, 0, nums.length, target);
	}

	private int binarySearch(int[] nums, int mid, int start, int end, int target) {
		System.out.println("ran");
		if (start < end && mid > 0) {
			if (nums[mid] == target)
				return mid;
			if (nums[mid - 1] == target)
				return mid - 1;
			if (nums[mid + 1] == target)
				return mid + 1;

			if (target > nums[mid] && target < nums[mid + 1])
				return mid + 1;

			if (target > nums[mid - 1] && target < nums[mid])
				return mid;

			if (target < nums[mid]) {
				return binarySearch(nums, mid / 2, start, mid - 1, target);
			} else if (target > nums[mid]) {
				return binarySearch(nums, mid + mid / 2, mid + 1, end, target);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 6, 7, 8, 9, 10,  12 };
		System.out.println(new SearchInsertPosition().searchInsert(arr, 11));

	}

}
