package org.handsoncoder.leetcode.medium;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int max = 0;
		if (height != null && height.length != 0) {
			int left = 0;
			int right = height.length - 1;
			while (left < right) {
				// next two if conditions are to make sure there are two non-zero containers to
				// hold water. If not move next to find one
				if (height[left] == 0) {
					left++;
					continue;
				}
				if (height[right] == 0) {
					right--;
					continue;
				}
				// if control came here that means left and right containers are non zero and
				// can hold water. Get the count of containers and multiple by lower container
				if (height[left] < height[right]) {
					max = Math.max(max, (right - left) * height[left]);
					left++;
				} else {
					max = Math.max(max, (right - left) * height[right]);
					right--;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
