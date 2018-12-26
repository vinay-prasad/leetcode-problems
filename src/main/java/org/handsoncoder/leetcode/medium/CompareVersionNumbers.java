package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CompareVersionNumbers {
	// better solution
	public int compareVersion(String version1, String version2) {
        String[] value1 = version1.split("\\.");
        String[] value2 = version2.split("\\.");
        
        int l1 = value1.length;
        int l2 = value2.length;
               
        for (int i = 0; i< Math.max(l1,l2); i++) {
            int num1 = (i < l1)? Integer.valueOf(value1[i]):0;
            int num2 = (i < l2)? Integer.valueOf(value2[i]):0;
            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
            else continue;
        }
       return 0; 
    }
	
	// Working but bad
	public int compareVersion1(String version1, String version2) {
		List<Integer> v1 = new ArrayList<>();
		List<Integer> v2 = new ArrayList<>();
		for (String str : version1.split(Pattern.quote("."))) {
			v1.add(Integer.parseInt(str));
		}

		for (String str : version2.split(Pattern.quote("."))) {
			v2.add(Integer.parseInt(str));
		}
		int count = 0;
		System.out.println(v1.size() + " size " + v2.size());
		while (count < v1.size() && count < v2.size()) {
			System.out.println(v1.get(count) + " value " + v2.get(count));
			if (v1.get(count) > v2.get(count)) {
				return 1;
			} else if (v1.get(count) < v2.get(count)) {
				return -1;
			}
			count++;
		}
		if (count < v1.size()) {
			return 1;
		} else if (count < v2.size()) {
			return -1;
		} else
			return 0;
	}

	public static void main(String[] args) {

		CompareVersionNumbers testObj = new CompareVersionNumbers();
		String version1 = "0.1";
		String version2 = "1.1";
		System.out.println(testObj.compareVersion(version1, version2));

	}

}
