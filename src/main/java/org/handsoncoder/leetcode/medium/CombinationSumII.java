package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List <List <Integer>> list = new ArrayList <>();
        Arrays.sort(candidates);
        backtrack(list, candidates, new ArrayList<Integer>(), target, 0);
        return list;
    }
    
    private void backtrack(List <List<Integer>> list, int [] nums, List<Integer> tempList, int remains, int start){
        if (remains < 0) {
            return;
        }else if (remains == 0) {
            list.add(new ArrayList<>(tempList));
        }else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(list, nums, tempList, remains - nums[i], i+1);
                tempList.remove(tempList.size() -1);
            }
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
