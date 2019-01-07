package org.handsoncoder.leetcode.hard;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0;
		int nums1L = nums1.length, nums2L = nums2.length, med1 = 0, med2 = 0, left = 0, right = 0, counter = 0,
				totalLength = nums1L + nums2L;
		if (nums1L == nums2L && nums2L == 0) {
			return median;
		}
        if (nums1L ==0 && nums2L == 1) {
			return nums2[right];
		}
		if (nums2L ==0 && nums1L == 1) {
			return nums1[left];
		}
		boolean isEven = (totalLength) % 2 == 0;
		while (counter < (totalLength) / 2) {
			int num = 0;
			if (!(left < nums1L) || nums1L == 0) {
				num = nums2[right];
				right++;
			} else if (!(right < nums2L) || nums2L == 0) {
				num = nums1[left];
				left++;
			} else {
				if (nums1[left] <= nums2[right]) {
					num = nums1[left];
					left++;
				} else {
					num = nums2[right];
					right++;
				}
			}
			counter++;
			if (counter == (totalLength) / 2) {
				med1 = num;
				if (!(left < nums1L) || nums1L == 0) {
					med2 = nums2[right];
				} else if (!(right < nums2L) || nums2L == 0) {
					med2 = nums1[left];
				} else {
					med2 = nums1[left] <= nums2[right] ? nums1[left] : nums2[right];
				}
				if (isEven) {
					median = (med1 + med2) / 2.0;
				} else if (!isEven) {
					median = med2;
				}
			}
		}
		return median;
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays testObj = new MedianOfTwoSortedArrays();
		int[] nums1 = new int[] { 1, 3 };
		int[] nums2 = new int[] { 2 };
		double result = testObj.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);

		nums1 = new int[] { 1, 2 };
		nums2 = new int[] { 3, 4 };
		result = testObj.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);

		nums1 = new int[] {};
		nums2 = new int[] {};
		result = testObj.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);

		nums1 = new int[] {};
		nums2 = new int[] { 1, 2, 3, 4, 5 };
		result = testObj.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
		
		nums1 = new int[] {};
		nums2 = new int[] { 1};
		result = testObj.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}

}
