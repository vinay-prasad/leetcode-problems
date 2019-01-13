package org.handsoncoder.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {

	private int GATE = 0;
	private int EMPTY = Integer.MAX_VALUE;
	private List<int[]> DIRECTIONS = Arrays.asList(new int[] { 0, 1 }, new int[] { 0, -1 }, new int[] { 1, 0 },
			new int[] { -1, 0 });

	public void wallsAndGates(int[][] rooms) {
		int row = rooms.length;
		if (row == 0)
			return;
		int col = rooms[0].length;
		if (col == 0)
			return;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (rooms[i][j] == GATE) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] point = q.poll();
			int x = point[0];
			int y = point[1];

			for (int[] direction : DIRECTIONS) {
				int r = x + direction[0];
				int c = y + direction[1];

				if (r >= 0 && r < row && c >= 0 && c < col && rooms[r][c] == EMPTY) {
					rooms[r][c] = rooms[x][y] + 1;
					q.add(new int[] { r, c });
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
