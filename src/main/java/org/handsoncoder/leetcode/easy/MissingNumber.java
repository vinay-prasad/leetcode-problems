package org.handsoncoder.leetcode.easy;

public class MissingNumber {

	public int missingNumber(int[] nums) {
		int actualSum = 0;
		int expectedSum = nums.length*(nums.length + 1)/2;
		
         for (int num : nums) {
        	 actualSum+=num;
         }
        return expectedSum - actualSum;
	}

	public static void main(String[] args) {
		MissingNumber testObj = new MissingNumber();
		System.out.println(testObj.missingNumber(new int[] {1,2,3,4,6}));
	}
}
