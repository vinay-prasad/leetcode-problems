package org.handsoncoder.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBetweenTwoNodesInaGrid {
	class Cell {
		int row;
		int column;
		int distance;

		public Cell(int row, int column, int distance) {
			this.row = row;
			this.column = column;
			this.distance = distance;
		}
	}

	int minPath(int numRows, int numColumns, List<List<Integer>> grid) {
		int destination = 9;
		int noEntry = 0;

		int sourceX = 0;
		int sourceY = 0;
		int distance = 0;

		Cell source = new Cell(sourceX, sourceY, distance);
		Queue<Cell> cellQ = new LinkedList<>();

		int x[] = { 0, 0, 1, -1 };
		int y[] = { 1, -1, 0, 0 };

		cellQ.add(source);
		while (!cellQ.isEmpty()) {
			Cell currentCell = cellQ.remove();
			int currRow = currentCell.row;
			int currCol = currentCell.column;
			int currDist = currentCell.distance;

			if (grid.get(currRow).get(currCol) == destination) {
				return currDist;
			}
			grid.get(currRow).set(currCol, noEntry);
			for (int i = 0; i < x.length; i++) {
				int newRow = currRow + x[i];
				int newCol = currCol + y[i];
				int newDistance = currDist++;

				if (newRow >= 0 && newRow < numRows && newCol > 0 && newCol < numColumns
						&& grid.get(newRow).get(newCol) != noEntry) {
					Cell newCell = new Cell(newRow, newCol, newDistance);
					cellQ.add(newCell);
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		ShortestPathBetweenTwoNodesInaGrid testObj = new ShortestPathBetweenTwoNodesInaGrid();
		List<List<Integer>> grid = new ArrayList<List<Integer>>();
		grid.add(Arrays.asList(new Integer[] { 1, 1, 1, 1, 1 }));
		grid.add(Arrays.asList(new Integer[] { 1, 1, 0, 1, 1 }));
		grid.add(Arrays.asList(new Integer[] { 1, 1, 1, 1, 1 }));
		grid.add(Arrays.asList(new Integer[] { 0, 1, 1, 9, 1 }));
		grid.add(Arrays.asList(new Integer[] { 1, 1, 1, 1, 0 }));

		System.out.println(testObj.minPath(5, 5, grid));

		grid = new ArrayList<List<Integer>>();
		grid.add(Arrays.asList(new Integer[] { 1, 1, 1, 1 }));
		grid.add(Arrays.asList(new Integer[] { 0, 1, 1, 1 }));
		grid.add(Arrays.asList(new Integer[] { 0, 1, 9, 0 }));
		grid.add(Arrays.asList(new Integer[] { 1, 1, 1, 1 }));
		grid.add(Arrays.asList(new Integer[] { 0, 0, 1, 1 }));

		System.out.println(testObj.minPath(5, 4, grid));

	}

}
