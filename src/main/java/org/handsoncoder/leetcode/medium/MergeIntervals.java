package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty() || intervals.size() == 1) {
			return intervals;
		}
		List<Interval> result = new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		int i = 0;
		while (i < intervals.size() - 1) {
			if (intervals.get(i).end > intervals.get(i + 1).start) {
				result.add(new Interval(intervals.get(i).start,
						intervals.get(i + 1).end > intervals.get(i).end ? intervals.get(i + 1).end
								: intervals.get(i).end));
				i = i + 2;
			} else {
				result.add(intervals.get(i));
				i = i + 1;
			}
		}
		if (i < intervals.size())
			result.add(intervals.get(intervals.size() - 1));
		return result;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(2, 6));
		input.add(new Interval(8, 10));
		input.add(new Interval(15, 18));
		MergeIntervals testObj = new MergeIntervals();
		testObj.merge(input);
	}
}
