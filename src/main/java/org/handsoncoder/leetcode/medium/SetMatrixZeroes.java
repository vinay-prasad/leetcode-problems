package org.handsoncoder.leetcode.medium;

public class SetMatrixZeroes {

	// wont work more than one zero
	public void setZeroes1(int[][] matrix) {
		int R = matrix.length;
		int C = matrix[0].length;
		int r = 0, c = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					c = j;
					matrix[i][0] = 0;
					r = i;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			matrix[i][c] = 0;
		}
		for (int i = 0; i < C; i++) {
			matrix[r][i] = 0;
		}
	}

	public void setZeroes(int[][] matrix) {
		Boolean isCol = false;
		int R = matrix.length;
		int C = matrix[0].length;

		for (int i = 0; i < R; i++) {

			// Since first cell for both first row and first column is the same i.e.
			// matrix[0][0]
			// We can use an additional variable for either the first row/column.
			// For this solution we are using an additional variable for the first column
			// and using matrix[0][0] for the first row.
			if (matrix[i][0] == 0) {
				isCol = true;
			}

			for (int j = 1; j < C; j++) {
				// If an element is zero, we set the first element of the corresponding row and
				// column to 0
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		// Iterate over the array once again and using the first row and first column,
		// update the elements.
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// See if the first row needs to be set to zero as well
		if (matrix[0][0] == 0) {
			for (int j = 0; j < C; j++) {
				matrix[0][j] = 0;
			}
		}

		// See if the first column needs to be set to zero as well
		if (isCol) {
			for (int i = 0; i < R; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes testObj = new SetMatrixZeroes();
		int[][] matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		testObj.setZeroes(matrix);

		// [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
		matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		testObj.setZeroes(matrix);
		// TODO Auto-generated method stub

	}

}
