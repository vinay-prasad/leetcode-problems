package org.handsoncoder.leetcode.ikm;

import java.util.Locale;

class Parent1 {
	protected static int count =0;
	public Parent1 () {
		count++;
	}
	static int getCount() {
		return count;
	}
}
public class Child extends Parent1 {
	public Child() {
		count++;
	}
	public static void main (String args[]) {
		
	
	System.out.println(" " +getCount());
	Child obj = new Child();
	System.out.println(" " +getCount());
	System.console();
	//System.out.println(args[0]);
	Locale l = new Locale ("USA");
	System.out.println(l.getCountry());
	
	int x =0, y=4, z =5;
	if (x>0)
		if(y<3)
			System.out.println("One");
		else if (y <4)
			System.out.println("Two");
		else if (z>5)
			System.out.println("Three");
		else
	System.out.println("Four");
	}
}
