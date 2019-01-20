package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for (int i = start; i <nums.length; i++ ) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i +1);
            tempList.remove(tempList.size() -1);
        }
    }

	public static void main(String[] args) {
		Subsets testObj = new Subsets();
		List<List<Integer>> results = testObj.subsets(new int[] {1,2,3});
		System.out.println(results);

	}

}
