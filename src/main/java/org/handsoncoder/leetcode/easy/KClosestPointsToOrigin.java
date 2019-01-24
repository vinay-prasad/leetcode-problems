package org.handsoncoder.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		if (points == null || points.length < K) {
			return null;
		}
		Arrays.sort(points, (new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
			}
		}));

		return Arrays.copyOfRange(points, 0, K);
	}

	public static void main(String[] args) {
		int[][] input = new int[][] { { -5, 4 }, { -6, -5 }, { 4, 6 } };
		KClosestPointsToOrigin testObj = new KClosestPointsToOrigin();
		int[][] res = testObj.kClosest(input, 1);
		System.out.println(Arrays.toString(res));
	}
}
