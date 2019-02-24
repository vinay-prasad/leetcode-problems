package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class DecodingWays {

	// Trying with backtracking
	public int numDecodings(String s) {
		List<List<String>> list = new ArrayList<>();
		backtracking(list, new ArrayList<String>(), s, 0);
		return list.size();
	}

	private void backtracking(List<List<String>> list, ArrayList<String> tempList, String s, int start) {
		if (s.length() == start) {
			for (String str : tempList) {
				if (str.length() > 2) {
					return;
				}
				if (str.startsWith("0") || Integer.parseInt(str)< 1 || Integer.parseInt(str) > 26) {
					return;
				}
			}
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = start; i < s.length(); i++) {
				tempList.add(s.substring(start, i + 1));
				backtracking(list, tempList, s, i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		DecodingWays testObj = new DecodingWays();
		testObj.numDecodings("02");
	}

}
