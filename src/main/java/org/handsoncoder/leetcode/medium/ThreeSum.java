package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		if (nums[0] == nums[nums.length - 1]) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[0]);
			list.add(nums[0]);
			list.add(nums[0]);
			result.add(list);
			return result;
		}
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int start = 0;
			int end = nums.length - 1;
			while (start < end) {
				if (i != start && i != end) {

					int twoSum = nums[start] + nums[end];
					if (twoSum + num == 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(num);
						list.add(nums[start]);
						list.add(nums[end]);
						Collections.sort(list, new Comparator<Integer>() {
							public int compare(Integer o1, Integer o2) {
								return o1.compareTo(o2);
							}
						});
						if (!set.contains(list.toString())) {
							set.add(list.toString());
							result.add(list);
						}
						// this is important
						start++;
						end--;
						// break;

					}
					if (twoSum + num < 0) {
						start++;
					}
					if (twoSum + num > 0) {
						end--;
					}
				} else if (i == start) {
					start++;
				} else if (i == end) {
					end--;
				}
			}
		}
		return result;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || n <= 2)
			return result;
		Arrays.sort(nums);
		if (nums[0] == nums[n - 1] && nums[0] == 0) {
			result.add(Arrays.asList(0, 0, 0));
			return result;
		}
		for (int i = 0; i < n; i++) {
			int j = i + 1, k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum > 0) {
					k--;
				} else if (sum <= 0) {
					if (sum == 0) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
						while (j < k && nums[j] == nums[j + 1])
							j++;
						while (j < k && nums[k] == nums[k - 1])
							k--;
					}
					j++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		ThreeSum testObj = new ThreeSum();
		System.out.println(testObj.threeSum(nums));
	}

}
