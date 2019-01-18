package org.handsoncoder.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for (int num : nums)
			set.add(num);
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				int val = num;
				while (set.remove(val++)) {
					max = Math.max(max, (val - num));
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestConsecutiveSubsequence testObj = new LongestConsecutiveSubsequence();
		int res = testObj.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 });
		System.out.println(res);

	}

}
