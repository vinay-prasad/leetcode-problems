package org.handsoncoder.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SingleNumber {
	public int singleNumber1(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				set.remove(num);
			} else {
				set.add(num);
			}
		}

		for (int num : set) {
			return num;
		}
		return -1;
	}

	public int singleNumber2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.remove(num);
			} else {
				map.put(num, Integer.MAX_VALUE);
			}
		}

		for (int num : map.keySet()) {
			return num;
		}
		return -1;
	}

	public int singleNumber3(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i += 2) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		if (nums.length % 2 != 0) {
			return nums[nums.length - 1];
		}
		return -1;
	}

	public int singleNumber(int[] nums) {
		int i = 0;
		for (int num : nums) {
			i ^= num;
		}

		return i;
	}

	public static void main(String[] args) {
		SingleNumber testObj = new SingleNumber();
		System.out.println((testObj.singleNumber(new int[] { 4, 1, 2, 1, 2 })));

	}

}
