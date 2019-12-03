package org.handsoncoder.amazon.oa;

/*
 * # 3
 * For given input array "arr" and integer "num", find how many elements are greater than 2 * num (twice of num)
 * 
 * */
public class ElementCount {

	public static int countElement(int arr[], int n) {
		int count = 0, len = arr.length;
		int doubleN = 2 * n;
		// For loop needs to be bound with len despite of n as the result has to be
		// found out from the input array. Secondly we need to increment the counter so
		// that we can correctly iterate through all the elements and terminate from the
		// loop gracefully
		// for (int i = 0; i < n; ) {
		for (int i = 0; i < len; i++) {
			if (arr[i] > doubleN) {
				count += 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 6, 8, 9, 11 };
		System.out.println(ElementCount.countElement(arr, 2));

	}

}
