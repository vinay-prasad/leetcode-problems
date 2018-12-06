package org.handsoncoder.leetcode.google.phonescreen;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
	public String nextClosestTime(String time) {

		Set<Integer> set = new HashSet<>();
		String[] strArr = time.split(":");
		int hour = Integer.parseInt(strArr[0]);
		int min = Integer.parseInt(strArr[1]);
		set.add(hour / 10);
		set.add(hour % 10);
		set.add(min / 10);
		set.add(min % 10);

		while (true) {
			min++;
			if (min == 60) {
				hour = hour + 1;
				if (hour == 24) {
					hour = 0;
				}
				min = 00;
			}
			if (set.contains(min % 10) && set.contains(min / 10) && set.contains(hour % 10) && set.contains(hour / 10)) {
				return (hour<10 ?"0"+hour:hour) + ":" + (min<10 ?"0"+min:min);
			}
		}
	}

	public static void main(String[] args) {
		NextClosestTime testObj = new NextClosestTime();
		System.out.println(testObj.nextClosestTime("23:59"));

	}

}
