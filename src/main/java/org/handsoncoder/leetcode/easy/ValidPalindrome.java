package org.handsoncoder.leetcode.easy;

public class ValidPalindrome {
	public boolean isPalindrome1(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (!(isAlphaNumeric(s.charAt(left)))) {
				left++;
			} else if (!(isAlphaNumeric(s.charAt(right)))) {
				right--;
			} else if (!(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)))) {
				return false;
			} else {
                left++;
                right--;
            }
            
		}
		return true;
	}
     private boolean isAlphaNumeric(char c){
        return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
    }
	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (!(Character.isDigit(s.charAt(left)) || Character.isLetter(s.charAt(left)))) {
				left++;
			} else if (!(Character.isDigit(s.charAt(right)) || Character.isLetter(s.charAt(right)))) {
				right--;
			} else if (!(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)))) {
				return false;
			} else {
                left++;
                right--;
            }
            
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
