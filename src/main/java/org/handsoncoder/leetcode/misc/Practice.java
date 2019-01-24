package org.handsoncoder.leetcode.misc;

import java.util.*;

/**
 * @author vinay
 *
 */
public class Practice {

	/**
	 * 1. Two Sum [Amazon] - HashMap is the key.Can not do sorting in this version
	 * of question as we need to return the index of elements not the actual
	 * elements
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]), i };
			}
			map.put(target - nums[i], i);
		}
		return new int[] { -1, -1 };
	}

	/**
	 * 2. Add two numbers [Amazon] - special case of carry needs to be taken care
	 * of. This can be further shortened to only 1 while loop where we need to
	 * handle either of null lists
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = new ListNode(-1);
		ListNode dummy = head;
		while (l1 != null && l2 != null) {
			int val = l1.val + l2.val + carry;
			carry = val / 10;
			val = val % 10;
			dummy.next = new ListNode(val);
			l1 = l1.next;
			l2 = l2.next;
			dummy = dummy.next;
		}

		while (l1 != null) {
			int val = l1.val + carry;
			carry = val / 10;
			val = val % 10;
			dummy.next = new ListNode(val);
			l1 = l1.next;
			dummy = dummy.next;
		}
		while (l2 != null) {
			int val = l2.val + carry;
			carry = val / 10;
			val = val % 10;
			dummy.next = new ListNode(val);
			l2 = l2.next;
			dummy = dummy.next;
		}
		if (carry != 0) {
			dummy.next = new ListNode(carry);
		}
		return head.next;
	}

	/**
	 * 200. No of islands [Amazon] - Use DFS to mark all the islands visited. List
	 * "dir" can be replaced with adding co ordinates directly
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		List<int[]> dir = Arrays.asList(new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 },
				new int[] { 0, -1 });
		int count = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == '1') {
					count++;
					helper(grid, dir, grid.length, grid[0].length, r, c);
				}
			}
		}
		return count;

	}

	private void helper(char[][] grid, List<int[]> dir, int rowL, int colL, int r, int c) {
		if (r >= 0 && r < rowL && c >= 0 && c < colL && grid[r][c] == '1') {
			grid[r][c] = '0';
			helper(grid, dir, rowL, colL, r + dir.get(0)[0], c + dir.get(0)[1]);
			helper(grid, dir, rowL, colL, r + dir.get(1)[0], c + dir.get(1)[1]);
			helper(grid, dir, rowL, colL, r + dir.get(2)[0], c + dir.get(2)[1]);
			helper(grid, dir, rowL, colL, r + dir.get(3)[0], c + dir.get(3)[1]);
		}
	}

	/**
	 * 3. Longest Substring Without Repeating Characters [Amazon, Favorite] - Two
	 * pointers and int[] as charMap. Take care of s.charAt(left) vs chars[left]
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int[] chars = new int[256];
		int left = 0, right = 0, max = 0;
		while (right < s.length()) {
			if (++chars[s.charAt(right)] == 1) {
				max = Math.max(max, right - left + 1);
			} else {
				while (chars[s.charAt(right)] != 1) {
					chars[s.charAt(left++)]--;
				}
			}
			right++;
		}
		return max;
	}

	/**
	 * 42. Trapping Rain Water [Amazon] - Two pointers trick. Remember to move the
	 * left/right pointers
	 * 
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		int maxL = 0, maxR = 0, sum = 0, left = 0, right = height.length - 1;

		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] > maxL) {
					maxL = height[left];
				} else {
					sum += (maxL - height[left]);
				}
				left++;
			} else {
				if (height[right] > maxR) {
					maxR = height[right];
				} else {
					sum += (maxR - height[right]);
				}
				right--;
			}
		}
		return sum;
	}

	/**
	 * 20. Valid Parentheses [Amazon] - Stack solution is the best. Remember to
	 * cover empty stack scenarios
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (c == '(')
				stack.push(')');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
