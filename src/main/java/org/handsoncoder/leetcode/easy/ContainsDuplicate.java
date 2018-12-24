package org.handsoncoder.leetcode.easy;

import java.util.HashSet;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		HashSet <Integer> set = new HashSet <>();
		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			}else {
				set.add(num);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
