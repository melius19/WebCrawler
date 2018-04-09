package CHAP10;

import java.util.Calendar;

public class CalendarEx1 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.MONTH));
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.HOUR));
		System.out.println(today.get(Calendar.MINUTE));
		long toMil = today.getTimeInMillis();

		System.out.println();
		Calendar thday = Calendar.getInstance();
		thday.set(2016, 11, 14);
		System.out.println(thday.get(Calendar.YEAR));
		System.out.println(thday.get(Calendar.MONTH));
		System.out.println(thday.get(Calendar.DATE));
		System.out.println(thday.get(Calendar.HOUR));
		System.out.println(thday.get(Calendar.MINUTE));
		long thMil = thday.getTimeInMillis();

		System.out.println((toMil - thMil) / 1000 / 60 / 60 / 24);
	}
}
