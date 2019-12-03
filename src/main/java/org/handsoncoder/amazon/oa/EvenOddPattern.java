package org.handsoncoder.amazon.oa;

public class EvenOddPattern {

	public static void printPattern(int num) {
		int i, print = 0;
		if (num % 2 == 0) {
			print = 0;
			// In both for loops there is problem with scope of for loop need to add the
			// parenthesis for correct results
			for (i = 0; i < num; i++) // {
				System.out.println(print + " ");
			print += 2;
			// }
		} else {
			print = 1;
			// In both for loops there is problem with scope of for loop need to add the
			// parenthesis for correct results
			for (i = 0; i < num; i++) // {
				System.out.println(print + " ");
			print += 2;
			// }

		}
	}

	public static void main(String[] args) {
		EvenOddPattern.printPattern(3);
	}

}
