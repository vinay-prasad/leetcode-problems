package org.handsoncoder.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

//Pat your back
/**
 * 937. Reorder Log Files Amazon | 2
 * 
 * 
 * 
 * You have an array of logs. Each log is a space delimited string of words.
 * 
 * For each log, the first word in each log is an alphanumeric identifier. Then,
 * either:
 * 
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits. We will call
 * these two varieties of logs letter-logs and digit-logs. It is guaranteed that
 * each log has at least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the
 * identifier used in case of ties. The digit-logs should be put in their
 * original order.
 * 
 * Return the final order of the logs.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * 
 * 
 * Note:
 * 
 * 0 <= logs.length <= 100 3 <= logs[i].length <= 100 logs[i] is guaranteed to
 * have an identifier, and a word after the identifier. *
 */
public class ReorderLogFiles {

	public static String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new Comparator<String>() {
			String reg = "[0-9]+";

			public int compare(String o1, String o2) {
				String o1Sub = o1.substring(o1.indexOf(" ") + 1, o1.length());
				String o2Sub = o2.substring(o2.indexOf(" ") + 1, o2.length());
				if ((new String(o1Sub.charAt(0) + "").matches(reg))
						&& (new String(o2Sub.charAt(0) + "").matches(reg))) {
					return 0;
				} else if ((new String(o1Sub.charAt(0) + "").matches(reg))) {
					return 1;
				} else if ((new String(o2Sub.charAt(0) + "").matches(reg))) {
					return -1;
				} else {
					int x = o1Sub.compareTo(o2Sub);
					return x;
				}
			}
		});
		return logs;
	}

	public static void main(String[] args) {
		// String [] arr = new String[] {"acb", "abc"};
		// System.out.println("abc".compareTo("abc"));
		// System.out.println("abc".compareTo("acb"));
		// Arrays.sort(arr);
		// System.out.println(Arrays.toString(arr));

		System.out.println(Arrays
				.toString(new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" }));

		System.out.println(Arrays.toString(reorderLogFiles(
				new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" })));

	}

}
