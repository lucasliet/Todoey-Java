package dev.lucasliet.todoeyear.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Parse {@link Calendar} and {@link String} formats
 * @author Lucas Souza <lucasouliveira@gmail.com>
 */
public class ParseCalendar {
	/**
	 * It throws a {@link ParseException} if string
	 * format is not in "dd/MM/yyyy", handle it!
	 * @param date string in "dd/MM/yyyy" format
	 * @return calendar
	 * @throws ParseException
	 */
	public static Calendar stringToCalendar(String deadline) throws ParseException {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(deadline);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
	}
	
	/**
	 * @param calendar
	 * @return string in "dd/MM/yyyy" format
	 */
	public static String calendarToString(Calendar deadline) {
		return new SimpleDateFormat("dd/MM/yyyy").format(deadline.getTime());
	}
}

	