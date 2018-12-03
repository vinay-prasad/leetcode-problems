package org.handsoncoder.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        HashSet <Integer> set = new HashSet<Integer>();
        HashSet <Integer> set2 = new HashSet <Integer>();
        for ( int i : nums1) {
            if (!set.contains(i)){
                set.add(i);
            }    
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                set2.add(i);
            }
        }
        
        int [] arr = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
        	arr[index] = i;
        	index++;
        }
        return arr;
    }
	public static void main(String[] args) {
		int [] nums1 = {1,2,2,1};
		int [] nums2 = {2,2};
		IntersectionOfTwoArrays testObj = new IntersectionOfTwoArrays();
		System.out.println(Arrays.toString(testObj.intersection(nums1, nums2)));
		
				
		// TODO Auto-generated method stub

	}

}
