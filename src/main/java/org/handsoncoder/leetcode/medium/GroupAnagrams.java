package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	 public List<List<String>> groupAnagrams(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        for (String s : strs) {
	            char[] ca = s.toCharArray();
	            Arrays.sort(ca);
	            String key = String.valueOf(ca);
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }

	public List<List<String>> groupAnagrams1(String[] strs) {

		HashMap<String, List<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();
		int[] charMap;

		for (String str : strs) {
			charMap = new int[256];
			for (char c : str.toCharArray()) {
				charMap[c]++;
			}
			String key = Arrays.toString(charMap);
			List<String> list = null;
			if (!map.containsKey(key)) {
				list = new ArrayList<>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}
		for (List<String> list : map.values()) {
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		GroupAnagrams testObj = new GroupAnagrams();
		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		testObj.groupAnagrams(strs);

	}

}
