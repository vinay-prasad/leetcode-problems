package org.handsoncoder.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NearestRestaurants {

	List<List<Integer>> nearestLocations(int totalLocations, List<List<Integer>> allLocations, int numOfLocations) {

		System.out.println(allLocations.toString());

		Collections.sort(allLocations, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				int o1a = o1.get(0);
				int o1b = o1.get(1);
				int o2a = o2.get(0);
				int o2b = o2.get(1);

				int o1Sum = ((o1a * o1a) + (o1b * o1b));
				int o2Sum = ((o2a * o2a) + (o2b * o2b));
				if (o1Sum == o2Sum) {
					return o2a - o1a;
				} else
					return o1Sum - o2Sum;
			}
		});

		return allLocations.subList(0, numOfLocations);

	}

	public static void main(String[] args) {
		List<List<Integer>> allLocations = new ArrayList<List<Integer>>();
		allLocations.add(Arrays.asList(new Integer[] { 1, -3 })); // 10
		allLocations.add(Arrays.asList(new Integer[] { 1, 2 })); // 5
		allLocations.add(Arrays.asList(new Integer[] { 3, 4 })); // 25

		NearestRestaurants testObj = new NearestRestaurants();
		System.out.println(testObj.nearestLocations(3, allLocations, 1));

		allLocations = new ArrayList<List<Integer>>();
		allLocations.add(Arrays.asList(new Integer[] { 3, 6 })); // 45
		allLocations.add(Arrays.asList(new Integer[] { 2, 4 })); // 20
		allLocations.add(Arrays.asList(new Integer[] { 2, 7 })); // 53
		allLocations.add(Arrays.asList(new Integer[] { 1, 8 })); // 65
		allLocations.add(Arrays.asList(new Integer[] { 7, 9 })); // 144
		allLocations.add(Arrays.asList(new Integer[] { 5, 3 })); // 34

		System.out.println(testObj.nearestLocations(6, allLocations, 3));

	}

}
