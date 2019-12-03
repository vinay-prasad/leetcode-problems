package org.handsoncoder.amazon.oa;

import java.util.Arrays;

/*
 * #5
 * for given array "inputArray" of length "size" find the sum of all disitinct elements
 * */

public class Distinct {
	
	public static int sumDistinct (int size, int[] inputArray) {
		Arrays.sort(inputArray);
		int sum = inputArray[0];
		int point = inputArray[0];
		
		for (int i =1; i< size; i++) {
			if (point!=inputArray[i]) {
				sum +=inputArray[i];
				point = inputArray[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int [] arr = {1,1,2,3,3,4,4,5};
		System.out.println(Distinct.sumDistinct(8, arr));

	}

}
