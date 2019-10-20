package org.handsoncoder.amazon.oa;

import java.util.*;

public class SubstringsOfSizeKWithKDistinctChars {
	public List<String> Count(String S, int k) {

		int charmap[] = new int[256];
		int hi = 0, lo = 0;
		int distinct = 0;
		Set<String> set = new HashSet<>();

		while (hi < S.length()) {

			// if the char is a distinct character
			if (++charmap[S.charAt(hi)] == 1) {

				// increment distinct counter
				distinct++;

				// if distinct char count is more than K then remove the charAt(lo)
				// assumption is while we decrement the charAt(lo), distinct char will also be
				// decremented
				if (distinct > k) {
					charmap[S.charAt(lo)]--;

					// as we removed charAt(lo), increment lo to next char
					lo++;

					// based on the assumption above
					distinct--;
				}
			}
			// if the char is not a distinct character
			else {

				// keep removing the charAt(lo) until charAt(hi) is 1 i.e. distinct
				while (charmap[S.charAt(hi)] != 1) {
					charmap[S.charAt(lo)]--;
					// while removing the charAt(lo) if the count becomes 0 that means we need to
					// decrement distinct count
					if (charmap[S.charAt(lo)] == 0)
						distinct--;
					lo++;
				}
			}
			// At last check if we have a substring of size k with k distinct characters
			if (hi - lo + 1 == k && distinct == k) {
				set.add(S.substring(lo, hi + 1));
			}
			hi++;
		}

		return new ArrayList<>(set);
	}

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
