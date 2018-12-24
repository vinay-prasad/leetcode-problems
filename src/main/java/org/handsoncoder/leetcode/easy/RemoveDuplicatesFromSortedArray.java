package org.handsoncoder.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums, int val) {
		int pointer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[pointer] = nums[i];
				pointer++;
			} else {
				// do nothing
			}
		}
		return (pointer);
	}
	
	public static int removeDuplicates(int[] nums) {
        if (nums.length ==1) {
            return 1;
        }
        int fp = 0;
        int sp = 1;
        
        while (sp < nums.length) {
            if (nums[fp] == nums[sp]) {
                sp++;
            }else {
                nums[++fp] = nums[sp++];
            }
        }
        return fp;
	}

	public static void main(String[] args) {
		System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates((new int[] { 1, 2, 2 }), 2));
		System.out.println(new RemoveDuplicatesFromSortedArray()
				.removeDuplicates((new int[] { 0, 0, 1, 1,1,1, 1, 2, 2, 3, 3, 4 }), 1));
		System.out.println(removeDuplicates(new int[] {1,1,2}));

	}

}
