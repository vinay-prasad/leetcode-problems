package org.handsoncoder.leetcode.easy;

public class SumOfTwoIntegersBitwise {
	public int getSum(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

	public int getSub(int a, int b) {
		while (b != 0) {
			int borrow = ~a & b;
			a = a ^ b;
			b = borrow << 1;
		}
		return a;
	}
	public static void main(String[] args) {
		SumOfTwoIntegersBitwise testObj = new SumOfTwoIntegersBitwise();
		System.out.println(testObj.getSum(4, 5));
		
		System.out.println(testObj.getSub(-5,4));
	}
}
