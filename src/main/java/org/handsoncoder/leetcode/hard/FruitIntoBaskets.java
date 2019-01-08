package org.handsoncoder.leetcode.hard;

public class FruitIntoBaskets {

	public int totalFruit(int[] tree) {

		int left = 0, right = 0, k = 2, distinct = 0, max = 0;
		int[] treeMap = new int[tree.length];

		while (right <tree.length) {
			treeMap[tree[right]]++;
			if (treeMap[tree[right]] == 1) {
				distinct++;
			}
			if (distinct > k) {
				while (distinct > k) {
					treeMap[tree[left]]--;
					if (treeMap[tree[left]] == 0) {
						distinct--;
					}
					left++;
				}
			} else {
				max = Math.max(max, right - left + 1);
			}
			right++;
		}
		return max;
	}

	public static void main(String[] args) {
		FruitIntoBaskets testObj = new FruitIntoBaskets();
		int[] tree = new int[] { 1, 2, 1 };
		int results = testObj.totalFruit(tree);
		System.out.println(results);
		
		tree = new int[] {3,3,3,1,2,1,1,2,3,3,4};
		results = testObj.totalFruit(tree);
		System.out.println(results);
	}

}
