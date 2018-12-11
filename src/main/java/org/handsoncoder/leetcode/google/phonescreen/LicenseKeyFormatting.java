package org.handsoncoder.leetcode.google.phonescreen;

public class LicenseKeyFormatting {

	public String licenseKeyFormatting(String S, int K) {
		StringBuffer strBuff = new StringBuffer();
		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) != '-') {
				strBuff.append(strBuff.length() % (K + 1) == K ? "-"+S.charAt(i) : S.charAt(i));
			}
		}
		return strBuff.reverse().toString().toUpperCase();
	}

	public static void main(String[] args) {
		LicenseKeyFormatting testObj = new LicenseKeyFormatting();
		String S = "5F3Z-2e-9-w";
		int K = 4;
		
		System.out.println(testObj.licenseKeyFormatting(S, K));
		
		S = "2-5g-3-J"; K = 2;
		System.out.println(testObj.licenseKeyFormatting(S, K));
		
		S = "2-4A0r7-4k"; K = 4;
		System.out.println(testObj.licenseKeyFormatting(S, K));
		
		S = "r"; K = 1;
		System.out.println(testObj.licenseKeyFormatting(S, K));
	}

}
