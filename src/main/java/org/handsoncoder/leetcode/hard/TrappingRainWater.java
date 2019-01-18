package org.handsoncoder.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class TrappingRainWater {

	public int trap1(int[] height) {
		int n = height.length;
		if (n <= 1)
			return 0;
		int count = 0;
		int level = 1;
		while (level != -1) {
			int left = 0;
			int right = n - 1;
			boolean foundLeftHi = false;
			boolean foundRightHi = false;
			while (left <= right) {
				if (!foundLeftHi && !(height[left] >= level))
					left++;
				if (!foundRightHi && !(height[right] >= level))
					right--;
				if (height[left] >= level)
					foundLeftHi = true;
				if (height[right] >= level)
					foundRightHi = true;

				if (foundLeftHi && foundRightHi) {
					if (height[left] < level)
						count++;
					if (left != right && height[right] < level)
						count++;
					right--;
					left++;
				}
			}
			if (foundLeftHi || foundRightHi) {
				level++;
			} else {
				level = -1;
			}
		}
		return count;
	}

	public int trap(int[] height) {
		int result = 0, left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
		while (left < right) {
			if (height[left] <= height[right]) {
				if (height[left] >= leftMax) {
					leftMax = height[left];
				} else {
					result += (leftMax - height[left]);
				}
				left++;
			} else {
				if (height[right] >= rightMax) {
					rightMax = height[right];
				} else {
					result += (rightMax - height[right]);
				}
				right--;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		TrappingRainWater testObj = new TrappingRainWater();
		int res = testObj.trap(new int[] { 1, 3, 0, 1, 0, 1, 0, 2, 1, 0, 1, 1, 1, 0, 3 });
		System.out.println(" >>> " + res);

		res = testObj.trap(new int[] { 0, 2, 0 });
		System.out.println(" >>> " + res);

		res = testObj.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
		System.out.println(" >>> " + res);

		res = testObj.trap(new int[] { 0 });
		System.out.println(" >>> " + res);

		res = testObj.trap(new int[] {});
		System.out.println(" >>> " + res);

		res = testObj.trap(new int[] { 0, 1 });
		System.out.println(" >>> " + res);

		res = testObj.trap(new int[] { 2, 0, 2 });
		System.out.println(" >>> " + res);
	}

}
