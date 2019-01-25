package org.handsoncoder.leetcode.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.handsoncoder.leetcode.google.phonescreen.TreeNode;

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

	/**
	 * 15. 3Sum [Amazon] -
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] > 0) {
					right--;
				} else if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while ((left < right) && (nums[left] == nums[left + 1]))
						left++;
					while ((left < right) && (nums[right] == nums[right + 1]))
						right--;
					left++;
				}
			}
		}
		return res;
	}

	/**
	 * 17. Letter Combinations of a Phone Number
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		return null;

	}

	/**
	 * 21. Merge Two Sorted Lists [Amazon] - Use recursion or while loop. Make sure
	 * to use the dummy node and NOT the head node
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode dummy = head;
		helper(dummy, l1, l2);
		return head.next;
	}

	private void helper(ListNode head, ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return;
		if (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
		} else if (l1 != null) {
			head.next = l1;
			l1 = l1.next;
		} else if (l2 != null) {
			head.next = l2;
			l2 = l2.next;
		}
		head = head.next;
		helper(head, l1, l2);
	}

	/**
	 * 48. Rotate Image [Amazon] - Two steps to solve the problem. Swap the top rows
	 * with bottom rows and then swap the diagonal elements
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int top = 0, bottom = matrix.length - 1;
		while (top < bottom) {
			int[] temp = matrix[top];
			matrix[top] = matrix[bottom];
			matrix[bottom] = temp;
			top++;
			bottom--;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	/**
	 * 49. Group Anagrams [Amazon] - Use HashMap to store the sorted String as key
	 * and the anagram string as values
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		List<List<String>> res = new ArrayList<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}

	/**
	 * 102. Binary Tree Level Order Traversal [Amazon] - level order means BFS. Use
	 * queue to perform BFS. Add null after every left-right child to keep track of
	 * level
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		if (root != null) {
			q.add(root);
			q.add(null);
			int level = 0;
			while (!q.isEmpty()) {
				TreeNode node = q.poll();
				if (node != null) {
					if (res.size() - 1 != level) {
						res.add(new ArrayList<Integer>());
					}
					res.get(level).add(node.val);
					if (node.left != null)
						q.add(node.left);
					if (node.right != null)
						q.add(node.right);
				} else {
					level++;
					if (!q.isEmpty()) {
						q.add(null);
					}
				}
			}
		}
		return res;
	}

	/**
	 * 121. Best Time to Buy and Sell Stock [Amazon] - The key here is to use two
	 * variables maxProfit and minPrice and with every iteration compare the current
	 * price/profit
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxProfit = 0, minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			}
		}
		return maxProfit;
	}

	/**
	 * 141. Linked List Cycle [Amazon] - Use a slow pointer and a fast pointer to
	 * see if they eventually meet at some point or not. Look at shorter version of
	 * the same solution hasCycle2
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		ListNode slow = null;
		ListNode fast = null;
		if (head != null)
			slow = head.next;
		else
			return false;
		if (head.next != null && head.next.next != null)
			fast = head.next.next;
		else
			return false;
		while (!slow.equals(fast)) {
			slow = slow.next;
			if (slow == null)
				return false;

			if (fast != null && fast.next != null)
				fast = fast.next.next;
			else
				return false;
		}
		return true;
	}

	public boolean hasCycle2(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	/**
	 * 160. Intersection of Two Linked Lists [Amazon] - Trick is to move the next
	 * pointers of both nodes and append NodeA to NodeB and NodeB to NodeA. Look ar
	 * the shorter version of the same solution
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode dummyA = headA;
		ListNode dummyB = headB;
		ListNode intersection = null;
		boolean isAplugged = false;
		boolean isBplugged = false;
		while (true) {
			if (!isAplugged && dummyA == null) {
				isAplugged = true;
				dummyA = headB;
			}
			if (!isBplugged && dummyB == null) {
				isBplugged = true;
				dummyB = headA;
			}
			if (dummyA == null || dummyB == null) {
				break;
			}
			if (dummyA.equals(dummyB)) {
				intersection = dummyA;
				break;
			}

			dummyA = dummyA.next;
			dummyB = dummyB.next;
		}
		return intersection;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

		ListNode dummyA = headA, dummyB = headB, ptrA = dummyA, ptrB = dummyB;
		boolean flagA = false, flagB = false;

		while (ptrA != null && ptrB != null) {
			if (ptrA == ptrB)
				return ptrA;
			ptrA = ptrA.next;
			ptrB = ptrB.next;

			if (ptrA == null && !flagA) {
				flagA = true;
				ptrA = dummyB;
			}
			if (ptrB == null && !flagB) {
				ptrB = dummyA;
				flagB = true;
			}
		}

		return null;
	}

	/**
	 * 167. Two Sum II - Input array is sorted [Amazon, Favorite] - Classic Two
	 * Pointers
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSumII(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;

		while (left < right) {
			if (numbers[left] + numbers[right] > target) {
				right--;
			} else if (numbers[left] + numbers[right] < target) {
				left++;
			} else {
				return new int[] { left + 1, right + 1 };
			}
		}
		return new int[] { -1, -1 };

	}

	/**
	 * 189. Rotate Array [Amazon] - Trick is to perform three steps 1. reverse whole
	 * array, 2. reverse first k array 3. reverse rest. Remember k %= nums.length
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

	/**
	 * 199. Binary Tree Right Side View [Amazon, Favorite] - Little twist to BFS.
	 * Use null to maintain levels and add children from right to left rather right
	 * to left
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root != null) {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			int level = 0;
			q.add(root);
			q.add(null);

			while (!q.isEmpty()) {
				TreeNode node = q.poll();
				if (node != null) {
					if (result.size() - 1 != level) {
						result.add(node.val);
					}
					if (node.right != null)
						q.add(node.right);
					if (node.left != null)
						q.add(node.left);

				} else {
					level++;
					if (!q.isEmpty()) {
						q.add(null);
					}
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
