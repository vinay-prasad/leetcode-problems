package org.handsoncoder.amazon.oa;

import java.util.Arrays;
/*
 * #1
 * For given array "arr", sort it in descending order
 * */

public class ArraySort {

	public static int[] sortArray(int arr[]) {
		int i, max, location, j, temp, len = arr.length;
		for (i = 0; i < len; i++) {
			max = arr[i];
			location = i;
			for (j = i; j < len; j++) {
				// previous max is less than current element then it needs to be replaced
				// if (max > arr[j]) {
				if (max < arr[j]) {
					max = arr[j];
					location = j;
				}
			}

			temp = arr[i];
			arr[i] = arr[location];
			arr[location] = temp;
		}
		return arr;

	}

	public static void main(String[] args) {
		int arr[] = { 2, 5, 3, 7, 1 };
		int res[] = ArraySort.sortArray(arr);
		System.out.println(Arrays.toString(res));

	}

}
