package org.handsoncoder.leetcode.easy;

//2
import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. Meeting Rooms
 * 
 * Amazon | 4
 * 
 * Facebook | 3
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * Example 1:
 * 
 * Input: [[0,30],[5,10],[15,20]] Output: false Example 2:
 * 
 * Input: [[7,10],[2,4]] Output: true *
 */
public class MeetingRooms {
	public static boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start)
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(MeetingRooms.canAttendMeetings(
				new Interval[] { new Interval(22, 23), new Interval(15, 21), new Interval(20, 21) }));
		System.out.println(MeetingRooms.canAttendMeetings(
				new Interval[] { new Interval(22, 23), new Interval(15, 17), new Interval(20, 21) }));
	}
}
