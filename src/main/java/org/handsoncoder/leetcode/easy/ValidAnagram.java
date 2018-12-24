package org.handsoncoder.leetcode.easy;

import java.util.Arrays;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if ((s == null ^ t == null) || (s.isEmpty() ^ t.isEmpty()) || (s.length() != t.length())) {
			return false;
		}
		if ((s == null && t == null) || (s.isEmpty() && t.isEmpty())) {
			return true;
		}
		char[] charArrS = s.toCharArray();
		char[] charArrT = t.toCharArray();
		Arrays.sort(charArrS);
		Arrays.sort(charArrT);

		int p = 0;

		while (p < s.length()) {
			if (charArrS[p] != charArrT[p]) {
				return false;
			}
			p++;
		}
		return true;
	}
	
	//better
	 public boolean isAnagram1(String s, String t) {
	        if ((s ==null ^ t == null) || (  s.isEmpty() ^ t.isEmpty()) || (s.length() != t.length())) {
	        return false;
	        } else if ((s ==null && t == null) || (  s.isEmpty() && t.isEmpty())){
	        return true;
	        }

	        int [] charMapS = new int[256];
	        int [] charMapT = new int[256]; 
	       
	        for (char c : s.toCharArray()) {
	            charMapS[c]++;
	        }
	        for (char c : t.toCharArray()) {
	            charMapT[c]++;
	        }
	        
	        int i =0;
	        while (i <256) {
	            if (charMapS[i]!=charMapT[i]) {
	                return false;
	            }
	            i++;
	        }
	       return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
