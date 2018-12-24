package org.handsoncoder.leetcode.medium;

import java.util.Arrays;

public class RotateImage {

	public void rotate(int[][] matrix) {
		int low = 0;
		int high = matrix.length - 1;
		while (low < high) {
			int[] temp = matrix[low];
			matrix[low] = matrix[high];
			matrix[high] = temp;
			low++;
			high--;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		RotateImage testObj = new RotateImage();
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		testObj.rotate(matrix);
		System.out.println(Arrays.toString(matrix));

		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		testObj.rotate(matrix);
		System.out.println(Arrays.toString(matrix));
	}

}
