package org.handsoncoder.amazon.oa;

import java.util.*;

public class SubstringsOfSizeKWithKDistinctChars {
	public List<String> Count(String S, int k) {
		
		int left = 0, right =0;
		int [] charMap = new int[256];
		int distinct =0;
		Set <String> set = new HashSet<>();
		
		while(right < S.length()) {
			charMap[S.charAt(right)]++;
			// is character distinct
			if (charMap[S.charAt(right)] == 1) {
				distinct++;
				if (distinct > k) {
					charMap[S.charAt(left)]--;
					if (charMap[S.charAt(left)] ==0) {
						distinct--;
					}
					left++;
				}
			}
			// is character NOT distinct
			else {
				while(charMap[S.charAt(right)]!=1) { //
					charMap[S.charAt(left)]--;
					if (charMap[S.charAt(left)] ==0) {
						distinct--;
					}
					left++;
				}
			}
			if (distinct ==k && right -left+1 ==k) {
				set.add(S.substring(left, right+1));
			}
			right++;
		}

		return new ArrayList<>(set);
	}

	// asldl
	public static void main(String[] args) {
		
		SubstringsOfSizeKWithKDistinctChars testObj = new SubstringsOfSizeKWithKDistinctChars();
		String S = "awaglknagawunagwkwagl";
		// ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag",
		// "nagw", "agwk", "kwag"]
		int k = 4;
		
		List<String> result = testObj.Count(S, k);

		System.out.println(result.toString());

	}

}
