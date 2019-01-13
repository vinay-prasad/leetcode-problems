package org.handsoncoder.leetcode.hard;

import java.util.*;

public class ShortestDistanceFromAllBuildings {

	private static final int EMPTY = 0;
	private static final int OBSTACLE = 2;
	private static final int BUILDING = 1;

	public int shortestDistance(int[][] grid) {
		int row = grid.length;
		if (row == 0)
			return -1;
		int col = grid[0].length;
		if (col == 0)
			return -1;
		int numBuildings = 0;
		int[][] visitedGrid = new int[row][col];
		int[][] distanceGrid = new int[row][col];
		List<int[]> directions = Arrays.asList(new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 },
				new int[] { 0, -1 });

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == BUILDING) {
					numBuildings++;
					q.add(new int[] { i, j, 1, numBuildings });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] point = q.poll();
			int x = point[0];
			int y = point[1];
			int d = point[2];
			int building = point[3];
			for (int[] direction : directions) {
				int r = x + direction[0];
				int c = y + direction[1];
				
				System.out.println(r+ "-"+c);
				if (r==0 && c ==2) {
					System.out.println("0-2 " + grid[r][c]);
				}
				if (r==1 && c ==2) {
					System.out.println("1-2 "+ grid[r][c]);
				}

				if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == EMPTY && visitedGrid[r][c] < building) {
					++visitedGrid[r][c];
					distanceGrid[r][c] += d;
					// grid[r][c] = OBSTACLE;
					if (visitedGrid[r][c] == numBuildings) {
						return distanceGrid[r][c] + 1;
					} else {
						q.add(new int[] { r, c, d + 1, building });
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ShortestDistanceFromAllBuildings testObj = new ShortestDistanceFromAllBuildings();
		int[][] grid;
		int result;
		grid = new int[][] { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
		result = testObj.shortestDistance(grid);
		System.out.println(result);

	}

}
