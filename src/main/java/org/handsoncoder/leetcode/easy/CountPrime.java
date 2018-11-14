package org.handsoncoder.leetcode.easy;

// #innovative #inspired #Sieve of Eratosthenes #Sqrt2  
public class CountPrime {

	// start with 2 and set all multiples of 2 as NOT PRIME
	// Do the same for 3, 5, 7 until n
	public static int countPrimes(int n) {

		boolean notPrimes[] = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (notPrimes[i] == false) {
				count++;
				for (int j = 2; i * j < n; j = j + 1) {
					notPrimes[i*j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(10));

	}

}
