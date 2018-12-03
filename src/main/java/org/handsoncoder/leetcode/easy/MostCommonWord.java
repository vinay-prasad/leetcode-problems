package org.handsoncoder.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

 

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 

Note:

1 <= paragraph.length <= 1000.
1 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
*/
public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		String mostCommonWord = "";
		int mostCommonWordCount = 0;
		paragraph = formatParaGraph(paragraph);
		String[] words = paragraph.split(" ");
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		for (String word : words) {
			if (!word.isEmpty()) {

				word = word.toLowerCase();
				if (!isBanned(word, banned)) {
					Integer curCountW = wordMap.get(word);
					if (curCountW == null) {
						curCountW = 1;
						wordMap.put(word, curCountW);
					} else {
						wordMap.put(word, ++curCountW);
					}
					if (curCountW > mostCommonWordCount) {
						mostCommonWordCount = curCountW;
						mostCommonWord = word;
					}
				}
			}
		}
		return mostCommonWord;
	}

	private String formatParaGraph(String paragraph) {
		StringBuffer strBuff = new StringBuffer();
		for (char c : paragraph.toCharArray()) {
			if (Character.isLetter(c) || c == ' ') {
				strBuff.append(c);
			} else {
				strBuff.append(" ");
			}
		}
		return strBuff.toString();
	}

	private boolean isBanned(String word, String[] banned) {
		boolean isBanned = false;
		for (String bannedWord : banned) {
			if (bannedWord.equalsIgnoreCase(word))
				return true;
		}
		return isBanned;
	}

	public static void main(String[] args) {
		MostCommonWord testObj = new MostCommonWord();
		// String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String paragraph = "Bob. hIt, baLl";
		String[] banned = { "bob", "hit" };
		String output = testObj.mostCommonWord(paragraph, banned);
		System.out.println(output);

	}

}
