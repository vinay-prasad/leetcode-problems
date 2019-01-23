package org.handsoncoder.leetcode.amazon;

import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.RandomAccess;
import java.util.Set;

public class A {
	static int total = 10;

	static class Helper {
		private int data = 5;

		public void bump(int inc) {
			inc++;
			data = data + inc;
			System.out.println(inc);
		}
	}

	public void call() {
		int total = 5;
		System.out.println(this.total);

	}

	public Integer call1() {
		return 5;

	}

	public void call2(Integer i2) {

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, FileNotFoundException {
		A a1 = new A();
		a1.call();
		// Runtime.getRuntime().getM
		Class c = a1.getClass();
		System.out.println(c.getMethod("call1", null).toString());
		// System.out.println(c.getMethod("call2", null).toString());

		String str1 = "Vinay";
		String str2 = new String("Vinay");
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
		System.out.println(str1.matches(str2));
		System.out.println(str1.hashCode() == str2.hashCode());
		Helper h = new Helper();
		int data = 2;
		h.bump(data);
		System.out.println(h.data + " " + data);

		data += 3;
		data = data >> 1;

		GregorianCalendar gc = new GregorianCalendar();
		gc.isLeapYear(2018);

		Calendar c1 = Calendar.getInstance();
		c1.set(2018, Calendar.FEBRUARY, 1);

		//String f = "file1.java";
		//File f1 = new File(f);
		//Reader iout = new FileReader(f1);
		//InputStream i = new FileInputStream(f1);
		///InputStream i2 = new InputStream(f1);
		//FileOutputStream fo = new FileOutputStream(f1);
		//
		Runtime.getRuntime().totalMemory();
		Runtime.getRuntime().maxMemory();
		//Runtime.getRuntime().fre
		
		//new PrintWriter("");
		// new Writer();
		//new FilterReader() {};
		// new OutputStream(
		
		
		Long l1 = new Long(10);
		long l2 = 10;
		System.out.println(l1.equals(l2));
		
		int j = 0;
		int a[] = {2,4};
		do for (int i : a)
			System.out.println(i+" ");
		while(j++ < 1);
		
		//System.out.println(args);System.out.println(args[1]);
		Set <String> set = new LinkedHashSet<>();
		set.add("1");
		set.add("2");
		set.add("0");
		System.out.println(set);
		System.out.println(Math.round(10.55));
		System.out.println(Math.nextUp(10.22));
		System.out.println(Math.floor(10.99));
		System.out.println(Math.random());
		System.out.println(Math.nextAfter(10.22,0.01));
		new Locale("en");
		new Locale.Builder().setLanguageTag("en").setRegion("GB").build();
	}

}
