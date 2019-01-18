package org.handsoncoder.leetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int [] leftMul = new int[nums.length]; // 
		int [] rightMul = new int[nums.length];
		
		int ls =1;
		for (int i =0; i<nums.length; i++) {
			leftMul[i]=ls;
			ls = ls* nums[i];
		}
		// leftMul = [1, 1, 2, 6]
		
		int rs =1;
		for (int i = (nums.length -1); i>=0; i--) {
			rightMul[i]=rs;
			rs = rs* nums[i];
		}
		// rightMul = [24, 12, 4, 1]
		for (int i = 0; i <nums.length; i++) {
			nums[i] = leftMul[i]*rightMul[i];
		}
		
		// nums = [24, 12, 8, 6]
		return nums;
    }
	public int[] productExceptSelf_Best(int[] nums) {
	    int leng = nums.length;
	    int[] ret = new int[leng];
	    if(leng == 0)
	        return ret;
	    int runningprefix = 1;
	    for(int i = 0; i < leng; i++){
	        ret[i] = runningprefix;
	        runningprefix*= nums[i];
	    }
	    int runningsufix = 1;
	    for(int i = leng -1; i >= 0; i--){
	        ret[i] *= runningsufix;
	        runningsufix *= nums[i];
	    }
	    return ret;
	    
	}

	// uses division (/) operator
	public int[] productExceptSelf_V1(int[] nums) {
		int mul = 1;
		for (int num : nums) {
			mul *= num;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[i] = mul / nums[i];
		}
		return nums;
	}

	public static void main(String[] args) {
		ProductOfArrayExceptSelf testObj = new ProductOfArrayExceptSelf();
		int[] result = testObj.productExceptSelf(new int[] {1,2,3,4});
		System.out.println(Arrays.toString(result));
		
		result = testObj.productExceptSelf(new int[] {3,2,5,7});
		System.out.println(Arrays.toString(result));

	}

}
