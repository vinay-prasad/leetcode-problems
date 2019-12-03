package org.handsoncoder.amazon.oa;

/*
 * #4
 * For given marks return the grade based on below rules
 * marks >= 91 - A
 * marks between 76-90 - B
 * marks between 61 -75 - C
 * marks <= 60 - D
 * */
public class GradingSystem {

	public static char GradingSystem(int marks) {
		if (marks <= 60)
			return 'D';
		// Use of logical operator || OR is wrong here we need to check for both the
		// boundary condition using && AND operator
		// else if ((61 <= marks) || (marks <= 75))
		else if ((61 <= marks) && (marks <= 75))
			return 'C';
		// else if ((76 <= marks) || (marks <= 90))
		else if ((76 <= marks) && (marks <= 90))
			return 'B';
		else
			return 'A';

	}

	public static void main(String[] args) {
		System.out.println("60 - " + GradingSystem(60));
		System.out.println("70 - " + GradingSystem(70));
		System.out.println("80 - " + GradingSystem(80));
		System.out.println("90 - " + GradingSystem(90));
		System.out.println("94 - " + GradingSystem(94));
	}
}
