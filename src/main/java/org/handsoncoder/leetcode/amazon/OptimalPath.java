package org.handsoncoder.leetcode.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalPath {

	List<List<Integer>> optimalUtilization(int maxTravelDistance, List<List<Integer>> fwdRoute,
			List<List<Integer>> retRoute) {
		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		int currentMaxTravelDistance = 0;
		for (int f = 0; f < fwdRoute.size(); f++) {
			for (int r = 0; r < retRoute.size(); r++) {
				int total = (fwdRoute.get(f).get(1) + retRoute.get(r).get(1));
				if ((total <= maxTravelDistance) && (total > currentMaxTravelDistance)) {
					currentMaxTravelDistance = total;
					List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
					listOfList.add(new ArrayList<>(Arrays.asList(fwdRoute.get(f).get(0), retRoute.get(r).get(0))));
					map.put(total, listOfList);
				} else if ((total <= maxTravelDistance) && (total == currentMaxTravelDistance)) {
					List<List<Integer>> listOfList = map.get(total);
					listOfList.add(new ArrayList<>(Arrays.asList(fwdRoute.get(f).get(0), retRoute.get(r).get(0))));
				} else {
					map.remove(total);
				}
			}
		}
		return map.get(currentMaxTravelDistance) != null ? map.get(currentMaxTravelDistance)
				: new ArrayList<List<Integer>>();
	}

	public static void main(String[] args) {
		OptimalPath testObj = new OptimalPath();

		List<List<Integer>> fwdRoute;
		List<List<Integer>> retRoute;
		List<List<Integer>> result;

		fwdRoute = new ArrayList<List<Integer>>();
		fwdRoute.add(new ArrayList<>(Arrays.asList(1, 2000)));
		fwdRoute.add(new ArrayList<>(Arrays.asList(2, 4000)));
		fwdRoute.add(new ArrayList<>(Arrays.asList(3, 6000)));

		retRoute = new ArrayList<List<Integer>>();
		retRoute.add(new ArrayList<>(Arrays.asList(1, 2000)));

		result = testObj.optimalUtilization(7000, fwdRoute, retRoute);
		System.out.println(result);

		fwdRoute = new ArrayList<List<Integer>>();
		fwdRoute.add(new ArrayList<>(Arrays.asList(1, 3000)));
		fwdRoute.add(new ArrayList<>(Arrays.asList(2, 5000)));
		fwdRoute.add(new ArrayList<>(Arrays.asList(3, 7000)));
		fwdRoute.add(new ArrayList<>(Arrays.asList(4, 10000)));

		retRoute = new ArrayList<List<Integer>>();
		retRoute.add(new ArrayList<>(Arrays.asList(1, 2000)));
		retRoute.add(new ArrayList<>(Arrays.asList(2, 3000)));
		retRoute.add(new ArrayList<>(Arrays.asList(3, 4000)));
		retRoute.add(new ArrayList<>(Arrays.asList(4, 5000)));

		result = testObj.optimalUtilization(10000, fwdRoute, retRoute);
		System.out.println(result);

		fwdRoute = new ArrayList<List<Integer>>();
		fwdRoute.add(new ArrayList<>(Arrays.asList(1, 8)));
		fwdRoute.add(new ArrayList<>(Arrays.asList(2, 15)));
		fwdRoute.add(new ArrayList<>(Arrays.asList(3, 9)));

		retRoute = new ArrayList<List<Integer>>();
		retRoute.add(new ArrayList<>(Arrays.asList(1, 8)));
		retRoute.add(new ArrayList<>(Arrays.asList(2, 11)));
		retRoute.add(new ArrayList<>(Arrays.asList(3, 12)));

		result = testObj.optimalUtilization(20, fwdRoute, retRoute);
		System.out.println(result);

	}

}
