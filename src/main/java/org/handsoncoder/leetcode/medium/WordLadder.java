package org.handsoncoder.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		// Convert list into set because we will need to check for valid word multiple
		// times
		Set<String> dic = new HashSet<>(wordList);
		// Queue to to perform BFS on each possible word
		Queue<String> que = new LinkedList<>();
		// Set to keep track of every visited words
		Set<String> set = new HashSet<>();
		int level = 1;
		que.add(beginWord);
		// this will help in tacking the level
		que.add(null);
		set.add(beginWord);

		while (!que.isEmpty()) {
			String word = que.poll();
			if (word != null) {

				for (int i = 0; i < word.length(); i++) {
					char[] arr = word.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						arr[i] = c;
						String newWord = new String(arr);
						if (dic.contains(newWord) && !set.contains(newWord)) {
							set.add(newWord);
							que.add(newWord);
						}
						if (dic.contains(newWord) && newWord.equals(endWord)) {
							return level + 1;
						}
					}
				}

			} else {
				// if string is null that means its end of the previous word
				level++;
				if (!que.isEmpty()) {
					que.add(null);
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
