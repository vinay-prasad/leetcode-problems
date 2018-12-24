package org.handsoncoder.leetcode.easy;

import java.util.*;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		HashSet<String> set = new HashSet<>();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if ((board[row][col] != '.') && (!set.add(board[row][col] + "-of-row" + row) || !set.add(board[row][col] + "-of-col" + col)
						|| !set.add(board[row][col] + "-of-block-" + row / 3 + "-" + col / 3))) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku testObj = new ValidSudoku();
		char[][] board = new char [] [] {
			  {'5','3','.','.','7','.','.','.','.'},
			  {'6','.','.','1','9','5','.','.','.'},
			  {'.','9','8','.','.','.','.','6','.'},
			  {'8','.','.','.','6','.','.','.','3'},
			  {'4','.','.','8','.','3','.','.','1'},
			  {'7','.','.','.','2','.','.','.','6'},
			  {'.','6','.','.','.','.','2','8','.'},
			  {'.','.','.','4','1','9','.','.','5'},
			  {'.','.','.','.','8','.','.','7','9'}
		};
		System.out.println(testObj.isValidSudoku(board ));

	}

}
