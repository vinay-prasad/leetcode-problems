package org.handsoncoder.leetcode.medium;

public class DivideTwoIntegers {
	public int divide1(int dividend, int divisor) {
		int carry = 1;
		if (dividend < 0 && divisor < 0) {

			dividend = dividend * -1;
			divisor = divisor * -1;

		} else if (dividend < 0 || divisor < 0) {
			if (dividend < 0) {
				dividend = dividend * -1;
			} else {
				divisor = divisor * -1;
			}
			carry = -1;
		}
		int currMul = 1;
		int nextMul = 1;
		int start = 0;
		while (true) {
			currMul = start * divisor;
			nextMul = ++start * divisor;
			if (currMul == dividend) {
				return --start * carry;
			} else if (nextMul == dividend) {
				return start * carry;
			} else if (!(currMul > dividend && currMul < nextMul)) {
				return --start * carry;
			}
		}

	}

	public static int divide(int dividend, int divisor) {
		long newDivisor = divisor;
		long newDivident = dividend;

//Calculate sign of divisor  
//i.e., sign will be negative  
//only iff either one of them  
//is negative otherwise it  
//will be positive 
		// -10 3
		// true ^ false
		// -10/ -3
		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

//remove sign of operands 
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

//Initialize the quotient 
		int quotient = 0, temp = 0;

//test down from the highest  
//bit and accumulate the  
//tentative value for 
//valid bit 
		for (int i = 32; i >= 0; --i) {
			System.out.println(dividend << i);
			if (temp + (divisor << i) <= dividend) {
				temp += divisor << i;
				quotient |= 1 << i;
			}
		}

		return (sign * quotient);
	}

	public static void main(String[] args) {
		System.out.println(" >>>" +DivideTwoIntegers.divide(10, 3));
	}

}
