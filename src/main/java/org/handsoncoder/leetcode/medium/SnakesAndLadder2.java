package org.handsoncoder.leetcode.medium;

import java.util.LinkedList;
import java.util.*;

public class SnakesAndLadder2 {

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
			for (int i = 0; i <= size; i++) {
				int cur = q.poll();
				for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
					int val = arr[next] > 0 ? arr[next] - 1 : next;
					if (val == (n * n - 1)) {
						return steps;
					} else if (!visited[val]) {
						visited[val] = true;
						q.add(val);
					}
				}

			}
			steps++;
		}
		return steps;
	}

	public int[] twoDtoOneDBoard(int[][] board) {
		int n = board.length;
		int[] oneDBoard = new int[n * n];
		int index = 0, row = n - 1, col = 0;
		while (index < n * n) {
			if (row % 2 != 0) {
				col = 0;
				while (col < n)
					oneDBoard[index++] = board[row][col++];
			} else {
				col = (n - 1);
				while (col >= 0)
					oneDBoard[index++] = board[row][col--];
			}
			row--;
		}
		return oneDBoard;
	}

	public static void main(String[] args) {
		SnakesAndLadder2 testObj = new SnakesAndLadder2();
		int[][] board = new int[][] { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, -1, -1, -1 }, { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 15, -1, -1, -1, -1 } };
				board = new int[][] {
					{-1,-1,-1},{-1,9,8},{-1,8,9}
				};

		int[][] boardTest = new int[][] { { 36, 35, 34, 33, 32, 31 }, { 25, 26, 27, 28, 29, 30 },
				{ 24, 23, 22, 21, 20, 19 }, { 13, 14, 15, 16, 17, 18 }, { 12, 11, 10, 9, 8, 7 }, { 1, 2, 3, 4, 5, 6 } };
		int res = testObj.snakesAndLadders1(board);
		System.out.println(res);
		// int[] oneDBoard = testObj.twoDtoOneDBoard(boardTest);
		// System.out.println(Arrays.toString(oneDBoard));

	}

	public int snakesAndLadders1(int[][] board) {
		int n = board.length;
		int[] arr = new int[n * n];
		int i = n - 1, j = 0, index = 0, inc = 1;
		while (index < n * n) {
			arr[index++] = board[i][j];
			if (inc == 1 && j == n - 1) {
				inc = -1;
				i--;
			} else if (inc == -1 && j == 0) {
				inc = 1;
				i--;
			} else {
				j += inc;
			}
		}
		boolean[] visited = new boolean[n * n];
		Queue<Integer> q = new LinkedList<>();
		int start = arr[0] > -1 ? arr[0] - 1 : 0;
		q.offer(start);
		visited[start] = true;
		int step = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int cur = q.poll();
				if (cur == n * n - 1) {
					return step;
				}
				for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
					int dest = arr[next] > -1 ? arr[next] - 1 : next;
					if (!visited[dest]) {
						visited[dest] = true;
						q.offer(dest);
					}
				}
			}
			step++;
		}
		return -1;
	}
}
