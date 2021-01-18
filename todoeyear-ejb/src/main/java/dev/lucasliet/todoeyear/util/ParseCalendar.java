package dev.lucasliet.todoeyear.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParseCalendar {
	public static Calendar stringToCalendar(String deadline) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(deadline);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}	
	}
	
	public static String calendarToString(Calendar deadline) {
		return new SimpleDateFormat("dd/MM/yyyy").format(deadline.getTime());
	}
}
