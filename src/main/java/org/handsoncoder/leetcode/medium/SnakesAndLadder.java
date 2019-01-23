package org.handsoncoder.leetcode.medium;

import java.util.LinkedList;
import java.util.*;

public class SnakesAndLadder {

	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		int steps = 0;
		int arr[] = twoDtoOneDBoard(board);
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n * n];
		q.add(arr[0] > 0 ? arr[0] - 1 : 0);
		visited[0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				// if found, return steps
				if (cur == (n * n - 1))
					return steps;
				// possibility of dice 1 to 6
				for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
					int val = arr[next] > 0 ? arr[next] - 1 : next;
					if (!visited[val]) {
						visited[val] = true;
						q.add(val);
					}
				}
			}
			steps++;
		}
		return -1;
	}

	// converts 2D array into 1 D array in boustrophedonical order zig-zag
	// left-right -> right-left -> left-right...
	public int[] twoDtoOneDBoard(int[][] board) {
		int n = board.length;
		int[] oneDBoard = new int[n * n];
		int index = 0, row = n - 1, col = 0;
		boolean reverse = false;
		while (index < n * n) {
			if (!reverse) {
				col = 0;
				while (col < n)
					oneDBoard[index++] = board[row][col++];
			} else {
				col = (n - 1);
				while (col >= 0)
					oneDBoard[index++] = board[row][col--];
			}
			row--;
			reverse = !reverse;
		}
		return oneDBoard;
	}

	public static void main(String[] args) {
		SnakesAndLadder testObj = new SnakesAndLadder();
		int[][] board = new int[][] { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1, -1 }, { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 15, -1, -1, -1, -1 } };

		board = new int[][] { { -1, -1, -1 }, { -1, 9, 8 }, { -1, 8, 9 } };

		int res = testObj.snakesAndLadders(board);
		System.out.println(res);

	}

}
