package dev.lucasliet.todoeyear.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParseCalendar {
	public static Calendar stringToCalendar(String deadline) throws ParseException {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(deadline);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
	}
	
	public static String calendarToString(Calendar deadline) {
		return new SimpleDateFormat("dd/MM/yyyy").format(deadline.getTime());
	}
}
