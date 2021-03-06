package org.handsoncoder.leetcode.medium;

import java.util.ArrayList;
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
		result.add(intervals.get(i++));
		while (i < intervals.size()) {
			if (result.get(result.size() - 1).end >= intervals.get(i).start) {
				Interval last = result.remove(result.size() - 1);
				result.add(new Interval(last.start, (intervals.get(i).end > last.end) ? intervals.get(i).end: last.end ));
				i++;
			} else {
				result.add(intervals.get(i));
				i++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(2, 6));
		input.add(new Interval(8, 10));
		input.add(new Interval(15, 18));
		MergeIntervals testObj = new MergeIntervals();
		List<Interval> result = testObj.merge(input);

		// [[1,4],[0,2],[3,5]]
	}
}
