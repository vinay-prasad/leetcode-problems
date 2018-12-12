package org.handsoncoder.leetcode.hard;

public class LongestSubstringWithAtMost2DistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left=0, right=0, maxLength =0, distinctChars =0, k =2;
        int charMap[] = new int[256];
        while (right < s.length()) {
            char c = s.charAt(right);
            charMap[c]++;
            if (charMap[c] ==1) {
                distinctChars++;
            }
            
            if (distinctChars <= k) {
                maxLength = Math.max(maxLength,  right - left + 1);
            }else {
                while(distinctChars!=k){
                    char cL = s.charAt(left);
                    charMap[cL]--;
                    if (charMap[cL] == 0) {
                        distinctChars--;
                    }
                    left++;
                }
            }
            right++;
        } 
        return maxLength;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
