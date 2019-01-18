package org.handsoncoder.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MinSizeSubarrayEqualsSum {
	
	public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0, right = 0, min = Integer.MAX_VALUE, sum = nums[0];
        while(right < nums.length){
            if(sum < s){
                right++;
                if(right == nums.length) break;
                sum += nums[right];
            // sum equals or greater    
            }else{
                min = Math.min(min, right-left+1);
                left++;
                sum -= nums[left-1];
            }
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }
	
	// works for sum equals not greater
	public int minSubArrayLen_V1(int s, int[] nums) {
        int  min =Integer.MAX_VALUE, sum =0;
        Map <Integer, Integer> map = new HashMap<>();
        for (int i =0 ; i < nums.length; i++) {
            sum+=nums[i];
            if (sum == s){
                min = Math.min(min, (i+1));
            } else if (map.containsKey(sum-s)){
                min = Math.min(min, (i - map.get(sum-s)));
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return (min==Integer.MAX_VALUE) ? 0 : min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
